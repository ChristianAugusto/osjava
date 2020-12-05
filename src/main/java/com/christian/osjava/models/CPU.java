package com.christian.osjava.models;

public class CPU {
	private String processId;
	private boolean dispatcherRunning;

	public CPU(boolean dispatcherRunning) {
		this.setProcessId(null);
		this.dispatcherRunning = dispatcherRunning;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public boolean isDispatcherRunning() {
		return dispatcherRunning;
	}

	public void finishDispatcher() {
		this.dispatcherRunning = false;
	}
}
