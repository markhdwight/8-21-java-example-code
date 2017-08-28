package com.cooksys.fun;

import com.cooksys.interfaces.Pet;

public class Dog implements Pet{

	private int age;
	private double weight;
	private Dog friend;
	
	public void bark() {
		System.out.println("woof!");
	}
	
	public void setFriendAge(int newFriendAge) {
		this.friend.setAge(newFriendAge);
	}
	
	public Dog getFriend() {
		return friend;
	}

	public void setFriend(Dog friend) {
		
		this.friend = friend;
	}

	public Dog() {
		// TODO Auto-generated constructor stub
	}
	
	public Dog(int age, double weight) {
		super();
		this.age = age;
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((friend == null) ? 0 : friend.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (age != other.age)
			return false;
		if (friend == null) {
			if (other.friend != null)
				return false;
		} else if (!friend.equals(other.friend))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	
}
