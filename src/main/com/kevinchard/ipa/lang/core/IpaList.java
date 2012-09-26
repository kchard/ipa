package com.kevinchard.ipa.lang.core;

import java.util.ArrayList;
import java.util.List;

public class IpaList<T> extends ArrayList<T> {
	
	private static final long serialVersionUID = -964285632555336921L;

	public IpaList() {
		super();
	}
	
	public IpaList(List<T> args) {
		super(args);
	}

	@Override
	public String toString() {
		return "L" + super.toString();
	}
}
