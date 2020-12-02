package com.christian.osjava.resources;

import com.christian.osjava.models.CPU;

public class Dispatcher implements Runnable {
	CPU cpu;
	int cpuIndex;
	
	public Dispatcher(CPU cpu, int cpuIndex) {
		this.cpu = cpu;
		this.cpuIndex = cpuIndex;
	}

	public void run() {
		System.out.println("CPU: " + this.cpuIndex);
	}
}
