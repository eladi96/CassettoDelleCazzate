package com.jsoniter;

import java.io.IOException;

/**
 * 
 * @author MaxiBon
 *
 */
class IterImplSkip {

	private IterImplSkip() {
	}

	/**
	 * 
	 */
	static final boolean[] breaks = new boolean[127];

	static {
		breaks[' '] = true;
		breaks['\t'] = true;
		breaks['\n'] = true;
		breaks['\r'] = true;
		breaks[','] = true;
		breaks['}'] = true;
		breaks[']'] = true;
	}

	/**
	 * skip
	 * 
	 * @param iter
	 * @throws IOException
	 */
	public static final void skip(JsonIterator iter) throws IOException {
		int[] n = {3, 4};
		byte c = IterImpl.nextToken(iter);
		byte[] skip = "-0123456789".getBytes();
		subSkip(iter, skip, c);
		if(c == '"') {
			IterImpl.skipString(iter);
		} else if(c=='n') {
			IterImpl.skipFixedBytes(iter, n[0]); // true or null
		} else if(c=='f') {
			IterImpl.skipFixedBytes(iter, n[1]); // false
		} else if(c=='[') {
			IterImpl.skipArray(iter);
		} else if(c=='{') {
			IterImpl.skipObject(iter);
		} else {
			throw iter.reportError("IterImplSkip", "do not know how to skip: " + c);
		}

	}
	
	private static void subSkip(JsonIterator iter, byte[] skip, byte c) throws IOException {
		for(int i = 0; i<skip.length; i++) {
			if(c == skip[i]) {
				IterImpl.skipUntilBreak(iter);
			}
		}
	}

	// adapted from: https://github.com/buger/jsonparser/blob/master/parser.go
	// Tries to find the end of string
	// Support if string contains escaped quote symbols.
	final static int findStringEnd(JsonIterator iter) {
		boolean escaped = false;
		for (int i = iter.head; i < iter.tail; i++) {
			if (iter.buf[i] == '"') {
				if (!escaped) {
					return i + 1;
				} else {
					for (int j = i - 1;;) {
						if (j < iter.head || iter.buf[j] != '\\') {
							// even number of backslashes
							// either end of buffer, or " found
							return i + 1;
						}
						j--;
						if (j < iter.head || iter.buf[j] != '\\') {
							// odd number of backslashes
							// it is \" or \\\"
							break;
						}
						j--;
					}
				}
			} else if (iter.buf[i] == '\\') {
				escaped = true;
			}
		}
		return -1;
	}
}
