package domain.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;
import javax.persistence.Version;

import domain.Address;
import domain.Person;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class PersonJPA implements Serializable, Person {

	private static final long serialVersionUID = 6204749922868486719L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	@Column
	protected String firstName;
	@Column
	protected String lastName;
	@Column
	protected Address address;
	@Version
	int version;
	
	public PersonJPA() {
		// empty
	}
	
	public PersonJPA(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + ": '" +getName() + "'" +
				(getAddress() != null ? getAddress() : "");
	}
	
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
	 */
	@Override
	@Transient /* synthetic: cannot be used in JPA queries, alas. */
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
	 * @see domain.Person#setAddress(domain.AddressJPA)
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
		final PersonJPA other = (PersonJPA) obj;
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
