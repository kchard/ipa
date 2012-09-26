package com.kevinchard.ipa.lang;

import java.io.File;

import com.kevinchard.ipa.lang.core.CoreBinding;


public class Ipa {

	public static void main(String[] args) throws Exception {
		
		if(args.length > 0) {
			new IpaInterpreter(CoreBinding.INSTANCE.getBindings()).run(new File(args[0]));
		} else {
			new IpaInterpreter(CoreBinding.INSTANCE.getBindings()).run(System.in);
		}
	}
}
