package com.christian.osjava;

import com.christian.osjava.resources.OSCPUs;
import com.christian.osjava.resources.OSMemory;
import com.christian.osjava.resources.OSProcessQueues;
import com.christian.osjava.resources.OSStatus;
import com.christian.osjava.utils.Logger;
//import com.christian.osjava.tests.ProcessTest;

public class App {
	public static void main(String[] args) {
		/* Initializers */
		Logger.info("Initing OS");
		OSStatus.init();
		OSMemory.init();
		OSProcessQueues.init();
		OSCPUs.init();
		Logger.info("OS initialized with success");
		OSStatus.normal();

		/* Tests */
//		ProcessTest.init();
//		OSMemory.print_memory();

		/* Finishers */
		Logger.info("Finishing OS");
		OSProcessQueues.finish();
		OSCPUs.finish();
		OSMemory.finish();
		OSStatus.finished();
		Logger.info("OS finished with success");
	}
}
