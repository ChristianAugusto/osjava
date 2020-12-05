package com.christian.osjava.watchers;

import com.christian.osjava.config.Constants;
import com.christian.osjava.models.Process;
import com.christian.osjava.resources.OSDistributor;
import com.christian.osjava.resources.OSProcessQueues;
import com.christian.osjava.resources.OSStatus;
import com.christian.osjava.utils.Logger;

public class Distributor implements Runnable {
	public void run() {
		Logger.info("Distributor initialized with success");

		while (OSStatus.get() == Constants.SYSTEM_STATUS_NORMAL) {
			Process aux;

			aux = OSProcessQueues.getProcessFromFE();
			if (aux != null) {
				Logger.info(String.format("Got Process on Distributor from FE, %s", aux.toString()));

				if (aux.getPriority() == Constants.REAL_TIME_PROCESS_PRIORITY) {
					OSProcessQueues.addProcessOnFE(aux);
				}
				else {
					OSProcessQueues.addProcessOnFU(aux);
				}

				System.gc();
				continue;
			}
		}

		OSDistributor.finishDistributor();

		Logger.info("Finished Distributor");
	}
}
