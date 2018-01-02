package com.jsoniter.output;

import com.jsoniter.any.Any;
import com.jsoniter.spi.*;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * class CodegenImplNative
 * 
 * @author MaxiBon
 *
 */
class CodegenImplNative {

	private CodegenImplNative() {
	}

	/**
	 * public static final Map<Type, Encoder.ReflectionEncoder> NATIVE_ENCODERS
	 * = new IdentityHashMap<Type, Encoder.ReflectionEncoder>()
	 * 
	 * @author MaxiBon
	 *
	 */
	public static final Map<Type, Encoder.ReflectionEncoder> NATIVE_ENCODERS = new IdentityHashMap<Type, Encoder.ReflectionEncoder>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 4674532708840309972L;

		{
			put(boolean.class, new Encoder.ReflectionEncoder() {
				@Override
				public void encode(Object oggetto, JsonStream stream_) throws IOException {
					if (oggetto instanceof Boolean) {
						stream_.writeVal((Boolean) oggetto);
					}

					else {
						throw new IOException();
					}

				}

				@Override
				public Any wrap(Object oggetto) {
					Boolean val = null;
					if (oggetto instanceof Boolean) {
						val = (Boolean) oggetto;
					}

					return Any.wrap((boolean) val);
				}
			});
			put(Boolean.class, new Encoder.ReflectionEncoder() {
				@Override
				public void encode(Object oggetto, JsonStream stream_) throws IOException {
					if (oggetto instanceof Boolean) {
						stream_.writeVal(Boolean.parseBoolean(oggetto.toString()));
					}

					else {
						throw new IOException();
					}

				}

				@Override
				public Any wrap(Object oggetto) {
					Boolean val = null;
					if (oggetto instanceof Boolean) {
						val = Boolean.parseBoolean(oggetto.toString());
					}

					return Any.wrap((boolean) val);
				}
			});
			put(byte.class, new Encoder.ReflectionEncoder() {
				@Override
				public void encode(Object oggetto, JsonStream stream_) throws IOException {
					if (oggetto instanceof Byte) {
						stream_.writeVal(((Byte) oggetto).shortValue());
					}

					else {
						throw new IOException();
					}

				}

				@Override
				public Any wrap(Object oggetto) {
					Byte val = null;
					if (oggetto instanceof Byte) {
						val = (Byte) oggetto;
					}

					return Any.wrap(val.intValue());
				}
			});
			put(Byte.class, new Encoder.ReflectionEncoder() {
				@Override
				public void encode(Object oggetto, JsonStream stream_) throws IOException {
					if (oggetto instanceof Byte) {
						stream_.writeVal((Byte.valueOf(Byte.parseByte(oggetto.toString()))).shortValue());
					}

					else {
						throw new IOException();
					}

				}

				@Override
				public Any wrap(Object oggetto) {
					Byte val = null;
					if (oggetto instanceof Byte) {
						val = Byte.parseByte(oggetto.toString());
					}

					return Any.wrap(val.intValue());
				}
			});
			put(short.class, new Encoder.ReflectionEncoder() {
				@Override
				public void encode(Object oggetto, JsonStream stream_) throws IOException {
					stream_.writeVal(oggetto.toString());
				}

				@Override
				public Any wrap(Object oggetto) {
					Short val = null;
					if (oggetto instanceof Short) {
						val = (Short) oggetto;
					}

					return Any.wrap(val.intValue());
				}
			});
			put(Short.class, new Encoder.ReflectionEncoder() {
				@Override
				public void encode(Object oggetto, JsonStream stream_) throws IOException {
					stream_.writeVal(oggetto.toString());
				}

				@Override
				public Any wrap(Object oggetto) {
					Short val = null;
					if (oggetto instanceof Short) {
						val = (Short) oggetto;
					}

					return Any.wrap(val.intValue());
				}
			});
			put(int.class, new Encoder.ReflectionEncoder() {
				@Override
				public void encode(Object oggetto, JsonStream stream_) throws IOException {
					stream_.writeVal(oggetto.toString());
				}

				@Override
				public Any wrap(Object oggetto) {
					Integer val = null;
					if (oggetto instanceof Integer) {
						val = (Integer) oggetto;
					}

					return Any.wrap((int) val);
				}
			});
			put(Integer.class, new Encoder.ReflectionEncoder() {
				@Override
				public void encode(Object oggetto, JsonStream stream_) throws IOException {
					if (oggetto instanceof Integer) {
						stream_.writeVal((Integer) oggetto);
					}

					else {
						throw new IOException();
					}

				}

				@Override
				public Any wrap(Object oggetto) {
					Integer val = null;
					if (oggetto instanceof Integer) {
						val = Integer.parseInt(oggetto.toString());
					}

					return Any.wrap((int) val);
				}
			});
			put(char.class, new Encoder.ReflectionEncoder() {
				@Override
				public void encode(Object oggetto, JsonStream stream_) throws IOException {
					if (oggetto instanceof Character)
						stream_.writeVal(((Character) oggetto).charValue());
					else
						throw new IOException();
				}

				@Override
				public Any wrap(Object oggetto) {
					Character val = null;
					if (oggetto instanceof Character) {
						val = (Character) oggetto;
					}

					return Any.wrap(val.charValue());
				}
			});
			put(Character.class, new Encoder.ReflectionEncoder() {
				@Override
				public void encode(Object oggetto, JsonStream stream_) throws IOException {
					if (oggetto instanceof Character) {
						stream_.writeVal(oggetto.toString().charAt(0));
					}

					else {
						throw new IOException();
					}

				}

				@Override
				public Any wrap(Object oggetto) {
					Character val = null;
					if (oggetto instanceof Character) {
						val = oggetto.toString().charAt(0);
					}

					return Any.wrap(val.charValue());
				}
			});
			put(long.class, new Encoder.ReflectionEncoder() {
				@Override
				public void encode(Object oggetto, JsonStream stream_) throws IOException {
					stream_.writeVal(oggetto.toString());
				}

				@Override
				public Any wrap(Object oggetto) {
					Long val = null;
					if (oggetto instanceof Long) {
						val = (Long) oggetto;
					}

					return Any.wrap((long) val);
				}
			});
			put(Long.class, new Encoder.ReflectionEncoder() {
				@Override
				public void encode(Object oggetto, JsonStream stream_) throws IOException {
					stream_.writeVal(oggetto.toString());
				}

				@Override
				public Any wrap(Object oggetto) {
					Long val = null;
					if (oggetto instanceof Long) {
						val = (Long) oggetto;
					}

					return Any.wrap((long) val);
				}
			});
			put(float.class, new Encoder.ReflectionEncoder() {
				@Override
				public void encode(Object oggetto, JsonStream stream_) throws IOException {
					stream_.writeVal(oggetto.toString());
				}

				@Override
				public Any wrap(Object oggetto) {
					Float val = null;
					if (oggetto instanceof Float) {
						val = (Float) oggetto;
					}

					return Any.wrap((float) val);
				}
			});
			put(Float.class, new Encoder.ReflectionEncoder() {
				@Override
				public void encode(Object oggetto, JsonStream stream_) throws IOException {
					stream_.writeVal(oggetto.toString());
				}

				@Override
				public Any wrap(Object oggetto) {
					Float val = null;
					if (oggetto instanceof Float) {
						val = (Float) oggetto;
					}

					return Any.wrap((float) val);
				}
			});
			put(double.class, new Encoder.ReflectionEncoder() {
				@Override
				public void encode(Object oggetto, JsonStream stream_) throws IOException {
					stream_.writeVal(oggetto.toString());
				}

				@Override
				public Any wrap(Object oggetto) {
					Double val = null;
					if (oggetto instanceof Double) {
						val = (Double) oggetto;
					}

					return Any.wrap((double) val);
				}
			});
			put(Double.class, new Encoder.ReflectionEncoder() {
				@Override
				public void encode(Object oggetto, JsonStream stream_) throws IOException {
					stream_.writeVal(oggetto.toString());
				}

				@Override
				public Any wrap(Object oggetto) {
					Double val = null;
					if (oggetto instanceof Double) {
						val = (Double) oggetto;
					}

					return Any.wrap((double) val);
				}
			});
			put(String.class, new Encoder.ReflectionEncoder() {
				@Override
				public void encode(Object oggetto, JsonStream stream_) throws IOException {
					stream_.writeVal(oggetto.toString());
				}

				@Override
				public Any wrap(Object oggetto) {
					String val = null;
					if (oggetto instanceof String) {
						val = (String) oggetto;
					}

					return Any.wrap(val);
				}
			});
			put(Object.class, new Encoder.ReflectionEncoder() {
				@Override
				public void encode(Object oggetto, JsonStream stream_) throws IOException {
					if (oggetto != null && oggetto.getClass() == Object.class) {
						stream_.writeEmptyObject();
						return;
					}
					stream_.writeVal(oggetto);
				}

				@Override
				public Any wrap(Object oggetto) {
					if (oggetto != null && oggetto.getClass() == Object.class) {
						return Any.rewrap(new HashMap<String, Any>());
					}
					return CodegenAccess.wrap(oggetto);
				}
			});

			put(BigDecimal.class, new Encoder.ReflectionEncoder() {
				@Override
				public void encode(Object oggetto, JsonStream stream_) throws IOException {
					BigDecimal val = null;
					if (oggetto instanceof BigDecimal) {
						val = (BigDecimal) oggetto;
					}

					stream_.writeRaw(val.toString());
				}

				@Override
				public Any wrap(Object oggetto) {
					return Any.wrap(oggetto.toString());
				}
			});
			put(BigInteger.class, new Encoder.ReflectionEncoder() {
				@Override
				public void encode(Object oggetto, JsonStream stream_) throws IOException {
					BigInteger val = null;
					if (oggetto instanceof BigInteger) {
						val = (BigInteger) oggetto;
					}

					stream_.writeRaw(val.toString());

				}

				@Override
				public Any wrap(Object oggetto) {
					return Any.wrap(oggetto.toString());
				}
			});
		}
	};

	/**
	 * genWriteOp.
	 * 
	 * @param ctx
	 * @param code
	 * @param valueType
	 * @param isNullable
	 */
	public static void genWriteOp(CodegenResult ctx, String code, Type valueType, boolean isNullable) {
		genWriteOp(ctx, code, valueType, isNullable, true);
	}

	public static void genWriteOp(CodegenResult ctx, String code, Type valueType, boolean isNullable,
			boolean isCollectionValueNullable) {
		boolean noIndention = JsoniterSpi.getCurrentConfig().indentionStep() == 0;
		String cacheKey = TypeLiteral.create(valueType).getEncoderCacheKey();
		if (JsoniterSpi.getEncoder(cacheKey) == null) {
			if (noIndention && !isNullable && String.class == valueType) {
				ctx.buffer('"');
				ctx.append(String.format(
						"com.jsoniter.output.CodegenAccess.writeStringWithoutQuote((java.lang.String)%s, stream);",
						code));
				ctx.buffer('"');
				return;
			}
			if (NATIVE_ENCODERS.containsKey(valueType)) {
				ctx.append(String.format("stream.writeVal((%s)%s);", getTypeName(valueType), code));
				return;
			}
			if (valueType instanceof WildcardType) {
				ctx.append(String.format("stream.writeVal((%s)%s);", getTypeName(Object.class), code));
				return;
			}
		}

		if (!isCollectionValueNullable) {
			cacheKey = cacheKey + "__value_not_nullable";
		}
		Codegen.getEncoder(cacheKey, valueType);
		CodegenResult generatedSource = Codegen.getGeneratedSource(cacheKey);
		if (generatedSource != null) {
			if (isNullable) {
				ctx.appendBuffer();
				ctx.append(CodegenResult.bufferToWriteOp(generatedSource.prelude));
				ctx.append(String.format("%s.encode_((%s)%s, stream);", cacheKey, getTypeName(valueType), code));
				ctx.append(CodegenResult.bufferToWriteOp(generatedSource.epilogue));
			} else {
				ctx.buffer(generatedSource.prelude);
				ctx.append(String.format("%s.encode_((%s)%s, stream);", cacheKey, getTypeName(valueType), code));
				ctx.buffer(generatedSource.epilogue);
			}
		} else {
			ctx.append(String.format("com.jsoniter.output.CodegenAccess.writeVal(\"%s\", (%s)%s, stream);", cacheKey,
					getTypeName(valueType), code));
		}
	}

	public static String getTypeName(Type fieldType) {
		if (fieldType instanceof Class) {
			Class clazz = (Class) fieldType;
			return clazz.getCanonicalName();
		} else if (fieldType instanceof ParameterizedType) {
			ParameterizedType pType = (ParameterizedType) fieldType;
			Class clazz = null;
			if (pType.getRawType() instanceof Class) {
				clazz = (Class) pType.getRawType();
			}
			return clazz.getCanonicalName();

		} else if (fieldType instanceof WildcardType) {
			return Object.class.getCanonicalName();
		} else {
			throw new JsonException("unsupported type: " + fieldType);
		}
	}

	public static CodegenResult genEnum(Class clazz) {
		boolean noIndention = JsoniterSpi.getCurrentConfig().indentionStep() == 0;
		CodegenResult ctx = new CodegenResult();
		ctx.append(String.format(
				"public static void encode_(java.lang.Object obj, com.jsoniter.output.JsonStream stream) throws java.io.IOException {",
				clazz.getCanonicalName()));
		ctx.append("if (obj == null) { stream.writeNull(); return; }");
		if (noIndention) {
			ctx.buffer('"');
		} else {
			ctx.append("stream.write('\"');");
		}
		ctx.append("stream.writeRaw(obj.toString());");
		if (noIndention) {
			ctx.buffer('"');
		} else {
			ctx.append("stream.write('\"');");
		}
		ctx.append("}");
		return ctx;
	}
}
