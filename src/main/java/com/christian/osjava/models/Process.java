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
	private byte processingTime; // Seconds
	private long qtdMemory;
	private byte qtdPrinters;
	private byte qtdScanners;
	private byte qtdModems;
	private byte qtdCds;
	private byte processedTime;
	private String curentProcessQueueId;

	private static String processCreated = "0";

	public Process(char priority, int arrivalTime, byte processingTime, long qtdMemory, byte qtdPrinters,
			byte qtdScanners, byte qtdModems, byte qtdCds, String curentProcessQueueId) {
		this.setPriority(priority);
		this.setArrivalTime(arrivalTime);
		this.setProcessingTime(processingTime);
		this.setQtdMemory(qtdMemory);
		this.setQtdPrinters(qtdPrinters);
		this.setQtdScanners(qtdScanners);
		this.setQtdModems(qtdModems);
		this.setQtdCds(qtdCds);
		this.setCurentProcessQueueId(curentProcessQueueId);
		this.setProcessedTime((byte) 0);
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

	public byte getProcessingTime() {
		return processingTime;
	}

	public void setProcessingTime(byte processingTime) {
		this.processingTime = processingTime;
	}

	public long getQtdMemory() {
		return qtdMemory;
	}

	public void setQtdMemory(long qtdMemory) {
		this.qtdMemory = qtdMemory;
	}

	public byte getQtdPrinters() {
		return qtdPrinters;
	}

	public void setQtdPrinters(byte qtdPrinters) {
		this.qtdPrinters = qtdPrinters;
	}

	public byte getQtdScanners() {
		return qtdScanners;
	}

	public void setQtdScanners(byte qtdScanners) {
		this.qtdScanners = qtdScanners;
	}

	public byte getQtdModems() {
		return qtdModems;
	}

	public void setQtdModems(byte qtdModems) {
		this.qtdModems = qtdModems;
	}

	public byte getQtdCds() {
		return qtdCds;
	}

	public void setQtdCds(byte qtdCds) {
		this.qtdCds = qtdCds;
	}

	public byte getProcessedTime() {
		return processedTime;
	}

	public void setProcessedTime(byte processedTime) {
		this.processedTime = processedTime;
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
