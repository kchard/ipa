package com.kevinchard.ipa.lang;

import java.io.File;
import java.io.InputStream;

import com.kevinchard.ipa.lang.core.CoreBinding;
import com.kevinchard.ipa.util.ErrorMonitor;
import com.kevinchard.ipa.util.StdOutMonitor;

public class BaseInterpTest {
	
	static {
		System.setErr(new ErrorMonitor());
		System.setOut(new StdOutMonitor());
	}
	
	protected String runTestFromFile(File file) throws Exception {
		new IpaInterpreter(CoreBinding.INSTANCE.getBindings()).run(file);
		
		StdOutMonitor m = (StdOutMonitor) System.out;
		
		return m.getOutput();
	}
	
	protected String runTestFromFilePath(String path) throws Exception {
		new IpaInterpreter(CoreBinding.INSTANCE.getBindings()).run(new File(path));
		
		StdOutMonitor m = (StdOutMonitor) System.out;
		
		return m.getOutput();
	}

	protected String runTestFromString(String codeString) throws Exception {
		new IpaInterpreter(CoreBinding.INSTANCE.getBindings()).run(codeString);
		
		StdOutMonitor m = (StdOutMonitor) System.out;
		
		return m.getOutput();
	}
	
	protected String runTestFromInputStream(InputStream in) throws Exception {
		new IpaInterpreter(CoreBinding.INSTANCE.getBindings()).run(in);
		
		StdOutMonitor m = (StdOutMonitor) System.out;
		
		return m.getOutput();
	}
}
