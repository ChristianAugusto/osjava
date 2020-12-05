package com.christian.osjava.resources;

import com.christian.osjava.watchers.Dispatcher;
import com.christian.osjava.config.Constants;
import com.christian.osjava.models.CPU;
import com.christian.osjava.utils.Logger;

public class OSCPUs {
	public static CPU[] CPUs;

	public static void init() {
		Logger.info("Initing OSCPUs");

		CPUs = new CPU[Constants.CPUS_TOTAL];

		for (int i = 0; i < Constants.CPUS_TOTAL; i++) {
			CPUs[i] = new CPU(true);

			Runnable runnable = new Dispatcher(CPUs[i], i);
			new Thread(runnable).start();
		}

		Logger.info("OSCPUs initialized with success");
	}

	public static void finish() {
		Logger.info("Finishing OSCPUs");
		CPUs = null;
		System.gc();
		Logger.info("OSCPUs finished with success");
	}

	public static CPU[] getCPUs() {
		return CPUs;
	}
}
