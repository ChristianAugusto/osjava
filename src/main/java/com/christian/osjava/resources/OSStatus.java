package com.christian.osjava.resources;

import com.christian.osjava.utils.Logger;

public class OSStatus {
	/*
	 * Initing 1 - Normal 2 - Error 3 - Finishing 4 - Finished 5
	 */
	private static byte STATUS;

	public static void init() {
		Logger.info("Initing OSStatus");

		STATUS = 1;

		Logger.info("OSStatus initialized with success");
	}

	public static void normal() {
		STATUS = 2;
	}

	public static void error() {
		STATUS = 3;
	}

	public static void finishing() {
		STATUS = 4;
	}

	public static void finished() {
		STATUS = 5;
	}

	public static byte get() {
		return STATUS;
	}
}
