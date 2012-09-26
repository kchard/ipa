package com.kevinchard.ipa.lang.core.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.kevinchard.ipa.lang.BaseInterpTest;

public class InterpMathFuncTest extends BaseInterpTest {

	@Test
	public void testAdd_NoArgs() throws Exception {
		String input = "x := Math.add(); Io.print(x)";
		String output = runTestFromString(input);	
		
		assertEquals("0", output);
	}
	
	@Test
	public void testAdd_OneArgs() throws Exception {
		String input = "x := Math.add(1); Io.print(x)";
		String output = runTestFromString(input);	
		
		assertEquals("1", output);
	}
	
	@Test
	public void testAdd_TwoArgs() throws Exception {
		String input = "x := Math.add(1, 2); Io.print(x)";
		String output = runTestFromString(input);	
		
		assertEquals("3", output);
	}
	
	@Test
	public void testSub_NoArgs() throws Exception {
		String input = "x := Math.sub(); Io.print(x)";
		String output = runTestFromString(input);	
		
		assertEquals("0", output);
	}
	
	@Test
	public void testSub_OneArgs() throws Exception {
		String input = "x := Math.sub(1); Io.print(x)";
		String output = runTestFromString(input);	
		
		assertEquals("1", output);
	}
	
	@Test
	public void testSub_TwoArgs() throws Exception {
		String input = "x := Math.sub(1, 2); Io.print(x)";
		String output = runTestFromString(input);	
		
		assertEquals("-1", output);
	}
	
	@Test
	public void testMult_NoArgs() throws Exception {
		String input = "x := Math.mult(); Io.print(x)";
		String output = runTestFromString(input);	
		
		assertEquals("1", output);
	}
	
	@Test
	public void testMult_OneArgs() throws Exception {
		String input = "x := Math.mult(3); Io.print(x)";
		String output = runTestFromString(input);	
		
		assertEquals("3", output);
	}
	
	@Test
	public void testMult_TwoArgs() throws Exception {
		String input = "x := Math.mult(2, 3); Io.print(x)";
		String output = runTestFromString(input);	
		
		assertEquals("6", output);
	}
	
	@Test
	public void testDiv_NoArgs() throws Exception {
		String input = "x := Math.div(); Io.print(x)";
		String output = runTestFromString(input);	
		
		assertEquals("1", output);
	}
	
	@Test
	public void testDiv_OneArgs() throws Exception {
		String input = "x := Math.div(3); Io.print(x)";
		String output = runTestFromString(input);	
		
		assertEquals("3", output);
	}
	
	@Test
	public void testDiv_TwoArgs() throws Exception {
		String input = "x := Math.div(6, 2); Io.print(x)";
		String output = runTestFromString(input);	
		
		assertEquals("3", output);
	}
}
