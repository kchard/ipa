package com.kevinchard.ipa.lang.core.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.kevinchard.ipa.lang.BaseInterpTest;

public class InterpPrintFuncTest extends BaseInterpTest {
	
	@Test
	public void testPrintString() throws Exception {
		String input = "Io.print(\"Hello World!!!\")";
		String output = runTestFromString(input);
		
		
		assertEquals("Hello World!!!", output);
	}
	
	@Test
	public void testPrintInt() throws Exception {
		String input = "Io.print(1)";
		String output = runTestFromString(input);
		
		assertEquals("1", output);
	}
	
	@Test
	public void testPrintSymbol() throws Exception {
		String input = "Io.print(:symbol)";
		String output = runTestFromString(input);
		
		assertEquals(":symbol", output);
	}
	
	@Test
	public void testPrintList() throws Exception {
		String input = "Io.print(L[1, 2, 3])";
		String output = runTestFromString(input);
		
		assertEquals("L[1, 2, 3]", output);
	}
	
	@Test
	public void testPrintSet() throws Exception {
		String input = "Io.print(S[1, 2, 3])";
		String output = runTestFromString(input);
		
		assertEquals("S[1, 2, 3]", output);
	}
	
	@Test
	public void testPrintMap() throws Exception {
		String input = "Io.print(M[:a : 1, :b : 2, :c : 3])";
		String output = runTestFromString(input);
		
		
		assertTrue(output.indexOf("M[") == 0);
		assertTrue(output.lastIndexOf("]") == output.length() -1 );
		assertTrue(output.contains(":a : 1"));
		assertTrue(output.contains(":b : 2"));
		assertTrue(output.contains(":c : 3"));
	}
	
	@Test
	public void testPrintMultipleValues() throws Exception {
		String input = "Io.print(\"Hello World!!!\", 1)";
		String output = runTestFromString(input);
		
		assertEquals("Hello World!!!1", output);
	}

}
