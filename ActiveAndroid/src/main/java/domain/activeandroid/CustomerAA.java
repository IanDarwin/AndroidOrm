package domain.activeandroid;

import domain.Address;
import domain.Customer;
import domain.Person;

/**
 * A Customer is a Person with addresses and a sales rep.
 */
public class CustomerAA extends PersonAA implements Customer {

	private static final long serialVersionUID = 31434008848288245L;
	protected Address homeAddress = new AddressAA();
	protected Address workAddress = new AddressAA();
	
	// There can be many customers to one sales rep.
	protected Person salesRep;
	
	public CustomerAA() {
		// empty
	}
	
	public CustomerAA(String firstName, String lastName) {
		super(firstName, lastName);
	}

	/* (non-Javadoc)
	 * @see domain.Customer#getHomeAddress()
	 */
	@Override
	public Address getHomeAddress() {
		return homeAddress;
	}

	/* (non-Javadoc)
	 * @see domain.Customer#setHomeAddress(domain.Address)
	 */
	@Override
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	/* (non-Javadoc)
	 * @see domain.Customer#getSalesRep()
	 */
	@Override
	public Person getSalesRep() {
		return salesRep;
	}

	/* (non-Javadoc)
	 * @see domain.Customer#setSalesRep(domain.Person)
	 */
	@Override
	public void setSalesRep(Person rep) {
		this.salesRep = rep;
	}

	/* (non-Javadoc)
	 * @see domain.Customer#getWorkAddress()
	 */
	@Override
	public Address getWorkAddress() {
		return workAddress;
	}

	/* (non-Javadoc)
	 * @see domain.Customer#setWorkAddress(domain.Address)
	 */
	@Override
	public void setWorkAddress(Address workAddress) {
		this.workAddress = workAddress;
	}
}
