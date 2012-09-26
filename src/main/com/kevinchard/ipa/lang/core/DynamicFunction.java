package com.kevinchard.ipa.lang.core;

import java.util.List;

import com.kevinchard.ipa.lang.BindingException;
import com.kevinchard.ipa.lang.Loader;
import com.kevinchard.ipa.lang.TypeException;

public final class DynamicFunction extends ScopedFunction implements RequiresLoader {
	
	private final List<String> types;
	private final List<String> parameters;
	private final List<String> statements;
	private final String returnType;
	private final String returnExpr;
	private Loader loader;
	
	public DynamicFunction(List<String> types, List<String> parameters, List<String> statements, String returnType, String returnExpr) {
		this.types = types;
		this.parameters = parameters;
		this.statements = statements;
		this.returnType = returnType;
		this.returnExpr = returnExpr;
	}

	@Override
	public Object call(List<Object> args) {
		
		if(parameters.size() != args.size()) {
			throw new BindingException(parameters, args);
		}
		
		for(int i = 0; i < types.size(); i++) {
			if(!Type.findType(types.get(i)).isCompatible(args.get(i))) {
				throw new TypeException(types, args);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < parameters.size(); i++) {
			if(args.get(i) instanceof String) {
				sb.append(parameters.get(i)).append(" := ").append("\"").append(args.get(i)).append("\"").append(";");
			} else {
				sb.append(parameters.get(i)).append(" := ").append(args.get(i)).append(";");
			}
			
		}
		
		for(String statement : statements) {
			sb.append(statement).append(";");
		}
		
		//Bind the final expression result to a unique ID
		sb.append("result").append(System.currentTimeMillis()).append(" := ").append(returnExpr).append(";");
	
		Object result = loader.run(sb.toString());
		
		if(!Type.findType(returnType).isCompatible(result)) {
			throw new TypeException(returnType, result);
		}
		
		return result;
	}

	@Override
	public void setLoader(Loader loader) {
		this.loader = loader;
	}
}
