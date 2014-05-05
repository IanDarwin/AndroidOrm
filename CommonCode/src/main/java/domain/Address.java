package domain;

import java.io.Serializable;

public interface Address extends Serializable{

	public abstract String getCity();

	public abstract void setCity(String city);

	public abstract Country getCountry();

	public abstract void setCountry(Country country);

	public abstract String getStreetAddress();

	public abstract void setStreetAddress(String streetAddress);

}