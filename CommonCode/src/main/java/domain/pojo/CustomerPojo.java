package domain.pojo;

import domain.Address;
import domain.Customer;
import domain.Person;
import domain.jpa.PersonJPA;

/**
 * A Customer is a Person with addresses and a sales rep.
 */
public class CustomerPojo extends PersonPojo implements Customer {

	private static final long serialVersionUID = 3143455008848288245L;
	protected Address homeAddress = new AddressPojo();
	protected Address workAddress = new AddressPojo();
	
	// There can be many customers to one sales rep.
	protected Person salesRep;
	
	public CustomerPojo() {
		// empty
	}
	
	public CustomerPojo(String firstName, String lastName) {
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
