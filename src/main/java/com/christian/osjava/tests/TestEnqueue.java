package com.christian.osjava.tests;

import com.christian.osjava.models.Process;
import com.christian.osjava.resources.OSProcessQueues;

public class TestEnqueue {
	public static void init() {
		
		Process p1 = new Process('0', 1, 2, 64, 1, 0, 0, 2, null);
		OSProcessQueues.addProcessOnFE(p1);
	}
}
