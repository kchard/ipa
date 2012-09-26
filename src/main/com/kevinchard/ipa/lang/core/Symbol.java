package com.kevinchard.ipa.lang.core;


public final  class Symbol {

	private final String symbol;
	
	public Symbol(String symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public int hashCode() {
		return symbol.hashCode();
	}
	
	@Override
	public boolean equals(Object that) {
		
		if(this == that) {
			return true;
		}
		
		if ( !(that instanceof Symbol) ) { 
			return false;
		}
		
		Symbol other = (Symbol) that;
		
		return symbol.equals(other.symbol);
	}
	
	@Override
	public String toString() {
		return symbol;
	}
	
}
