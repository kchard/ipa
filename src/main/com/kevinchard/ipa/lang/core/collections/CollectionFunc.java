package com.kevinchard.ipa.lang.core.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.kevinchard.ipa.lang.core.IpaList;
import com.kevinchard.ipa.lang.core.IpaMap;
import com.kevinchard.ipa.lang.core.IpaSet;
import com.kevinchard.ipa.lang.core.ScopedFunction;

public class CollectionFunc {

	private static interface CollectionGenerator {
		
		Collection<Object> newCollection();
	}
	
	public static final class Add extends ScopedFunction {
		
		public Object call(List<Object> args) {
			
			Verify.args(args);
			
			if(args.get(0) instanceof IpaList) {
				return new ListFunc.Add().call(args);
			} else if(args.get(0) instanceof IpaSet){
				return new SetFunc.Add().call(args);
			} else if(args.get(0) instanceof IpaMap) { 
				return new MapFunc.Add().call(args);
			} else {
				throw new RuntimeException("Not a collection!!!");
			}
		}
	}
	
	static abstract class InternalAdd extends ScopedFunction implements CollectionGenerator {

		@SuppressWarnings("unchecked")
		@Override
		public Object call(List<Object> args) {
		
			Verify.args(args);
			
			Collection<Object> oldCollection = (Collection<Object>) args.get(0);
			Collection<Object> newCollection = newCollection();
			newCollection.addAll(oldCollection);
			
			for(int i = 1; i < args.size(); i++) {
				newCollection.add(args.get(i));
			}
			
			return newCollection;
		}
	}
	
	public static final class Remove extends ScopedFunction {
		
		public Object call(List<Object> args) {
			
			Verify.args(args);
			
			if(args.get(0) instanceof IpaList) {
				return new ListFunc.Remove().call(args);
			} else if(args.get(0) instanceof IpaSet){
				return new SetFunc.Remove().call(args);
			} else if(args.get(0) instanceof IpaMap) { 
				return new MapFunc.Remove().call(args);
			} else {
				throw new RuntimeException("Not a collection!!!");
			}
		}
	}
	
	static abstract class InternalRemove extends ScopedFunction implements CollectionGenerator {

		@SuppressWarnings("unchecked")
		@Override
		public Object call(List<Object> args) {
		
			Verify.args(args);
			
			Collection<Object> oldCollection = (Collection<Object>) args.get(0);
			List<Object> removeItems = new ArrayList<Object>(args.subList(1, args.size()));
			Collection<Object> newCollection = newCollection();
			
			
			for(Object item : oldCollection) {
				if(!removeItems.contains(item)) {
					newCollection.add(item);
				}
			}
			
			return newCollection;
		}
	}
	
	public static final class Contains extends ScopedFunction {
		
		public Object call(List<Object> args) {
			
			Verify.args(args);
			
			if(args.get(0) instanceof IpaList) {
				return new CollectionContains().call(args);
			} else if(args.get(0) instanceof IpaSet){
				return new  CollectionContains().call(args);
			} else if(args.get(0) instanceof IpaMap) { 
				return new MapFunc.Contains().call(args);
			} else {
				throw new RuntimeException("Not a collection!!!");
			}
		}
	}
	
	static final class CollectionContains extends ScopedFunction {

		@SuppressWarnings("unchecked")
		@Override
		public Object call(List<Object> args) {
		
			Verify.args(args);
			
			Collection<Object> coll = (Collection<Object>) args.get(0);
			Collection<Object> containsItems = new ArrayList<Object>(args.subList(1, args.size()));
			
			Boolean result = Boolean.TRUE;
			for(Object item : containsItems) {
				if(!coll.contains(item)) {
					result = Boolean.FALSE;
					break;
				}
			}
			
			return result;
		}
	}
	
	public static final class Size extends ScopedFunction {
		
		public Object call(List<Object> args) {
			
			Verify.args(args);
			
			if(args.get(0) instanceof IpaList) {
				return new CollectionSize().call(args);
			} else if(args.get(0) instanceof IpaSet){
				return new  CollectionSize().call(args);
			} else if(args.get(0) instanceof IpaMap) { 
				return new MapFunc.Size().call(args);
			} else {
				throw new RuntimeException("Not a collection!!!");
			}
		}
	}
	
	static final class CollectionSize extends ScopedFunction {

		@SuppressWarnings("unchecked")
		@Override
		public Object call(List<Object> args) {
		
			Integer size = 0;
			for(Object arg : args) {
				Collection<Object> coll = (Collection<Object>) arg;
				size += coll.size();
			}
			
			return size;
		}
	}
}
