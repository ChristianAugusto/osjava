package com.christian.osjava.resources;

import com.christian.osjava.utils.Logger;
import com.christian.osjava.watchers.MemoryTaskWatcher;

public class OSMemoryTaskWatcher {
	private static boolean MemoryTaskWatcherRunning;

	public static void init() {
		Logger.info("Initing MemoryTaskWatcher");

		Runnable runnable = new MemoryTaskWatcher();
		new Thread(runnable).start();
		MemoryTaskWatcherRunning = true;
	}

	public static void finish() {
		Logger.info("Finishing MemoryTaskWatcher");

		Logger.info("MemoryTaskWatcher finished with success");
	}

	public static boolean isMemoryTaskWatcherRunning() {
		return MemoryTaskWatcherRunning;
	}

	public static void finishMemoryTaskWatcher() {
		MemoryTaskWatcherRunning = false;
	}
}
