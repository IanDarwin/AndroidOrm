package domain.jpa;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import domain.Address;
import domain.Customer;
import domain.Person;

/**
 * A Customer is a Person with addresses and a sales rep.
 */
@Entity
public class CustomerJPA extends PersonJPA implements Customer {

	private static final long serialVersionUID = 3143455008848288249L;
	protected Address homeAddress = new AddressJPA();
	protected Address workAddress = new AddressJPA();
	
	// There can be many customers to one sales rep.
	protected Person salesRep;
	
	public CustomerJPA() {
		// empty
	}
	
	public CustomerJPA(String firstName, String lastName) {
		super(firstName, lastName);
	}

	/* (non-Javadoc)
	 * @see domain.Customer#getHomeAddress()
	 */
	@Override
	@OneToOne
	public Address getHomeAddress() {
		return homeAddress;
	}

	/* (non-Javadoc)
	 * @see domain.Customer#setHomeAddress(domain.AddressJPA)
	 */
	@Override
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	/* (non-Javadoc)
	 * @see domain.Customer#getSalesRep()
	 */
	@Override
	@ManyToOne
	public Person getSalesRep() {
		return salesRep;
	}

	/* (non-Javadoc)
	 * @see domain.Customer#setSalesRep(domain.PersonJPA)
	 */
	@Override
	public void setSalesRep(Person rep) {
		this.salesRep = rep;
	}

	/* (non-Javadoc)
	 * @see domain.Customer#getWorkAddress()
	 */
	@Override
	@OneToOne
	public Address getWorkAddress() {
		return workAddress;
	}

	/* (non-Javadoc)
	 * @see domain.Customer#setWorkAddress(domain.AddressJPA)
	 */
	@Override
	public void setWorkAddress(Address workAddress) {
		this.workAddress = workAddress;
	}
}
