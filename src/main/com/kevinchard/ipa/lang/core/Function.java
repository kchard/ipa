package com.kevinchard.ipa.lang.core;

import java.util.List;

public interface Function {

	Object call(List<Object> args);
	
	boolean requiresNewScope();
}
