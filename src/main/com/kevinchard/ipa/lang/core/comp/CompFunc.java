package com.kevinchard.ipa.lang.core.comp;

import java.util.List;

import com.kevinchard.ipa.lang.core.ScopedFunction;

public abstract class CompFunc extends ScopedFunction {

	public Object call(List<Object> args) {
		
		if(args.size() == 0) {
			return Boolean.TRUE;
		}
		
		Boolean result = Boolean.TRUE;
		Object first = args.get(0);
		for(int i = 1; i < args.size(); i++) {
			Object obj = args.get(i);
			result &= doOperation(first, obj);
		}
		
		return result;
	}
	
	protected abstract Boolean doOperation(Object a, Object b);

	public static final class Equal extends CompFunc {

		@Override
		protected Boolean doOperation(Object a, Object b) {
			return a.equals(b);
		}
	}
}
