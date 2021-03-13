package com.christian.osjava.resources;

import com.christian.osjava.utils.Logger;

public class OSStatus {
	/**
	 * Initing 1 - Normal 2 - Error 3 - Finishing 4 - Finished 5
	 */
	private static short CODE;

	public static void init() {
		Logger.info("Initing OSStatus");

		CODE = 1;

		Logger.info("OSStatus initialized with success");
	}

	public static void normal() {
		Logger.info("Setting OSStatus normal");
		CODE = 2;
	}

	public static void error() {
		Logger.info("Setting OSStatus error");
		CODE = 3;
	}

	public static void finishing() {
		Logger.info("Setting OSStatus finishing");
		CODE = 4;
	}

	public static void finished() {
		Logger.info("Setting OSStatus finished");
		CODE = 5;
	}

	public static short get() {
		return CODE;
	}
}
