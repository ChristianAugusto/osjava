package com.christian.osjava.models;

import com.christian.osjava.utils.IdIncrement;
import com.google.gson.Gson;

public class Process {
	private String id;
	/**
	 * Real Time 0 - User 1,2,3
	 */
	private char priority;
	private int arrivalTime;
	private int processingTime; // Seconds
	private long qtdMemory;
	private int qtdPrinters;
	private int qtdScanners;
	private int qtdModems;
	private int qtdCds;
	private int processedTime;
	private String curentProcessQueueId;

	private static String processCreated = "0";

	public Process(char priority, int arrivalTime, int processingTime, long qtdMemory, int qtdPrinters,
			int qtdScanners, int qtdModems, int qtdCds, String curentProcessQueueId) {
		this.setPriority(priority);
		this.setArrivalTime(arrivalTime);
		this.setProcessingTime(processingTime);
		this.setQtdMemory(qtdMemory);
		this.setQtdPrinters(qtdPrinters);
		this.setQtdScanners(qtdScanners);
		this.setQtdModems(qtdModems);
		this.setQtdCds(qtdCds);
		this.setCurentProcessQueueId(curentProcessQueueId);
		this.processedTime = (int) 0;
		this.id = IdIncrement.increment(processCreated);
	}

	public String getId() {
		return id;
	}

	public char getPriority() {
		return priority;
	}

	public void setPriority(char priority) {
		this.priority = priority;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getProcessingTime() {
		return processingTime;
	}

	public void setProcessingTime(int processingTime) {
		this.processingTime = processingTime;
	}

	public long getQtdMemory() {
		return qtdMemory;
	}

	public void setQtdMemory(long qtdMemory) {
		this.qtdMemory = qtdMemory;
	}

	public int getQtdPrinters() {
		return qtdPrinters;
	}

	public void setQtdPrinters(int qtdPrinters) {
		this.qtdPrinters = qtdPrinters;
	}

	public int getQtdScanners() {
		return qtdScanners;
	}

	public void setQtdScanners(int qtdScanners) {
		this.qtdScanners = qtdScanners;
	}

	public int getQtdModems() {
		return qtdModems;
	}

	public void setQtdModems(int qtdModems) {
		this.qtdModems = qtdModems;
	}

	public int getQtdCds() {
		return qtdCds;
	}

	public void setQtdCds(int qtdCds) {
		this.qtdCds = qtdCds;
	}

	public int getProcessedTime() {
		return processedTime;
	}

	public void setProcessedTime(int processedTime) {
		this.processedTime += processedTime;
	}

	public String getCurentProcessQueueId() {
		return curentProcessQueueId;
	}

	public void setCurentProcessQueueId(String curentProcessQueueId) {
		this.curentProcessQueueId = curentProcessQueueId;
	}

	public String toString() {
		Gson gson = new Gson();

		return gson.toJson(this);
	}
}
