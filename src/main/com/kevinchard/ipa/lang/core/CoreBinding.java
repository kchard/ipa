package com.kevinchard.ipa.lang.core;

import java.util.HashMap;
import java.util.Map;

import com.kevinchard.ipa.lang.core.collections.CollectionFunc;
import com.kevinchard.ipa.lang.core.comp.CompFunc;
import com.kevinchard.ipa.lang.core.io.IoFunc;
import com.kevinchard.ipa.lang.core.math.ArithmeticFunc;

public enum CoreBinding {
	
	INSTANCE;
	
	private Map<String, Object> bindings;
	
	CoreBinding() {
		
		bindings = new HashMap<String, Object>();
		
		//IO Funcs
		bindings.put("Io.print", new IoFunc.Print());
		bindings.put("Io.require", new IoFunc.Require());

		// Comp Funcs
		bindings.put("Comp.equal", new CompFunc.Equal());

		// Arithmetic Funcs
		bindings.put("Math.add", new ArithmeticFunc.Add());
		bindings.put("Math.sub", new ArithmeticFunc.Sub());
		bindings.put("Math.mult", new ArithmeticFunc.Mult());
		bindings.put("Math.div", new ArithmeticFunc.Div());

		// Collection Funcs
		bindings.put("Coll.add", new CollectionFunc.Add());
		bindings.put("Coll.remove", new CollectionFunc.Remove());
		bindings.put("Coll.contains", new CollectionFunc.Contains());
		bindings.put("Coll.size", new CollectionFunc.Size());
	}
	
	public Map<String, Object> getBindings() {
		return new HashMap<String, Object>(bindings);
	}
}
