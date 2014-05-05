package domain.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import domain.Address;
import domain.Person;

public class PersonPojo implements Person {

	private static final long serialVersionUID = 6204749922868486715L;
	long id;
	protected String firstName;
	protected String lastName;
	protected Address address;
	int version;
	
	public PersonPojo() {
		// empty
	}
	
	public PersonPojo(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + ": '" +getName() + "'" +
				(getAddress() != null ? getAddress() : "");
	}
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	/* (non-Javadoc)
	 * @see domain.Person#getLastName()
	 */
	@Override
	public String getLastName() {
		return lastName;
	}
	
	/* (non-Javadoc)
	 * @see domain.Person#getName()
	 * In Java 8 this can become a "default" method in the Person interface
	 */
	@Override
	public String getName() {
		StringBuilder sb = new StringBuilder();
		if (firstName != null)
			sb.append(firstName).append(' ');
		if (lastName != null)
			sb.append(lastName);
		return sb.toString();
	}
	
	/* (non-Javadoc)
	 * @see domain.Person#getFirstName()
	 */
	@Override
	public String getFirstName() {
		return firstName;
	}

	/* (non-Javadoc)
	 * @see domain.Person#setFirstName(java.lang.String)
	 */
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/* (non-Javadoc)
	 * @see domain.Person#setLastName(java.lang.String)
	 */
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/* (non-Javadoc)
	 * @see domain.Person#getAddress()
	 */
	@Override
	public Address getAddress() {
		return address;
	}

	/* (non-Javadoc)
	 * @see domain.Person#setAddress(domain.Address)
	 */
	@Override
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
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
		final PersonPojo other = (PersonPojo) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
}
