package com.kevinchard.ipa.lang;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import com.kevinchard.ipa.lang.BindingException.BindingError;
import com.kevinchard.ipa.lang.core.DynamicFunction;
import com.kevinchard.ipa.lang.core.Function;
import com.kevinchard.ipa.lang.core.IpaList;
import com.kevinchard.ipa.lang.core.IpaMap;
import com.kevinchard.ipa.lang.core.IpaSet;
import com.kevinchard.ipa.lang.core.RequiresLoader;
import com.kevinchard.ipa.lang.core.Symbol;

public class IpaInterpreter implements Interpreter, Loader {
	
	private final Deque<Map<String, Object>> scopeStack;
	
	public IpaInterpreter(Map<String, Object> bindings) {
		this.scopeStack = new LinkedList<Map<String, Object>>();
		this.scopeStack.push(new HashMap<String, Object>());
		
		for(Map.Entry<String, Object> entry : bindings.entrySet()) {
			store(entry.getKey(), entry.getValue());
		}
	}
	
	public Object lookup(String id) {
		
		Object value = null;
		
		for(Map<String, Object> currScope : scopeStack) {
			value = currScope.get(id);
			if(value != null) {
				break;
			}
		}
		
		if(value == null) {
			throw new BindingException(id, BindingError.UNBOUND);
		}
		
		return value;
	}
	
	public void store(String id, Object value) {
		
		if(scopeStack.peek().get(id) != null) {
			throw new BindingException(id, BindingError.ALREADY_BOUND);
		}
		
		if(value instanceof RequiresLoader) {
			((RequiresLoader) value).setLoader(this);
		}
		
		scopeStack.peek().put(id, value);
	}
	
	public Object doFuncCall(String name, List<Object> args) {
		
		Function func = null;
		
		try {
			func = (Function)lookup(name);
		} catch(ClassCastException e) {
			throw new TypeException("ID: " + name + " is not bound to a function!!!");
		}
		
		if(func.requiresNewScope()) {
			scopeStack.push(new HashMap<String, Object>());
		}
		
		try {
			return func.call(args);
		} finally {
			if(func.requiresNewScope()) {
				scopeStack.pop();
			}
		}
	}
	
	@Override
	public String string(String string) {
		return string.substring(1, string.length() -1);
	}

	@Override
	public Integer number(Integer integer) {
		return integer;
	}

	@Override
	public Symbol symbol(String symbol) {
		return new Symbol(symbol);
	}

	@Override
	public List<Object> list(List<Object> args) {
		return new IpaList<Object>(args);
	}

	@Override
	public Set<Object> set(List<Object> values) {
		return new IpaSet<Object>(values);
	}

	@Override
	public Map<Object, Object> map(List<Object> keys, List<Object> values) {
		
		Map<Object, Object> map = new IpaMap<Object, Object>();
		for(int i = 0; i < keys.size(); i++) {
			map.put(keys.get(i), values.get(i));
		}
		
		return map;
	}

	@Override
	public DynamicFunction funcDef(List<String> types, List<String> parameters, List<String> statements, String returnType, String returnExpr) {
		return new DynamicFunction(types, parameters, statements, returnType, returnExpr);
	}
	
	@Override
	public Object run(File file)  {
		try {
			return run(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Object run(String codeString)  {
		return run(new ByteArrayInputStream(codeString.getBytes()));
	}
	
	@Override
	public Object run(InputStream in)  {
		
		try {
			CharStream input = new ANTLRInputStream(in);
			IpaLexer lexer = new IpaLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			IpaParser parser = new IpaParser(tokens, this);
			
			return parser.program();
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (RecognitionException e) {
			throw new RuntimeException(e);
		}
	}
}
