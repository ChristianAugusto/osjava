package com.christian.osjava.watchers;

import com.christian.osjava.config.Constants;
import com.christian.osjava.models.MemoryTask;
import com.christian.osjava.resources.OSMemory;
import com.christian.osjava.resources.OSMemoryTaskWatcher;
import com.christian.osjava.resources.OSMemoryTaskQueue;
import com.christian.osjava.resources.OSStatus;
import com.christian.osjava.utils.Logger;

public class MemoryTaskWatcher implements Runnable {
	public void run() {
		Logger.info("MemoryTaskWatcher initialized with success");
		
		while(OSStatus.get() == Constants.SYSTEM_STATUS_INITING);

		while (OSStatus.get() == Constants.SYSTEM_STATUS_NORMAL) {
			MemoryTask mt = OSMemoryTaskQueue.getMemoryTaskFromMTQ();

			if (mt != null) {
				Logger.info(String.format("Got MemoryTask from MTQ, %s", mt.toString()));

				if (mt.getActionType() == Constants.MEMORY_TASK_ALLOCATE) {
					boolean allocatedMemory = OSMemory.allocateMemory(mt.getProcessId(), mt.getQtdMemory());

					if (allocatedMemory) {
						Logger.info(String.format("MemoryTask success %s", mt.toString()));
						mt.setStatusSuccess();
					}
					else {
						Logger.info(String.format("MemoryTask not success %s", mt.toString()));
						mt.setStatusNotSuccess();
					}
				}
				else if (mt.getActionType() == Constants.MEMORY_TASK_DEALLOCATE) {
					OSMemory.deallocateMemory(mt.getProcessId());
					Logger.info(String.format("MemoryTask success %s", mt.toString()));
				}
				else if (mt.getActionType() == Constants.MEMORY_TASK_DEALLOCATE_TO_ALLOCATE) {
					Logger.info(String.format("Trying preemption %s", mt.toString()));
					// TODO: Implement preemption
				}

				System.gc();
			}
		}

		OSMemoryTaskWatcher.finishMemoryTaskWatcher();

		Logger.info("Finished MemoryTaskWatcher");
	}
}
