package com.christian.osjava.resources;

import com.google.gson.Gson;
import com.christian.osjava.config.Constants;
import com.christian.osjava.utils.Logger;
import com.christian.osjava.models.MemoryPosition;

public class OSMemory {
	private static MemoryPosition[] MEMORY;
	private static long MEMORY_USED;

	public static void init() {
		Logger.info("Initing OSMemory");
		MEMORY = new MemoryPosition[Constants.SYSTEM_MEMORY_TOTAL];

		for (int i = 0; i < Constants.SYSTEM_MEMORY_TOTAL; i++) {
			MEMORY[i] = new MemoryPosition();
		}

		MEMORY_USED = 0;
		Logger.info("OSMemory initialized with success");
	}

	public static void finish() {
		Logger.info("Finishing OSMemory");
		MEMORY = null;
		System.gc();
		Logger.info("OSMemory finished with success");
	}

	public static boolean systemMemoryIsFull() {
		return MEMORY_USED == Constants.SYSTEM_MEMORY_TOTAL;
	}

	public static boolean systemMemoryWillHaveSpace(long qtdMemory) {
		return MEMORY_USED + qtdMemory <= Constants.SYSTEM_MEMORY_TOTAL;
	}

	/**
	 * System memory allocation. Do not call this function directly.
	 */
	public static boolean allocateMemory(String processId, long qtdMemory) {
		qtdMemory *= Constants.SYSTEM_MEMORY_SCALE;

		if (systemMemoryIsFull() || !systemMemoryWillHaveSpace(qtdMemory)) {
			return false;
		}

		int i, j, k;
		for (i = 0; i < Constants.SYSTEM_MEMORY_TOTAL; i++) {
			if (MEMORY[i].getProcessId() == null) {
				int available_bytes = 1;

				for (j = i + 1; available_bytes < qtdMemory && j < Constants.SYSTEM_MEMORY_TOTAL; j++) {
					if (MEMORY[j].getProcessId() == null) {
						available_bytes++;
					}
					else {
						break;
					}
				}

				if (available_bytes == qtdMemory) {
					for (j = i, k = 0; k < qtdMemory; j++, k++) {
						MEMORY[j].setProcessId(processId);
					}

					MEMORY_USED += qtdMemory;

					return true;
				}

				i = j;
			}
		}

		System.gc();

		return false;
	}

	public static void deallocateMemory(String processId) {
		for (int i = 0; i < Constants.SYSTEM_MEMORY_TOTAL; i++) {
			if (MEMORY[i].getProcessId().equals(processId)) {
				MEMORY[i].setProcessId(null);
				MEMORY_USED -= 1;
			}
		}

		System.gc();
	}

	public static void print_memory() {
		Gson gson = new Gson();

		Logger.info(gson.toJson(MEMORY));

		System.gc();
	}
}
