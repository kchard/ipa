package com.kevinchard.ipa.lang.core;

public enum Type {

	ANY("Any", Object.class),
	NUM("Num", Integer.class),
	STR("Str", String.class),
	LIST("List", IpaList.class),
	SET("Set", IpaSet.class),
	MAP("Map", IpaMap.class),
	SYM("Sym", Symbol.class);
	
	private String ipaType;
	private Class<?> javaType;
	
	Type(String ipaType, Class<?> javaType) {
		this.ipaType = ipaType;
		this.javaType = javaType;
	}
	
	public boolean isCompatible(Object o) {
		return javaType.isInstance(o);
	}
	
	public static Type findType(String ipaType) {
		if(NUM.ipaType.equals(ipaType)) {
			return NUM;
		} else if(STR.ipaType.equals(ipaType)) {
			return STR;
		} else if(LIST.ipaType.equals(ipaType)) {
			return LIST;
		} else if(SET.ipaType.equals(ipaType)) {
			return SET;
		} else if(MAP.ipaType.equals(ipaType)) {
			return MAP;
		} else if(SYM.ipaType.equals(ipaType)) {
			return SYM;
		} else {
			return ANY;
		}
	}
}
