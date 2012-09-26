package com.kevinchard.ipa.lang.core;

public abstract class ScopedFunction implements Function {

	@Override
	public boolean requiresNewScope() {
		return true;
	}

}
