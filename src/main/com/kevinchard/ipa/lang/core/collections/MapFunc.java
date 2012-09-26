package com.kevinchard.ipa.lang.core.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.kevinchard.ipa.lang.core.IpaList;
import com.kevinchard.ipa.lang.core.IpaMap;
import com.kevinchard.ipa.lang.core.ScopedFunction;

public class MapFunc {

	static final class Add extends ScopedFunction {

		@SuppressWarnings("unchecked")
		@Override
		public Object call(List<Object> args) {
			
			if(args.size() == 0) {
				return new IpaList<Object>();
			}
			
			Map<Object, Object> oldMap = (Map<Object, Object>) args.get(0);
			Map<Object, Object> newMap = new IpaMap<Object, Object>(oldMap);
			
			for(int i = 1; i < args.size(); i+=2) {
				newMap.put(args.get(i), args.get(i + 1));
			}
			
			return newMap;
		}
		
	}
	
	static final class Remove extends ScopedFunction {

		@SuppressWarnings("unchecked")
		@Override
		public Object call(List<Object> args) {
			
			if(args.size() == 0) {
				return new IpaList<Object>();
			}
			
			Map<Object, Object> oldMap = (Map<Object, Object>) args.get(0);
			List<Object> removeItems = new ArrayList<Object>(args.subList(1, args.size()));
			Map<Object, Object> newMap = new IpaMap<Object, Object>();
			
			for(Map.Entry<Object, Object> entry : oldMap.entrySet()) {
				if(!removeItems.contains(entry.getKey())) {
					newMap.put(entry.getKey(), entry.getValue());
				}
			}
			
			return newMap;
		}		
	}
	
	static final class Contains extends ScopedFunction {

		@SuppressWarnings("unchecked")
		@Override
		public Object call(List<Object> args) {
		
			if(args.size() == 0) {
				return Boolean.TRUE;
			}
			
			Map<Object, Object> map = (Map<Object, Object>) args.get(0);
			Collection<Object> containsKeys = new ArrayList<Object>(args.subList(1, args.size()));
			
			Boolean result = Boolean.TRUE;
			for(Object key : containsKeys) {
				if(!map.containsKey(key)) {
					result = Boolean.FALSE;
					break;
				}
			}
			
			return result;
		}

	}
	
	static final class Size extends ScopedFunction {

		@SuppressWarnings("unchecked")
		@Override
		public Object call(List<Object> args) {
		
			Integer size = 0;
			for(Object arg : args) {
				Map<Object, Object> map = (Map<Object, Object>) arg;
				size += map.size();
			}
			
			return size;
		}

	}
}
