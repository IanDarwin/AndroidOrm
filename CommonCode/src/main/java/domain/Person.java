package domain;

public interface Person {

	public abstract String getLastName();

	public abstract String getName();

	public abstract String getFirstName();

	public abstract void setFirstName(String firstName);

	public abstract void setLastName(String lastName);

	public abstract Address getAddress();

	public abstract void setAddress(Address address);

}