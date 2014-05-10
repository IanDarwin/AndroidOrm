package domain;

import com.j256.ormlite.field.DatabaseField;

import domain.Address;
import domain.Person;

/**
 * ORMLite implementation of Person 
 */
public class PersonOL implements Person{

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

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

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAddress(Address address) {
		// TODO Auto-generated method stub
		
	}
}
