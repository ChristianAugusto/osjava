package com.christian.osjava.resources;

import com.christian.osjava.config.Constants;
import com.christian.osjava.models.CPU;
import com.christian.osjava.utils.Logger;

public class OSTurnOffSystem {
	public static void init() {
		Logger.info("Initing OSTurnOffSystem");

		while (OSStatus.get() == Constants.SYSTEM_STATUS_NORMAL)
			;

		Logger.info("Waiting system resources turn off");

		while (true) {
			int cpsRunning = 0;

			CPU[] CPUs = OSCPUs.getCPUs();
			for (int i = 0; i < Constants.CPUS_TOTAL; i++) {
				if (CPUs[i].isDispatcherRunning()) {
					cpsRunning++;
					break;
				}
			}

			if (
                cpsRunning == 0 &&
                !OSMemoryTaskWatcher.isMemoryTaskWatcherRunning()
            ) {
				break;
			}
		}
	}
}
