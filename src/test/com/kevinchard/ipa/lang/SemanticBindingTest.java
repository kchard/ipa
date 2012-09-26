package com.kevinchard.ipa.lang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.kevinchard.ipa.lang.BindingException;


public class SemanticBindingTest extends BaseInterpTest {

	@Test
	public void testSingleBinding() throws Exception {
		String input = "x := 1; Io.print(x)";
		String output = runTestFromString(input);
		
		assertEquals("1", output);
	}
	
	@Test
	public void testBindingDifferentScopes() throws Exception {
		String input = "x := 1; y := | Num x -> Num | { return x }; Io.print(y(x))";
		String output = runTestFromString(input);
		
		assertEquals("1", output);
	}
	
	@Test(expected=BindingException.class)
	public void testRebinding() throws Exception {
		String input = "x := 1; x := 2";
		runTestFromString(input);
	}
	
	@Test(expected=BindingException.class)
	public void testRebindingInFunc() throws Exception {
		String input = "y := | Num x -> Num | { x := 2; return x }; y(1)";
		runTestFromString(input);
	}
	
	@Test(expected=BindingException.class)
	public void testUnbound() throws Exception {
		String input = "x := add(y)";
		runTestFromString(input);
	}
	
	@Test(expected=BindingException.class)
	public void testUnboundFuncParameter() throws Exception {
		String input = "y := | Num x -> Num | { return x }; y()";
		runTestFromString(input);
	}
	
	@Test(expected=BindingException.class)
	public void testTooManyArgsForFunc() throws Exception {
		String input = "y := | Num x -> Num | { return x }; y(1, 2)";
		runTestFromString(input);
	}
}
