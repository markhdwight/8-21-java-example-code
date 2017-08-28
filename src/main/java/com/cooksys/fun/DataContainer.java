package com.cooksys.fun;

public class DataContainer {

	int data;
	
	public DataContainer(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	public synchronized void incrementData(int inc) {
		this.data += inc;
	}
	
	

}
