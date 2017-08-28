package com.cooksys.fun;

import com.cooksys.interfaces.Pet;

public class Owner {

	Pet pet;
	
	public void feedMyPet() {
		pet.setWeight(pet.getWeight() + 5);
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
}
