package com.kevinchard.ipa.lang.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.kevinchard.ipa.lang.BaseInterpTest;


//TODO: These are just a few random examples, rewrite with more thought
public class InterpDynamicFuncTest extends BaseInterpTest {

	@Test
	public void arrityZero() throws Exception {
		String input = "func := | -> Num | { x := Math.add(1, 2); return x }; result := func(); Io.print(result)";
		String output = runTestFromString(input);
		assertEquals("3", output);
	}
	
	@Test
	public void arrityOne() throws Exception {
		String input = "func := | Str s -> Str | { return s }; result := func(\"STRING\"); Io.print(result)";
		String output = runTestFromString(input);
		assertEquals("STRING", output);
	}
	
	@Test
	public void arrityTwo() throws Exception {
		String input = "func := |Num x, Num y -> Num | { z := Math.add(x, y); return z }; result := func(2, 3); Io.print(result)";
		String output = runTestFromString(input);
		assertEquals("5", output);
	}
	
	@Test
	public void nestedFunc() throws Exception {
		String input = "func := | -> Num | { x := | -> Num | { return 10; }; return x() }; result := func(); Io.print(result)";
		String output = runTestFromString(input);
		assertEquals("10", output);
	}
	
	@Test
	public void testReturnList() throws Exception {
		String input = "func := |Num n -> List | { result := Coll.add(L[], n, 2); return result }; result := func(1); Io.print(result)";
		String output = runTestFromString(input);
		assertEquals("L[1, 2]", output);
	}
	
	@Test
	public void testReturnFunc() throws Exception {
		String input = "func := | -> Func | { return | -> Num| { return 1} }; result := func(); Io.print(result())";
		String output = runTestFromString(input);
		assertEquals("1", output);
	}
	
	@Test
	public void testReturnSym() throws Exception {
		String input = "func := | -> Sym | { return :x }; result := func(); Io.print(result)";
		String output = runTestFromString(input);
		assertEquals(":x", output);
	}
}
