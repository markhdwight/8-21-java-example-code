package com.cooksys.concurrent;

import com.cooksys.fun.DataContainer;

public class TesterRunnable implements Runnable {
	
	private Object lock = new Object();

	private String name;
	private int maxCount;
	private Thread waitForMe;
	private DataContainer dataContainer;

	public TesterRunnable(String name, DataContainer container, int maxCount) {
		this.name = name;
		this.maxCount = maxCount;
		this.dataContainer = container;
	}
	
	public TesterRunnable(String name, DataContainer container, int maxCount, Thread waitForMe) {
		this.name = name;
		this.maxCount = maxCount;
		this.waitForMe = waitForMe;
		this.dataContainer = container;
	}

	@Override
	public void run() {
		
		if(waitForMe != null && waitForMe.isAlive()) {
			try {
				waitForMe.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int i = 0; i < maxCount; i++) {
			
			
			synchronized (dataContainer) {
				dataContainer.setData(dataContainer.getData() + 1);
			}
			
			
			System.out.println("Tester " + name + " count: " + dataContainer.getData());
		
		}

	}

}
