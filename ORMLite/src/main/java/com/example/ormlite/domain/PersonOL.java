package com.example.ormlite;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

/**
 * ORMLite implementation of Person 
 */
public class PersonOL implements Person{

	/** Primary key - generated */
	@DatabaseField(generatedId = true)
	int id;
	@DatabaseField(index = true)
	String firstName;
	@DatabaseField
	String lastName;
	@DatabaseField
	String address;	// XXX relationships?
	@DatabaseField
	Country country;

	PersonOL() {
		// needed by ormlite
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Person#").append(id).append(", ")
			.append(firstName).append(" ").append(lastName)
			.append(", ").append(address);
		return sb.toString();
	}
}
