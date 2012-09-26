package com.kevinchard.ipa.util;

import java.io.PrintStream;

public class StdOutMonitor extends PrintStream {

	private final PrintStream out;
	private StringBuilder sb;
	
	public StdOutMonitor() {
		super(System.out);
		out = System.out;
		sb = new  StringBuilder();
	}
	
	public void println(String output) {
		sb.append(output);
		out.println(output);
	}

	public String getOutput() {
		String output = sb.toString();
		sb = new StringBuilder();
		return output;
	}
}
