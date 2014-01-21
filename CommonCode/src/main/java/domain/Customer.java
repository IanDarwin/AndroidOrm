package domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * A Customer is a Person with addresses and a sales rep.
 */
@Entity
public class Customer extends Person {

	private static final long serialVersionUID = 3143455008848288249L;
	protected Address homeAddress = new Address();
	protected Address workAddress = new Address();
	
	// There can be many customers to one sales rep.
	protected Person salesRep;
	
	public Customer() {
		// empty
	}
	
	public Customer(String firstName, String lastName) {
		super(firstName, lastName);
	}

	@OneToOne
	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	@ManyToOne
	public Person getSalesRep() {
		return salesRep;
	}

	public void setSalesRep(Person rep) {
		this.salesRep = rep;
	}

	@OneToOne
	public Address getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(Address workAddress) {
		this.workAddress = workAddress;
	}
}
