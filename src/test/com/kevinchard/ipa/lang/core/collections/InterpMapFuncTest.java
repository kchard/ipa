package com.kevinchard.ipa.lang.core.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.kevinchard.ipa.lang.BaseInterpTest;

public class InterpMapFuncTest extends BaseInterpTest {

	@Test
	public void testMapAddOneArgs() throws Exception {
		String input = "l := Coll.add(M[:a : 1]); Io.print(l)";
		String output = runTestFromString(input);
		
		assertEquals("M[:a : 1]", output);
	}
	
	@Test
	public void testMapAddOneItem() throws Exception {
		String input = "l := Coll.add(M[], :a, 1); Io.print(l)";
		String output = runTestFromString(input);
		
		assertEquals("M[:a : 1]", output);
	}
	
	@Test
	public void testMapAddTwoItem() throws Exception {
		String input = "l := Coll.add(M[], :a, 1, :b, 2); Io.print(l)";
		String output = runTestFromString(input);
		
		assertTrue(output.startsWith("M["));
		assertTrue(output.endsWith("]"));
		assertTrue(output.contains(":a : 1"));
		assertTrue(output.contains(":b : 2"));
	}
	
	@Test
	public void testMapRemoveOneArgs() throws Exception {
		String input = "l := Coll.remove(M[:a : 1]); Io.print(l)";
		String output = runTestFromString(input);
		
		assertEquals("M[:a : 1]", output);
	}
	
	@Test
	public void testMapRemoveOneItem() throws Exception {
		String input = "l := Coll.remove(M[:a : 1], :a); Io.print(l)";
		String output = runTestFromString(input);
		
		assertEquals("M[]", output);
	}
	
	@Test
	public void testMapRemoveTwoItem() throws Exception {
		String input = "l := Coll.remove(M[:a : 1, :b : 2], :a, :b); Io.print(l)";
		String output = runTestFromString(input);
		
		assertEquals("M[]", output);
	}
	
	@Test
	public void testMapContainsOneArgs() throws Exception {
		String input = "bool := Coll.contains(M[:a : 1]); Io.print(bool)";
		String output = runTestFromString(input);
		
		assertEquals("true", output);
	}
	
	@Test
	public void testMapContainsOneItem() throws Exception {
		String input = "bool := Coll.contains(M[:a : 1], :a); Io.print(bool)";
		String output = runTestFromString(input);
		
		assertEquals("true", output);
	}
	
	@Test
	public void testMapNotContainsOneItem() throws Exception {
		String input = "bool := Coll.contains(M[:a : 1], :b); Io.print(bool)";
		String output = runTestFromString(input);
		
		assertEquals("false", output);
	}
	
	@Test
	public void testMapContainsTwoItem() throws Exception {
		String input = "bool := Coll.contains(M[:a : 1, :b : 2], :a, :b); Io.print(bool)";
		String output = runTestFromString(input);
		
		assertEquals("true", output);
	}

	@Test
	public void testMapNotContainsTwoItem() throws Exception {
		String input = "bool := Coll.contains(M[:a : 1, :b : 2], :a, :c); Io.print(bool)";
		String output = runTestFromString(input);
		
		assertEquals("false", output);
	}
	
	@Test
	public void testMapSizeOneArgs() throws Exception {
		String input = "bool := Coll.size(M[:a : 1, :b : 2]); Io.print(bool)";
		String output = runTestFromString(input);
		
		assertEquals("2", output);
	}
	
	@Test
	public void testMapSizeTwoArgs() throws Exception {
		String input = "bool := Coll.size(M[:a : 1, :b : 2], M[:a : 1]); Io.print(bool)";
		String output = runTestFromString(input);
		
		assertEquals("3", output);
	}
}
