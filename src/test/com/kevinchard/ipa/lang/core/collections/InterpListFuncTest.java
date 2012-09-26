package com.kevinchard.ipa.lang.core.collections;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.kevinchard.ipa.lang.BaseInterpTest;

public class InterpListFuncTest extends BaseInterpTest {
	
	@Test
	public void testListAddOneArgs() throws Exception {
		String input = "l := Coll.add(L[1,2,3]); Io.print(l)";
		String output = runTestFromString(input);
		
		assertEquals("L[1, 2, 3]", output);
	}
	
	@Test
	public void testListAddOneItem() throws Exception {
		String input = "l := Coll.add(L[], 1); Io.print(l)";
		String output = runTestFromString(input);
		
		assertEquals("L[1]", output);
	}
	
	@Test
	public void testListAddTwoItem() throws Exception {
		String input = "l := Coll.add(L[1], 2, 3); Io.print(l)";
		String output = runTestFromString(input);
		
		assertEquals("L[1, 2, 3]", output);
	}
	
	@Test
	public void testListRemoveOneArgs() throws Exception {
		String input = "l := Coll.remove(L[1,2,3]); Io.print(l)";
		String output = runTestFromString(input);
		
		assertEquals("L[1, 2, 3]", output);
	}
	
	@Test
	public void testListRemoveOneItem() throws Exception {
		String input = "l := Coll.remove(L[1], 1); Io.print(l)";
		String output = runTestFromString(input);
		
		assertEquals("L[]", output);
	}
	
	@Test
	public void testListRemoveTwoItem() throws Exception {
		String input = "l := Coll.remove(L[1, 2], 1, 2); Io.print(l)";
		String output = runTestFromString(input);
		
		assertEquals("L[]", output);
	}
	
	@Test
	public void testListContainsOneArgs() throws Exception {
		String input = "bool := Coll.contains(L[1,2,3]); Io.print(bool)";
		String output = runTestFromString(input);
		
		assertEquals("true", output);
	}
	
	@Test
	public void testListContainsOneItem() throws Exception {
		String input = "bool := Coll.contains(L[1], 1); Io.print(bool)";
		String output = runTestFromString(input);
		
		assertEquals("true", output);
	}
	
	@Test
	public void testListNotContainsOneItem() throws Exception {
		String input = "bool := Coll.contains(L[1], 2); Io.print(bool)";
		String output = runTestFromString(input);
		
		assertEquals("false", output);
	}
	
	@Test
	public void testListContainsTwoItem() throws Exception {
		String input = "bool := Coll.contains(L[1, 2], 1, 2); Io.print(bool)";
		String output = runTestFromString(input);
		
		assertEquals("true", output);
	}

	@Test
	public void testListNotContainsTwoItem() throws Exception {
		String input = "bool := Coll.contains(L[1, 2], 1, 3); Io.print(bool)";
		String output = runTestFromString(input);
		
		assertEquals("false", output);
	}
	
	@Test
	public void testListSizeOneArgs() throws Exception {
		String input = "bool := Coll.size(L[1,2,3]); Io.print(bool)";
		String output = runTestFromString(input);
		
		assertEquals("3", output);
	}
	
	@Test
	public void testListSizeTwoArgs() throws Exception {
		String input = "bool := Coll.size(L[1], L[2, 3]); Io.print(bool)";
		String output = runTestFromString(input);
		
		assertEquals("3", output);
	}
}
