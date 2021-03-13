package com.christian.osjava.models;

import com.google.gson.Gson;

public class MemoryTask {
	/**
	 * Allocate 1 - Deallocate 2 - Deallocate to Allocate 3
	 */
	private short actionType;
	private String processId;
	private long qtdMemory;
	/**
	 * Initial 0 - Success 1 - Not Success 2
	 */
	private short status;

	public MemoryTask(short actionType, String processId, long qtdMemory) {
		this.setActionType(actionType);
		this.setProcessId(processId);
		this.setQtdMemory(qtdMemory);
		this.status = 0;
	}

	public short getActionType() {
		return actionType;
	}

	public void setActionType(short actionType) {
		this.actionType = actionType;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public long getQtdMemory() {
		return qtdMemory;
	}

	public void setQtdMemory(long qtdMemory) {
		this.qtdMemory = qtdMemory;
	}

	public short getStatus() {
		return status;
	}

	public void setStatusSuccess() {
		this.status = 1;
	}

	public void setStatusNotSuccess() {
		this.status = 2;
	}

	public String toString() {
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}
