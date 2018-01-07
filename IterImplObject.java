package com.jsoniter;

import java.io.IOException;

/**
 * class IterImplObject
 * 
 * @author MaxiBon
 *
 */
class IterImplObject {

	private IterImplObject() {
	}

	final static String readObject = "readObject";
	final static String expect = "expect :";
	
	/**
	 * readObject
	 * 
	 * @param iter
	 * @return
	 * @throws IOException
	 */
	public static final String funReadObject(JsonIterator iter) throws IOException {
		byte c = IterImpl.nextToken(iter);
		switch (c) {
		case 'n':
			int n = 3;
			IterImpl.skipFixedBytes(iter, n);
			return null;
		case '{':
			c = IterImpl.nextToken(iter);
			if (c == '"') {
				iter.unreadByte();
				String field = iter.readString();
				if (IterImpl.nextToken(iter) != ':') {
					
					throw iter.reportError(readObject, expect);
				}
				return field;
			}
			if (c == '}') {
				return null; // end of object
			}
			throw iter.reportError(readObject, "expect \" after {");
		case ',':
			String field = iter.readString();
			if (IterImpl.nextToken(iter) != ':') {
				throw iter.reportError(readObject, expect);
			}
			return field;
		case '}':
			return null; // end of object
		default:
			throw iter.reportError("readObject", "expect { or , or } or n, but found: " + Byte.toString(c).charAt(0));
		}
	}

	public static final boolean readObjectCB(JsonIterator iter, JsonIterator.ReadObjectCallback cb, Object attachment) throws IOException {
		byte c = IterImpl.nextToken(iter);
		if ('{' == c) {
			c = IterImpl.nextToken(iter);
			if ('"' == c) {
				return subReadObjectCB(iter, cb, attachment);
			}
			if ('}' == c) {
				return true;
			}
			throw iter.reportError("readObjectCB", "expect \" after {");
		}
		if ('n' == c) {
			int n = 3;
			IterImpl.skipFixedBytes(iter, n);
			return true;
		}
		throw iter.reportError("readObjectCB", "expect { or n");
	}
	
	private static final boolean subReadObjectCB(JsonIterator iter, JsonIterator.ReadObjectCallback cb, Object attachment) throws IOException {
		iter.unreadByte();
		String field = iter.readString();
		if (IterImpl.nextToken(iter) != ':') {
			throw iter.reportError(readObject, expect);
		}
		if (!cb.handle(iter, field, attachment)) {
			return false;
		}
		byte b = IterImpl.nextToken(iter);
		int intero = b;
		while (intero == ',') {
			field = iter.readString();
			if (IterImpl.nextToken(iter) != ':') {
				throw iter.reportError(readObject,expect);
			}
			if (!cb.handle(iter, field, attachment)) {
				return false;
			}
			b = IterImpl.nextToken(iter);
			intero = b;
		}
		return true;
	}
}
