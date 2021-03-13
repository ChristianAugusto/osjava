package com.christian.osjava.watchers;

import com.christian.osjava.models.Process;
import com.christian.osjava.config.Constants;
import com.christian.osjava.models.CPU;
import com.christian.osjava.models.MemoryTask;
import com.christian.osjava.resources.OSMemoryTaskQueue;
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

		while (OSStatus.get() == Constants.SYSTEM_STATUS_INITING)
			;

		while (OSStatus.get() == Constants.SYSTEM_STATUS_NORMAL) {
			Process process;

			process = OSProcessQueues.getProcessFromFTR();
			if (process != null) {
				Logger.info(String.format("Got Process on CPU %d from FTR, %s", this.cpuIndex, process.getId()));

				MemoryTask mtallo = new MemoryTask(Constants.MEMORY_TASK_ALLOCATE, process.getId(),
						process.getQtdMemory());

				OSMemoryTaskQueue.addMemoryTaskOnMTQ(mtallo);

				while (mtallo.getStatus() == Constants.MEMORY_TASK_STATUS_INITIAL)
					;

				if (mtallo.getStatus() == Constants.MEMORY_TASK_STATUS_SUCCESS) {
					try {
						Thread.sleep(process.getProcessingTime() * 1000);
					}
					catch (Exception e) {
						Logger.error(String.format("Processing process %s", process.getId()));
						OSStatus.error();
						continue;
					}

					MemoryTask mtdea = new MemoryTask(Constants.MEMORY_TASK_DEALLOCATE, process.getId(),
							process.getQtdMemory());

					OSMemoryTaskQueue.addMemoryTaskOnMTQ(mtdea);
				}
				else {
					// TODO: Implement preemption
					OSProcessQueues.addProcessOnFTR(process);
				}

				System.gc();
				continue;
			}

			process = OSProcessQueues.getProcessFromFU();
			if (process != null) {
				Logger.info(String.format("Got Process on CPU %d from FU, %s", this.cpuIndex, process.getId()));

				MemoryTask mtallo = new MemoryTask(Constants.MEMORY_TASK_ALLOCATE, process.getId(),
						process.getQtdMemory());

				OSMemoryTaskQueue.addMemoryTaskOnMTQ(mtallo);

				while (mtallo.getStatus() == Constants.MEMORY_TASK_STATUS_INITIAL)
					;

				if (mtallo.getStatus() == Constants.MEMORY_TASK_STATUS_SUCCESS) {
					int sleepingSeconds = Constants.QUANTUM;

					if (process.getProcessingTime() - process.getProcessedTime() < Constants.QUANTUM) {
						sleepingSeconds = process.getProcessedTime();
					}

					try {
						Thread.sleep(sleepingSeconds * 1000);
					}
					catch (Exception e) {
						Logger.error(String.format("Processing process %s", process.getId()));
						OSStatus.error();
						continue;
					}

					MemoryTask mtdea = new MemoryTask(Constants.MEMORY_TASK_DEALLOCATE, process.getId(),
							process.getQtdMemory());

					OSMemoryTaskQueue.addMemoryTaskOnMTQ(mtdea);

					process.setProcessedTime(sleepingSeconds);

					if (process.getProcessedTime() < process.getProcessingTime()) {
						OSProcessQueues.addProcessOnFU2(process);
					}
				}
				else {
					OSProcessQueues.addProcessOnFU(process);
				}

				System.gc();
				continue;
			}

			process = OSProcessQueues.getProcessFromFU2();
			if (process != null) {
				Logger.info(String.format("Got Process on CPU %d from FU2, %s", this.cpuIndex, process.getId()));

				MemoryTask mtallo = new MemoryTask(Constants.MEMORY_TASK_ALLOCATE, process.getId(),
						process.getQtdMemory());

				OSMemoryTaskQueue.addMemoryTaskOnMTQ(mtallo);

				while (mtallo.getStatus() == Constants.MEMORY_TASK_STATUS_INITIAL)
					;

				if (mtallo.getStatus() == Constants.MEMORY_TASK_STATUS_SUCCESS) {
					int sleepingSeconds = Constants.QUANTUM;

					if (process.getProcessingTime() - process.getProcessedTime() < Constants.QUANTUM) {
						sleepingSeconds = process.getProcessedTime();
					}

					try {
						Thread.sleep(sleepingSeconds * 1000);
					}
					catch (Exception e) {
						Logger.error(String.format("Processing process %s", process.getId()));
						OSStatus.error();
						continue;
					}

					MemoryTask mtdea = new MemoryTask(Constants.MEMORY_TASK_DEALLOCATE, process.getId(),
							process.getQtdMemory());

					OSMemoryTaskQueue.addMemoryTaskOnMTQ(mtdea);

					process.setProcessedTime(sleepingSeconds);

					if (process.getProcessedTime() < process.getProcessingTime()) {
						OSProcessQueues.addProcessOnFU3(process);
					}
				}
				else {
					OSProcessQueues.addProcessOnFU2(process);
				}

				System.gc();
				continue;
			}

			process = OSProcessQueues.getProcessFromFU3();
			if (process != null) {
				Logger.info(String.format("Got Process on CPU %d from FU3, %s", this.cpuIndex, process.getId()));

				MemoryTask mtallo = new MemoryTask(Constants.MEMORY_TASK_ALLOCATE, process.getId(),
						process.getQtdMemory());

				OSMemoryTaskQueue.addMemoryTaskOnMTQ(mtallo);

				while (mtallo.getStatus() == Constants.MEMORY_TASK_STATUS_INITIAL)
					;

				if (mtallo.getStatus() == Constants.MEMORY_TASK_STATUS_SUCCESS) {
					int sleepingSeconds = Constants.QUANTUM;

					if (process.getProcessingTime() - process.getProcessedTime() < Constants.QUANTUM) {
						sleepingSeconds = process.getProcessedTime();
					}

					try {
						Thread.sleep(sleepingSeconds * 1000);
					}
					catch (Exception e) {
						Logger.error(String.format("Processing process %s", process.getId()));
						OSStatus.error();
						continue;
					}

					MemoryTask mtdea = new MemoryTask(Constants.MEMORY_TASK_DEALLOCATE, process.getId(),
							process.getQtdMemory());

					OSMemoryTaskQueue.addMemoryTaskOnMTQ(mtdea);

					process.setProcessedTime(sleepingSeconds);

					if (process.getProcessedTime() < process.getProcessingTime()) {
						OSProcessQueues.addProcessOnFU3(process);
					}
				}
				else {
					OSProcessQueues.addProcessOnFU3(process);
				}

				System.gc();
				continue;
			}
		}

		this.cpu.finishDispatcher();

		Logger.info(String.format("Finished dispacher on CPU %d", this.cpuIndex));
	}
}
