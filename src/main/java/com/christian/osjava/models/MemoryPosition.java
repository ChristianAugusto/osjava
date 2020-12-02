package com.christian.osjava.models;

public class MemoryPosition {
	private String processId;

	public MemoryPosition() {
		this.setProcessId(null);
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}
}
