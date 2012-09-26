package com.kevinchard.ipa.lang;

import java.util.List;

public class TypeException extends SemanticException {

	private static final long serialVersionUID = 832438935491306486L;

	public TypeException(String message) {
		super(message);
	}
	
	public TypeException(String type, Object arg) {
		super("Incompatible types -> Type: " + type + " Object: " + arg);
	}

	public TypeException(List<String> types, List<Object> args) {
		super("Incompatible types -> Types: " + types + " Args: " + args);
	}
}
