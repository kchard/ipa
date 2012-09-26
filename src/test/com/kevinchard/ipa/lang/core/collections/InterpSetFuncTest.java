package com.kevinchard.ipa.lang.core.collections;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.kevinchard.ipa.lang.BaseInterpTest;

public class InterpSetFuncTest extends BaseInterpTest {
	
	@Test
	public void testSetAddOneArgs() throws Exception {
		String input = "l := Coll.add(S[1,2,3]); Io.print(l)";
		String output = runTestFromString(input);
		
		assertEquals("S[1, 2, 3]", output);
	}
	
	@Test
	public void testSetAddOneItem() throws Exception {
		String input = "l := Coll.add(S[], 1); Io.print(l)";
		String output = runTestFromString(input);
		
		assertEquals("S[1]", output);
	}
	
	@Test
	public void testSetAddTwoItem() throws Exception {
		String input = "l := Coll.add(S[1], 2, 3); Io.print(l)";
		String output = runTestFromString(input);
		
		assertEquals("S[1, 2, 3]", output);
	}
	
	@Test
	public void testSetRemoveOneArgs() throws Exception {
		String input = "l := Coll.remove(S[1,2,3]); Io.print(l)";
		String output = runTestFromString(input);
		
		assertEquals("S[1, 2, 3]", output);
	}
	
	@Test
	public void testSetRemoveOneItem() throws Exception {
		String input = "l := Coll.remove(S[1], 1); Io.print(l)";
		String output = runTestFromString(input);
		
		assertEquals("S[]", output);
	}
	
	@Test
	public void testSetRemoveTwoItem() throws Exception {
		String input = "l := Coll.remove(S[1, 2], 1, 2); Io.print(l)";
		String output = runTestFromString(input);
		
		assertEquals("S[]", output);
	}
	
	@Test
	public void testSetContainsOneArgs() throws Exception {
		String input = "bool := Coll.contains(S[1,2,3]); Io.print(bool)";
		String output = runTestFromString(input);
		
		assertEquals("true", output);
	}
	
	@Test
	public void testSetContainsOneItem() throws Exception {
		String input = "bool := Coll.contains(S[1], 1); Io.print(bool)";
		String output = runTestFromString(input);
		
		assertEquals("true", output);
	}
	
	@Test
	public void testSetNotContainsOneItem() throws Exception {
		String input = "bool := Coll.contains(S[1], 2); Io.print(bool)";
		String output = runTestFromString(input);
		
		assertEquals("false", output);
	}
	
	@Test
	public void testSetContainsTwoItem() throws Exception {
		String input = "bool := Coll.contains(S[1, 2], 1, 2); Io.print(bool)";
		String output = runTestFromString(input);
		
		assertEquals("true", output);
	}

	@Test
	public void testSetNotContainsTwoItem() throws Exception {
		String input = "size := Coll.contains(S[1, 2], 1, 3); Io.print(size)";
		String output = runTestFromString(input);
		
		assertEquals("false", output);
	}
		
	@Test
	public void testSetSizeOneArgs() throws Exception {
		String input = "size := Coll.size(S[1,2,3]); Io.print(size)";
		String output = runTestFromString(input);
		
		assertEquals("3", output);
	}
	
	@Test
	public void testSetSizeTwoArgs() throws Exception {
		String input = "size := Coll.size(S[1], S[2, 3]); Io.print(size)";
		String output = runTestFromString(input);
		
		assertEquals("3", output);
	}
}
