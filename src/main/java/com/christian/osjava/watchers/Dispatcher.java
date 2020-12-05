package com.christian.osjava.watchers;

import com.christian.osjava.models.Process;
import com.christian.osjava.config.Constants;
import com.christian.osjava.models.CPU;
import com.christian.osjava.resources.OSProcessQueues;
import com.christian.osjava.resources.OSStatus;
import com.christian.osjava.utils.Logger;

public class Dispatcher implements Runnable {
	private CPU cpu;
	private int cpuIndex;

	public Dispatcher(CPU cpu, int cpuIndex) {
		this.cpu = cpu;
		this.cpuIndex = cpuIndex;
	}

	public void run() {
		Logger.info(String.format("Initing dispacher on CPU %d", this.cpuIndex));

		while (OSStatus.get() == Constants.SYSTEM_STATUS_NORMAL) {
			Process aux;

			aux = OSProcessQueues.getProcessFromFTR();
			if (aux != null) {
				Logger.info(String.format("Got Process on CPU %d from FTR, %s", this.cpuIndex, aux.toString()));

				System.gc();
				continue;
			}

			aux = OSProcessQueues.getProcessFromFU();
			if (aux != null) {
				Logger.info(String.format("Got Process on CPU %d from FU, %s", this.cpuIndex, aux.toString()));

				System.gc();
				continue;
			}

			aux = OSProcessQueues.getProcessFromFU2();
			if (aux != null) {
				Logger.info(String.format("Got Process on CPU %d from FU2, %s", this.cpuIndex, aux.toString()));

				System.gc();
				continue;
			}

			aux = OSProcessQueues.getProcessFromFU3();
			if (aux != null) {
				Logger.info(String.format("Got Process on CPU %d from FU3, %s", this.cpuIndex, aux.toString()));

				System.gc();
				continue;
			}
		}

		this.cpu.finishDispatcher();

		Logger.info(String.format("Finished dispacher on CPU %d", this.cpuIndex));
	}
}
