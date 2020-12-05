package com.christian.osjava.resources;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import com.christian.osjava.models.MemoryTask;
import com.christian.osjava.utils.Logger;

public class OSMemoryTaskQueue {
	private static Queue<MemoryTask> MTQ;

	public static void init() {
		Logger.info("Initing OSMemoryTaskQueue");

		Logger.info("Initing MTQ");
		MTQ = new LinkedList<MemoryTask>();
		Logger.info("MTQ initialized with success");

		Logger.info("OSMemoryTaskQueue initialized with success");
	}

	public static void finish() {
		Logger.info("Finishing OSMemoryTaskQueue");
		MTQ.clear();
		MTQ = null;
		Logger.info("OSMemoryTaskQueue finished with success");
	}

	public static void addMemoryTaskOnMTQ(MemoryTask p) {
		MTQ.add(p);
	}

	public static MemoryTask getMemoryTaskFromMTQ() {
		try {
			return MTQ.remove();
		}
		catch (NoSuchElementException e) {
			return null;
		}
	}
}
