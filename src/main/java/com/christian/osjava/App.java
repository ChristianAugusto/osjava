package com.christian.osjava;

//import com.christian.osjava.functions.ReadProcessFromFile;
import com.christian.osjava.resources.OSCPUs;
import com.christian.osjava.resources.OSDistributor;
import com.christian.osjava.resources.OSMemory;
import com.christian.osjava.resources.OSMemoryTaskQueue;
import com.christian.osjava.resources.OSMemoryTaskWatcher;
import com.christian.osjava.resources.OSProcessQueues;
import com.christian.osjava.resources.OSStatus;
import com.christian.osjava.resources.OSTurnOffSystem;
import com.christian.osjava.utils.Logger;
//import com.christian.osjava.tests.ProcessTest;
import com.christian.osjava.tests.TestEnqueue;

public class App {
	public static void main(String[] args) {
		/* Initializers */
		Logger.info("Initing OS");
		OSStatus.init();
		OSMemory.init();
		OSMemoryTaskQueue.init();
		OSMemoryTaskWatcher.init();
		OSProcessQueues.init();
		OSDistributor.init();
		OSCPUs.init();
		Logger.info("OS initialized with success");
		OSStatus.normal();

		/* Tests */
//		ProcessTest.init();
//		OSMemory.print_memory();
//		ReadProcessFromFile.run();
		TestEnqueue.init();
		OSStatus.finishing();

		/* keeping system on */
		OSTurnOffSystem.init();

		/* Finishers */
		Logger.info("Finishing OS");
		OSCPUs.finish();
		OSMemoryTaskWatcher.finish();
		OSMemory.finish();
		OSDistributor.finish();
		OSProcessQueues.finish();
		OSStatus.finished();
		Logger.info("OS finished with success");
	}
}
