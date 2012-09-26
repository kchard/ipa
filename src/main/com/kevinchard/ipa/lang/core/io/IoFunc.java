package com.kevinchard.ipa.lang.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import com.kevinchard.ipa.lang.Loader;
import com.kevinchard.ipa.lang.core.RequiresLoader;
import com.kevinchard.ipa.lang.core.UnscopedFunction;

public abstract class IoFunc extends UnscopedFunction {

	public Object call(List<Object> args) {
		for(Object arg : args) {
			doOperation(arg.toString());
		}
		
		return null;
	}
	
	protected abstract void doOperation(String arg);
	
	public static final class Print extends IoFunc {

		protected void doOperation(String arg) {
			System.out.println(arg);
		}
	}
	
	public static final class Require extends IoFunc implements RequiresLoader {

		private Loader loader;

		@Override
		protected void doOperation(String arg) {
			String module = (String)arg;
			File f = new File(module);
			try {
				loader.run(new FileInputStream(f));
			} catch (FileNotFoundException e) {
				throw new RuntimeException("FDSFSDFS");
			}
		}

		@Override
		public void setLoader(Loader loader) {
			this.loader = loader;
		}
	}
}