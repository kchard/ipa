package com.kevinchard.ipa.lang.core;


public abstract class UnscopedFunction implements Function {

	@Override
	public boolean requiresNewScope() {
		return false;
	}

}
