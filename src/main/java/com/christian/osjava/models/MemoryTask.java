package com.christian.osjava.models;

import com.google.gson.Gson;

public class MemoryTask {
	/**
	 * Allocate 1 - Deallocate 2 - Deallocate to Allocate 3
	 */
	private short actionType;
	private String processId;
	private int qtdMemory;
	/**
	 * Initial 0 - Success 1 - Not Success 2
	 */
	private short success;

	public MemoryTask(short actionType, String processId, int qtdMemory) {
		this.setActionType(actionType);
		this.setProcessId(processId);
		this.setQtdMemory(qtdMemory);
		this.success = 0;
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

	public int getQtdMemory() {
		return qtdMemory;
	}

	public void setQtdMemory(int qtdMemory) {
		this.qtdMemory = qtdMemory;
	}

	public short getSuccess() {
		return success;
	}

	public void setSuccess() {
		this.success = 1;
	}

	public void setNotSuccess() {
		this.success = 2;
	}

	public String toString() {
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}
