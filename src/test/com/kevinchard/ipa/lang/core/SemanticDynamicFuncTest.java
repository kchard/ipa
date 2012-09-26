package com.kevinchard.ipa.lang.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.kevinchard.ipa.lang.BaseInterpTest;
import com.kevinchard.ipa.lang.BindingException;
import com.kevinchard.ipa.lang.TypeException;

public class SemanticDynamicFuncTest extends BaseInterpTest {

	@Test(expected=BindingException.class)
	public void testRebindCoreFunc() throws Exception {
		String input = "Io.print := | -> Num | { return 1 };";
		runTestFromString(input);
	}
	
	@Test(expected=BindingException.class)
	public void testUndefinedFunc() throws Exception {
		String input = "x := f()";
		runTestFromString(input);
	}
	
	@Test(expected=TypeException.class)
	public void testNonFuncCall() throws Exception {
		String input = "x := 1; y := x()";
		runTestFromString(input);
	}
	
	@Test(expected=TypeException.class)
	public void testParameterTypeMismatchNum() throws Exception {
		String input = "func := | Num n -> Num | { return n }; func(\"A STRING\")";
		runTestFromString(input);
	}
	
	@Test(expected=TypeException.class)
	public void testParameterTypeMismatchStr() throws Exception {
		String input = "func := | Str n -> Str | { return n }; func(1)";
		runTestFromString(input);
	}
	
	@Test(expected=TypeException.class)
	public void testParameterTypeMismatchList() throws Exception {
		String input = "func := | List n -> List | { return n }; func(1)";
		runTestFromString(input);
	}
	
	@Test(expected=TypeException.class)
	public void testParameterTypeMismatchSet() throws Exception {
		String input = "func := | Set n -> Set | { return n }; func(1)";
		runTestFromString(input);
	}
	
	@Test(expected=TypeException.class)
	public void testParameterTypeMismatchMap() throws Exception {
		String input = "func := | Map n -> Map | { return n }; func(1)";
		runTestFromString(input);
	}
	
	@Test(expected=TypeException.class)
	public void testParameterTypeMismatchSymbol() throws Exception {
		String input = "func := | Sym n -> Sym | { return n }; func(1)";
		runTestFromString(input);
	}
	
	@Test
	public void testParameterTypeAny() throws Exception {
		String input = "func := | Any n -> Any | { return n }; Io.print(func(1))";
		String output = runTestFromString(input);
		assertEquals("1", output);
	}
	
	@Test(expected=TypeException.class)
	public void testReturnTypeMismatchNum() throws Exception {
		String input = "func := | -> Num | { return L[] }; func()";
		runTestFromString(input);
	}
	
	@Test(expected=TypeException.class)
	public void testReturnTypeMismatchStr() throws Exception {
		String input = "func := | -> Str | { return 1}; func()";
		runTestFromString(input);
	}
	
	@Test(expected=TypeException.class)
	public void testReturnTypeMismatchList() throws Exception {
		String input = "func := | -> List | { return S[] }; func()";
		runTestFromString(input);
	}
	
	@Test(expected=TypeException.class)
	public void testReturnTypeMismatchSet() throws Exception {
		String input = "func := | -> Set | { return M[] }; func()";
		runTestFromString(input);
	}
	
	@Test(expected=TypeException.class)
	public void testReturnTypeMismatchMap() throws Exception {
		String input = "func := | -> Map | { return :x }; func()";
		runTestFromString(input);
	}
	
	@Test(expected=TypeException.class)
	public void testReturnTypeMismatchSymbol() throws Exception {
		String input = "func := | -> Sym | { return \"a\" }; func()";
		runTestFromString(input);
	}
	
	@Test
	public void testReturnTypeAny() throws Exception {
		String input = "func := | -> Any | { return 1 }; Io.print(func())";
		String output = runTestFromString(input);
		assertEquals("1", output);
	}
}
