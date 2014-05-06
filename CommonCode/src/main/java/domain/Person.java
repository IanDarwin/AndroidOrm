package domain;

import java.io.Serializable;

public interface Person extends Serializable {

	public String getLastName();

	/** getName must return getFirstName(), space, getLastName() */
	public String getName();

	public String getFirstName();

	public void setFirstName(String firstName);

	public void setLastName(String lastName);

	public Address getAddress();

	public void setAddress(Address address);

	/** toString is required; it must present the class.simpleName, getName(), and getAddress() */
	public String toString();
}
