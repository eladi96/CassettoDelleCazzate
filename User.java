package decoder.java.util.List_com.jsoniter.demo;
public class User implements com.jsoniter.spi.Decoder {
	public static java.lang.Object decode_(com.jsoniter.JsonIterator iter) throws java.io.IOException {
		
		/*if(com.jsoniter.CodegenAccess.resetExistingObject(iter) instanceof java.util.ArrayList)
			java.util.ArrayList col = (java.util.ArrayList)com.jsoniter.CodegenAccess.resetExistingObject(iter);*/
	if (iter.readNull()) { com.jsoniter.CodegenAccess.resetExistingObject(iter); return null; }
	if (!com.jsoniter.CodegenAccess.readArrayStart(iter)) {
		
		/*if(col == null)
			return new java.util.ArrayList(0);
		else
			if(com.jsoniter.CodegenAccess.reuseCollection(col) instanceof java.util.ArrayList)
				return (java.util.ArrayList)com.jsoniter.CodegenAccess.reuseCollection(col);*/
	}
	
	/*if(decoder.com.jsoniter.demo.User.decode_(iter) instanceof com.jsoniter.demo.User)
		Object a1 = (com.jsoniter.demo.User)decoder.com.jsoniter.demo.User.decode_(iter);*/
	if (com.jsoniter.CodegenAccess.nextToken(iter) != ',') {
		
		/*java.util.ArrayList obj;
		if(col == null)
			obj = new java.util.ArrayList(1);
		else
			if(com.jsoniter.CodegenAccess.reuseCollection(col) instanceof java.util.ArrayList)
				obj = (java.util.ArrayList)com.jsoniter.CodegenAccess.reuseCollection(col);
			else throw new IOException();*/

		obj.add(a1);
		return obj;
	}
	
	/*if(decoder.com.jsoniter.demo.User.decode_(iter) instanceof com.jsoniter.demo.User)
		Object a2 = (com.jsoniter.demo.User)decoder.com.jsoniter.demo.User.decode_(iter);*/
	if (com.jsoniter.CodegenAccess.nextToken(iter) != ',') {
		
		/*java.util.ArrayList obj;
		if(col == null)
			obj = new java.util.ArrayList(2);
		else
			if(com.jsoniter.CodegenAccess.reuseCollection(col) instanceof java.util.ArrayList)
				obj = (java.util.ArrayList)com.jsoniter.CodegenAccess.reuseCollection(col);
			else throw new IOException();*/
		
		obj.add(a1);
		obj.add(a2);
		return obj;
	}
	
	/*if(decoder.com.jsoniter.demo.User.decode_(iter) instanceof com.jsoniter.demo.User)
		Object a3 = (com.jsoniter.demo.User)decoder.com.jsoniter.demo.User.decode_(iter);*/
	if (com.jsoniter.CodegenAccess.nextToken(iter) != ',') {
		
		/*java.util.ArrayList obj;
		if(col == null)
			obj = new java.util.ArrayList(3);
		else
			if(com.jsoniter.CodegenAccess.reuseCollection(col) instanceof java.util.ArrayList)
				obj = (java.util.ArrayList)com.jsoniter.CodegenAccess.reuseCollection(col);
			else throw new IOException();*/

		obj.add(a1);
		obj.add(a2);
		obj.add(a3);
		return obj;
	}
	
	/*if(decoder.com.jsoniter.demo.User.decode_(iter) instanceof com.jsoniter.demo.User)
		Object a4 = (com.jsoniter.demo.User)decoder.com.jsoniter.demo.User.decode_(iter);*/
	
	/*java.util.ArrayList obj;
	if(col == null)
		obj = new java.util.ArrayList(8);
	else
		if(com.jsoniter.CodegenAccess.reuseCollection(col) instanceof java.util.ArrayList)
			obj = (java.util.ArrayList)com.jsoniter.CodegenAccess.reuseCollection(col);
		else throw new IOException();*/
	
	obj.add(a1);
	obj.add(a2);
	obj.add(a3);
	obj.add(a4);
	while (com.jsoniter.CodegenAccess.nextToken(iter) == ',') {
		com.jsoniter.demo.User parametro;
		if(decoder.com.jsoniter.demo.User.decode_(iter) instanceof com.jsoniter.demo.User)
			parametro = (com.jsoniter.demo.User) decoder.com.jsoniter.demo.User.decode_(iter);
		obj.add(parametro);
	}
	return obj;
	}

	public java.lang.Object decode(com.jsoniter.JsonIterator iter) throws java.io.IOException {
		return decode_(iter);
	}
}
