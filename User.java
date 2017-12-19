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
	
	/*Object a1 = decoder.com.jsoniter.demo.User.decode_(iter);
	if(a1 instanceof com.jsoniter.demo.User)
		a1 = (com.jsoniter.demo.User) a1;
	
	if (com.jsoniter.CodegenAccess.nextToken(iter) != ',') {
		
		java.util.ArrayList obj = new java.util.ArrayList(1);
		if(col != null) {
			if(com.jsoniter.CodegenAccess.reuseCollection(col) instanceof java.util.ArrayList)
				obj = (java.util.ArrayList)com.jsoniter.CodegenAccess.reuseCollection(col);
			else throw new IOException();

		obj.add(a1);
		return obj;
	}*/
	
	/*Object a2 = decoder.com.jsoniter.demo.User.decode_(iter);
	if(a2 instanceof com.jsoniter.demo.User)
		a2 = (com.jsoniter.demo.User) a2;
	
	if (com.jsoniter.CodegenAccess.nextToken(iter) != ',') {
		
		java.util.ArrayList obj = new java.util.ArrayList(2);
		if(col != null) {
			if(com.jsoniter.CodegenAccess.reuseCollection(col) instanceof java.util.ArrayList)
				obj = (java.util.ArrayList)com.jsoniter.CodegenAccess.reuseCollection(col);
			else throw new IOException();
		
		obj.add(a1);
		obj.add(a2);
		return obj;
	}*/
	
	Object a3 = decoder.com.jsoniter.demo.User.decode_(iter);
	if(a3 instanceof com.jsoniter.demo.User)
		a3 = (com.jsoniter.demo.User) a3;
	
	if (com.jsoniter.CodegenAccess.nextToken(iter) != ',') {
		
		java.util.ArrayList obj = new java.util.ArrayList(3);
		if(col != null) {
			if(com.jsoniter.CodegenAccess.reuseCollection(col) instanceof java.util.ArrayList)
				obj = (java.util.ArrayList)com.jsoniter.CodegenAccess.reuseCollection(col);
			else throw new IOException();

		obj.add(a1);
		obj.add(a2);
		obj.add(a3);
		return obj;
	}
	
	Object a4 = decoder.com.jsoniter.demo.User.decode_(iter);
	if(a4 instanceof com.jsoniter.demo.User)
		a4 = (com.jsoniter.demo.User) a4;
	
	java.util.ArrayList obj = new java.util.ArrayList(8);
	if(col != null) {
		if(com.jsoniter.CodegenAccess.reuseCollection(col) instanceof java.util.ArrayList)
			obj = (java.util.ArrayList)com.jsoniter.CodegenAccess.reuseCollection(col);
		else throw new IOException();
	}

	obj.add(a1);
	obj.add(a2);
	obj.add(a3);
	obj.add(a4);
	while (com.jsoniter.CodegenAccess.nextToken(iter) == ',') {
		com.jsoniter.demo.User parametro = decoder.com.jsoniter.demo.User.decode_(iter);
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
