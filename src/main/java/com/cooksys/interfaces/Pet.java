package com.cooksys.interfaces;

public interface Pet {

	public int getAge();
	
	public void setAge(int i);
	
	public double getWeight();
	
	public void setWeight(double d);
	
	public default void makeANoise() {
		System.out.println("Hello human");
	}
	
}
