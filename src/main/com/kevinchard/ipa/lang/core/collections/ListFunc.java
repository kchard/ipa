package com.kevinchard.ipa.lang.core.collections;

import java.util.Collection;

import com.kevinchard.ipa.lang.core.IpaList;

public class ListFunc {
	
	static final class Add extends CollectionFunc.InternalAdd {

		@Override
		public Collection<Object> newCollection() {
			return new IpaList<Object>();
		}
	}
	
	static final class Remove extends CollectionFunc.InternalRemove {

		@Override
		public Collection<Object> newCollection() {
			return new IpaList<Object>();
		}
	}
}
