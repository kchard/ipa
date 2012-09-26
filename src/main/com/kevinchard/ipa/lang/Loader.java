package com.kevinchard.ipa.lang;

import java.io.File;
import java.io.InputStream;

public interface Loader {
	
	public Object run(File file);

	public Object run(String codeString);
	
	public Object run(InputStream in);
}
