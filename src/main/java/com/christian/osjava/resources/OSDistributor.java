package com.christian.osjava.resources;

import com.christian.osjava.utils.Logger;
import com.christian.osjava.watchers.Distributor;

public class OSDistributor {
	private static boolean DistributorRunning;

	public static void init() {
		Logger.info("Initing Distributor");

		Runnable runnable = new Distributor();
		new Thread(runnable).start();
		DistributorRunning = true;
	}

	public static void finish() {
		Logger.info("Finishing Distributor");

		Logger.info("Distributor finished with success");
	}

	public static boolean isDistributorRunning() {
		return DistributorRunning;
	}

	public static void finishDistributor() {
		DistributorRunning = false;
	}
}
