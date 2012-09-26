package com.kevinchard.ipa.lang.core;

import java.util.HashSet;
import java.util.List;

public class IpaSet<T> extends HashSet<T> {

	private static final long serialVersionUID = -5620261451124426537L;

	public IpaSet() {
		super();
	}
	
	public IpaSet(List<T> values) {
		super(values);
	}

	@Override
	public String toString() {
		return "S" + super.toString();
	}
}
