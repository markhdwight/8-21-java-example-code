package com.cooksys.launch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.cooksys.xml.pojo.Instructor;
import com.cooksys.xml.pojo.Location;

public class XmlTester {
	
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		
		Instructor unmarshalledInstructor = (Instructor) JAXBContext
		.newInstance(Instructor.class)
		.createUnmarshaller()
		.unmarshal(
				new FileInputStream(
						new File("instructor.xml")
						)
				);
	
		System.out.println(unmarshalledInstructor.getName());
		
	}

	private static Instructor createMichael() {
		Instructor michael = new Instructor();
		michael.setName("Michael");

		Location location = new Location();
		location.setState("TN");
		location.setValue("Memphis");
		
		location.getResidents().add(michael);
		
		michael.setLocation(location);
		
		Set<String> petSet = michael.getPets();
		petSet.add("Spot");
		petSet.add("Mittens");
		return michael;
	}
	
}
