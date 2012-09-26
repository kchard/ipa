package com.kevinchard.ipa.util;

import java.io.PrintStream;

public class ErrorMonitor extends PrintStream {

	public ErrorMonitor() {
		super(System.err);
	}
	
	public void println(String output) {
		throw new RuntimeException(output);
	}
}
