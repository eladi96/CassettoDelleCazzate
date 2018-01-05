package com.jsoniter;

import java.io.IOException;
import java.lang.reflect.Array;

import com.jsoniter.spi.Decoder;
import com.jsoniter.spi.TypeLiteral;

/**
 * class ReflectionArrayDecoder
 * 
 * @author MaxiBon
 *
 */
class ReflectionArrayDecoder implements Decoder {

	private final Class componentType;
	private final Decoder compTypeDecoder;
	private int[] nV = {2, 3, 8};
	/**
	 * ReflectionArrayDecoder
	 * 
	 * @param clazz
	 */
	ReflectionArrayDecoder(Class clazz) {
		componentType = clazz.getComponentType();
		compTypeDecoder = Codegen.getDecoder(TypeLiteral.create(componentType).getDecoderCacheKey(), componentType);
	}

	@Override
	public Object decode(JsonIterator iter) throws IOException {
		
		CodegenAccess.resetExistingObject(iter);
		if (iter.readNull()) {
			return null;
		}
		
		if (!CodegenAccess.readArrayStart(iter)) {
			return Array.newInstance(componentType, 0);
		}
		
		Object a1 = compTypeDecoder.decode(iter);
		if (CodegenAccess.nextToken(iter) != ',') {
			return subDecode1(a1);
		}
		
		Object a2 = compTypeDecoder.decode(iter);
		if (CodegenAccess.nextToken(iter) != ',') {
			return subDecode2(a1, a2);
		}
		
		Object a3 = compTypeDecoder.decode(iter);
		if (CodegenAccess.nextToken(iter) != ',') {
			return subDecode3(a1, a2, a3);
		}
		
		Object a4 = compTypeDecoder.decode(iter);
		Object arr = subDecode4(a1, a2, a3, a4);
		Integer i = 4;
		Integer arrLen = 8;
		Integer intNum = Integer.valueOf(CodegenAccess.nextToken(iter));
		while (intNum.intValue() == ',') {
			intNum = whileSupport(intNum, arrLen, arrLen, iter);
		}
		if (i.intValue() == arrLen.intValue()) {
			return arr;
		}
		
		return subDecode5(arr, i);
	}
	
	Object subDecode1(Object a1) {
		Object arr = Array.newInstance(componentType, 1);
		Array.set(arr, 0, a1);
		return arr;
	}
	
	Object subDecode2(Object a1, Object a2) {
		Object arr = Array.newInstance(componentType, nV[0]);
		Array.set(arr, 0, a1);
		Array.set(arr, 1, a2);
		return arr;
	}
	
	Object subDecode3(Object a1, Object a2, Object a3) {
		Object arr = Array.newInstance(componentType, nV[1]);
		Array.set(arr, 0, a1);
		Array.set(arr, 1, a2);
		Array.set(arr, nV[0], a3);
		return arr;
	}
	
	Object subDecode4(Object a1, Object a2, Object a3, Object a4) {
		Object arr = Array.newInstance(componentType, nV[2]);
		Array.set(arr, 0, a1);
		Array.set(arr, 1, a2);
		Array.set(arr, nV[0], a3);
		Array.set(arr, nV[1], a4);
		return arr;		
	}
	
	Integer whileSupport(Integer i, Integer arrLen, Object arr, JsonIterator iter) throws IOException {
		if (i.intValue() == arrLen.intValue()) {
			int n = 2 * arrLen.intValue();
			Object newArr = Array.newInstance(componentType, n);
			System.arraycopy(arr, 0, newArr, 0, arrLen.intValue());
			arr = newArr;
			arrLen = Integer.valueOf(2 * arrLen.intValue());
		}
		Array.set(arr, i++, compTypeDecoder.decode(iter));
		return Integer.valueOf(CodegenAccess.nextToken(iter));
	}
	
	Object subDecode5(Object arr, Integer i) {
		Object newArr = Array.newInstance(componentType, i.intValue());
		System.arraycopy(arr, 0, newArr, 0, i.intValue());
		return newArr;
	}
}
