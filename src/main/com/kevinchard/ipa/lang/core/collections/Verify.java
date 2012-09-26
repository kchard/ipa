package com.kevinchard.ipa.lang.core.collections;

import java.util.List;

import com.kevinchard.ipa.lang.TypeException;

class Verify {

	static void args(List<Object> args) throws TypeException {
		if(args.size() == 0) {
			throw new TypeException("First arg not a collection!!!");
		}
	}
}
