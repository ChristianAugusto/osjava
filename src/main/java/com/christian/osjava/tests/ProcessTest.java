package com.christian.osjava.tests;

import java.util.LinkedList;
import java.util.Queue;

import com.christian.osjava.models.Process;
import com.christian.osjava.resources.OSMemory;
import com.google.gson.Gson;

public class ProcessTest {
	public static void init() {
		Process p1 = new Process('0', (byte) 1, (byte) 2, (byte) 64, (byte) 1, (byte) 0, (byte) 0, (byte) 2, null);
		Queue<Process> testQueue = new LinkedList<Process>();

		Gson gson = new Gson();

		System.out.println(gson.toJson(p1));

		testQueue.add(p1);

		boolean memoryAllocated = OSMemory.allocateMemory(p1.getId(), 5);

		if (memoryAllocated) {
			System.out.println("memory allocated");
		}
		else {
			System.out.println("memory not allocated");
		}

		System.out.println(gson.toJson(testQueue));

		Process aux = testQueue.remove();

		System.out.println(aux);

		System.out.println(gson.toJson(testQueue));

		testQueue.clear();
	}
}
