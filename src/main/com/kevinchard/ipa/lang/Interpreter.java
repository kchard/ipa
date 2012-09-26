package com.kevinchard.ipa.lang;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kevinchard.ipa.lang.core.DynamicFunction;
import com.kevinchard.ipa.lang.core.Symbol;

public interface Interpreter {

	Object lookup(String id);
	
	void store(String id, Object value);
	
	Object doFuncCall(String name, List<Object> args) ;

	String string(String string);

	Integer number(Integer i);
	
	Symbol symbol(String symbol);
	
	List<Object> list(List<Object> args);

	Set<Object> set(List<Object> values);

	Map<Object, Object>  map(List<Object> keys, List<Object> values);

	DynamicFunction funcDef(List<String> types, List<String> parameters, List<String> statements, String returnType, String returnExpr);
}
