package com.kevinchard.ipa.lang.core.io;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kevinchard.ipa.lang.BaseInterpTest;

public class InterpRequireFuncTest extends BaseInterpTest {
	
	private File tmpFile;
	
	@Before
	public void setUp() throws IOException {
		tmpFile = File.createTempFile("test", ".ipa");
	}
	
	@After
	public void tearDown() {
		tmpFile.delete();
	}
	
	@Test
	public void testTopLevelRequire() throws Exception {
		
		String module = "Mod.func := |->Num| { return 1 }";
		writeToFile(module);
		
		String filePath = tmpFile.getAbsolutePath();
		
		String input = "Io.require(\"" + filePath + "\"); x := Mod.func(); Io.print(x)";
		
		String output = runTestFromString(input);
		assertEquals("1", output);
	}
	
	@Test
	public void testNestedLevelRequire() throws Exception {
		
		String module = "Mod.func := |->Num| { return 1 }";
		writeToFile(module);
		
		String filePath = tmpFile.getAbsolutePath();
		
		String input = "x := |-> Num | { Io.require(\"" + filePath + "\"); return Mod.func() } Io.print(x())";
		
		String output = runTestFromString(input);
		assertEquals("1", output);
	}
	
	private void writeToFile(String code) throws Exception {
		FileWriter writer = new FileWriter(tmpFile);
		writer.write(code);
		writer.close();
	}
}
