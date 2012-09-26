package com.kevinchard.ipa.lang.core;

import java.util.HashMap;
import java.util.Map;

public class IpaMap<K,V> extends HashMap<K,V> {

	private static final long serialVersionUID = -827821584829842578L;

	public IpaMap() {
		super();
	}
	
	public IpaMap(Map<K, V> map) {
		super();
		this.putAll(map);
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("M[");
		
		int count = 0;
		for(Map.Entry<K,V> entry : this.entrySet()) {
			sb.append(entry.getKey().toString()).append(" : ").append(entry.getValue().toString());
			
			if(count < this.entrySet().size() - 1) {
				sb.append(", ");
			}
			count++;
		}
		sb.append("]");
		
		return sb.toString();
	}
}
