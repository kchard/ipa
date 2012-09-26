package com.kevinchard.ipa.lang;

import java.util.List;

public class BindingException extends SemanticException {
	
	private static final long serialVersionUID = -6616574045305953363L;

	public static enum BindingError {
		ALREADY_BOUND("ID: %s is already bound!!!"),
		UNBOUND("ID: %s is not bound!!!");
		
		private final String message;
		
		BindingError(String message) {
			this.message = message;
		}
	}
	
	public BindingException(String id, BindingError error) {
		super(String.format(error.message, id));
	}
	
	public BindingException(List<String> parameters, List<Object> args) {
		super("Num args do not match expected Params -> Params: " + parameters + " Args: " + args);
	}
}
