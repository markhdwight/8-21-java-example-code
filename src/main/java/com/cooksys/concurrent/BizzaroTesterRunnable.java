package com.cooksys.concurrent;

import com.cooksys.fun.DataContainer;
import com.cooksys.launch.ConcurrentLauncher;

public class BizzaroTesterRunnable implements Runnable {
	
	private String name;
	private int maxCount;
	private Thread waitForMe;
	private DataContainer dataContainer;

	public BizzaroTesterRunnable(String name, DataContainer container, int maxCount) {
		this.name = name;
		this.maxCount = maxCount;
		this.dataContainer = container;
	}
	
	public BizzaroTesterRunnable(String name, DataContainer container, int maxCount, Thread waitForMe) {
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
			
			System.out.println("Tester " + name + " count: " + dataContainer.getData());
		
		}

	}

}
