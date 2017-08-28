package com.cooksys.fun;

import com.cooksys.interfaces.Pet;

public class Cat implements Pet {

	private int age;
	private double weight;
	
	@Override
	public void makeANoise() {
		System.out.println("Meow");
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
