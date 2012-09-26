package com.kevinchard.ipa.lang.core.collections;

import org.junit.Test;

import com.kevinchard.ipa.lang.BaseInterpTest;
import com.kevinchard.ipa.lang.TypeException;

public class SemanticCollectionTest extends BaseInterpTest {
	
	@Test(expected=TypeException.class)
	public void testCollectionAddNoArgs() throws Exception {
		String input = "l := Coll.add()";
		runTestFromString(input);
	}
	
	@Test(expected=TypeException.class)
	public void testCollectionRemoveNoArgs() throws Exception {
		String input = "l := Coll.add()";
		runTestFromString(input);
	}
	
	@Test(expected=TypeException.class)
	public void testCollectionContainsNoArgs() throws Exception {
		String input = "l := Coll.add()";
		runTestFromString(input);
	}

	@Test(expected=TypeException.class)
	public void testCollectionSizeNoArgs() throws Exception {
		String input = "l := Coll.add()";
		runTestFromString(input);
	}
}
