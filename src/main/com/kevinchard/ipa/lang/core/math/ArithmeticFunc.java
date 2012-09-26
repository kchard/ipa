package com.kevinchard.ipa.lang.core.math;

import java.util.List;

import com.kevinchard.ipa.lang.core.ScopedFunction;

public abstract class ArithmeticFunc extends ScopedFunction {

	public Object call(List<Object> args) {
		
		if(args.size() == 0) {
			return startValue();
		}
		
		Integer total = (Integer)args.get(0);
		for(int i = 1; i < args.size(); i++) {
			Integer value = (Integer) args.get(i);
			total =doOperation(total, value);
		}
		
		return total;
	}
	
	protected abstract Integer startValue();
	
	protected abstract Integer doOperation(Integer total, Integer value);
	
	public static final class Add extends ArithmeticFunc {
		
		@Override
		protected Integer startValue() {
			return 0;
		}	
		
		@Override
		protected Integer doOperation(Integer total, Integer value) {
			return total + value;
		}
	}
	
	public static final class Sub extends ArithmeticFunc {
		
		@Override
		protected Integer startValue() {
			return 0;
		}	
		
		@Override
		protected Integer doOperation(Integer total, Integer value) {
			return total - value;
		}	
	}
	
	public static final class Mult extends ArithmeticFunc {
		
		@Override
		protected Integer startValue() {
			return 1;
		}	
		
		@Override
		protected Integer doOperation(Integer total, Integer value) {
			return total * value;
		}	
	}
	
	public static final class Div extends ArithmeticFunc {
		
		@Override
		protected Integer startValue() {
			return 1;
		}	
		
		@Override
		protected Integer doOperation(Integer total, Integer value) {
			return total / value;
		}	
	}
}
