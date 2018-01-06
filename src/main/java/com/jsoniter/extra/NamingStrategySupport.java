package com.jsoniter.extra;

import com.jsoniter.spi.Binding;
import com.jsoniter.spi.ClassDescriptor;
import com.jsoniter.spi.EmptyExtension;
import com.jsoniter.spi.JsonException;
import com.jsoniter.spi.JsoniterSpi;

/**
 * Public Class NamingStrategy.
 * 
 * @author MaxiBon
 *
 */
public class NamingStrategySupport {

	private NamingStrategySupport() {
	}

	/**
	 * Public Interface NamingStrategy.
	 * 
	 * @author MaxiBon
	 *
	 */
	public interface NamingStrategy {
		/**
		 * String translate(String input);
		 * 
		 * @author MaxiBon
		 *
		 */

		String translate(String input);
	}

	/**
	 * public static NamingStrategy SNAKE_CASE = new NamingStrategy()
	 * 
	 * @author MaxiBon
	 *
	 */
	public static NamingStrategy SNAKE_CASE = new NamingStrategy() {
		@Override
		public String translate(String input) {
			if (input == null) {
				return input; // garbage in, garbage out
			}

			int length = input.length();
			int n = length*2;
			StringBuilder result = new StringBuilder(n);
			int resultLength = 0;
			boolean wasPrevTranslated = false;
			for (int i = 0; i < length; i++) {
				char c = input.charAt(i);
				if (i > 0 || c != '_') // skip first starting underscore
				{
					if (Character.isUpperCase(c)) {
						if (!wasPrevTranslated && resultLength > 0 && result.charAt(resultLength - 1) != '_') {
							result.append('_');
							resultLength++;
						}
						c = Character.toLowerCase(c);
						wasPrevTranslated = true;
					} else {
						wasPrevTranslated = false;
					}
					result.append(c);
					resultLength++;
				}
			}
			return resultLength > 0 ? result.toString() : input;
		}
	};

	/**
	 * public static NamingStrategy UPPER_CAMEL_CASE = new NamingStrategy()
	 * 
	 * @author MaxiBon
	 *
	 */
	public NamingStrategy UPPER_CAMEL_CASE = new NamingStrategy() {
		@Override
		public String translate(String input) {
			if (input == null || input.length() == 0) {
				return input; // garbage in, garbage out
			}
			// Replace first lower-case letter with upper-case equivalent
			char c = input.charAt(0);
			char uc = Character.toUpperCase(c);
			if (c == uc) {
				return input;
			}
			StringBuilder sb = new StringBuilder(input);
			sb.setCharAt(0, uc);
			return sb.toString();
		}
	};

	/**
	 * public static NamingStrategy LOWER_CASE = new NamingStrategy()
	 * 
	 * @author MaxiBon
	 *
	 */
	public NamingStrategy LOWER_CASE = new NamingStrategy() {
		@Override
		public String translate(String input) {
			return input.toLowerCase();
		}
	};

	/**
	 * public NamingStrategy KEBAB_CASE = new NamingStrategy()
	 * 
	 * @author MaxiBon
	 *
	 */
	public NamingStrategy KEBAB_CASE = new NamingStrategy() {
		@Override
		public String translate(String input) {
			if (input == null) {
				return input; // garbage in, garbage out
			}

			int length = input.length();
			if (length == 0) {
				return input;
			}

			StringBuilder result = new StringBuilder(length + (length >> 1));

			int upperCount = 0;

			for (int i = 0; i < length; ++i) {
				char ch = input.charAt(i);
				char lc = Character.toLowerCase(ch);

				if (lc == ch) { // lower-case letter means we can get new word
					// but need to check for multi-letter upper-case (acronym),
					// where assumption
					// is that the last upper-case char is start of a new word
					if (upperCount > 1) {
						// so insert hyphen before the last character now
						result.insert(result.length() - 1, '-');
					}
					upperCount = 0;
				} else {
					// Otherwise starts new word, unless beginning of string
					if ((upperCount == 0) && (i > 0)) {
						result.append('-');
					}
					++upperCount;
				}
				result.append(lc);
			}
			return result.toString();
		}
	};

	/**
	 * enable
	 * 
	 */
	public static void enable(final NamingStrategy namingStrategy) {
		boolean enabled = false;
		synchronized (NamingStrategySupport.class) {
			if (enabled) {
				throw new JsonException("NamingStrategySupport.enable can only be called once");
			}
			enabled = true;
			JsoniterSpi.registerExtension(new EmptyExtension() {
				/**
				 * public void updateClassDescriptor(ClassDescriptor desc)
				 * 
				 * @author MaxiBon
				 *
				 */
				@Override
				public void updateClassDescriptor(ClassDescriptor desc) {
					for (Binding binding : desc.allBindings()) {
						String translated = namingStrategy.translate(binding.name);
						binding.toNames = new String[] { translated };
						binding.fromNames = new String[] { translated };
					}
				}
			});
		}
	}

}
