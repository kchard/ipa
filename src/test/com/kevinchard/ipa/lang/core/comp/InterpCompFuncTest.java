package com.kevinchard.ipa.lang.core.comp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.kevinchard.ipa.lang.BaseInterpTest;

public class InterpCompFuncTest extends BaseInterpTest {
	
	@Test
	public void testEqualZeroArgs() throws Exception {
		String input = "result := Comp.equal(); Io.print(result)";
		String output = runTestFromString(input);
		
		assertEquals("true", output);
	}
	
	@Test
	public void testEqualOneArgs() throws Exception {
		String input = "result := Comp.equal(1); Io.print(result)";
		String output = runTestFromString(input);
		
		assertEquals("true", output);
	}
	
	@Test
	public void testNumEqual() throws Exception {
		String input = "result := Comp.equal(1, 1); Io.print(result)";
		String output = runTestFromString(input);
		
		assertEquals("true", output);
	}
	
	@Test
	public void testNumNotEqual() throws Exception {
		String input = "result := Comp.equal(1, 2); Io.print(result)";
		String output = runTestFromString(input);
		
		assertEquals("false", output);
	}
	
	@Test
	public void testStrEqual() throws Exception {
		String input = "result := Comp.equal(\"a\", \"a\"); Io.print(result)";
		String output = runTestFromString(input);
		
		assertEquals("true", output);
	}
	
	@Test
	public void testStrNotEqual() throws Exception {
		String input = "result := Comp.equal(\"a\", \"b\"); Io.print(result)";
		String output = runTestFromString(input);
		
		assertEquals("false", output);
	}
	
	@Test
	public void testSymbolEqual() throws Exception {
		String input = "result := Comp.equal(:a, :a); Io.print(result)";
		String output = runTestFromString(input);
		
		assertEquals("true", output);
	}
	
	@Test
	public void testSymbolNotEqual() throws Exception {
		String input = "result := Comp.equal(:a, :b); Io.print(result)";
		String output = runTestFromString(input);
		
		assertEquals("false", output);
	}
	
	@Test
	public void testListEqual() throws Exception {
		String input = "result := Comp.equal(L[1], L[1]); Io.print(result)";
		String output = runTestFromString(input);
		
		assertEquals("true", output);
	}
	
	@Test
	public void testListNotEqual() throws Exception {
		String input = "result := Comp.equal(L[1], L[]); Io.print(result)";
		String output = runTestFromString(input);
		
		assertEquals("false", output);
	}
	
	@Test
	public void testSetEqual() throws Exception {
		String input = "result := Comp.equal(S[1, 2], S[1, 2]); Io.print(result)";
		String output = runTestFromString(input);
		
		assertEquals("true", output);
	}
	
	@Test
	public void testSetNotEqual() throws Exception {
		String input = "result := Comp.equal(S[1, 2], S[1, 3]); Io.print(result)";
		String output = runTestFromString(input);
		
		assertEquals("false", output);
	}

	@Test
	public void testMapEqual() throws Exception {
		String input = "result := Comp.equal(M[:a : 1, :b : 2], M[:a : 1, :b : 2]); Io.print(result)";
		String output = runTestFromString(input);
		
		assertEquals("true", output);
	}
	
	@Test
	public void testMapNotEqual() throws Exception {
		String input = "result := Comp.equal(M[:a : 1, :b : 2], M[:a : 1, :c : 2]); Io.print(result)";
		String output = runTestFromString(input);
		
		assertEquals("false", output);
	}
}
