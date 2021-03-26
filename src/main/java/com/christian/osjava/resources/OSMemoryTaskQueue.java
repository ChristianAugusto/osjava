package com.christian.osjava.resources;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import com.christian.osjava.models.MemoryTask;
import com.christian.osjava.utils.Logger;

public class OSMemoryTaskQueue {
	private static Queue<MemoryTask> MTQ;
    private static boolean queuesOn;

	public static void init() {
		Logger.info("Initing OSMemoryTaskQueue");

		Logger.info("Initing MTQ");
		MTQ = new LinkedList<MemoryTask>();
		Logger.info("MTQ initialized with success");

		Logger.info("OSMemoryTaskQueue initialized with success");

        queuesOn = true;
	}

	public static void finish() {
        Logger.info("Finishing OSMemoryTaskQueue");
        queuesOn = false;

		MTQ.clear();
		MTQ = null;
		Logger.info("OSMemoryTaskQueue finished with success");
	}

	public static void addMemoryTaskOnMTQ(MemoryTask mt) {
		MTQ.add(mt);
	}

	public static MemoryTask getMemoryTaskFromMTQ() {
		try {
            if (isQueuesOn()) {
                return MTQ.remove();
            }

            return null;
		}
		catch (NoSuchElementException e) {
			return null;
		}
	}

    public static boolean isQueuesOn() {
        return queuesOn;
    }
}
