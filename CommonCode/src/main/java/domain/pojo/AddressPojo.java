package domain.pojo;

import java.io.Serializable;

import domain.Address;
import domain.Country;

public class AddressPojo implements Serializable, Address {

	private static final long serialVersionUID = -3488970592612474705L;
	
	private String streetAddress;
	private String city;
	private Country country = Country.CANADA;

	/* (non-Javadoc)
	 * @see domain.Address#getCity()
	 */
	@Override
	public String getCity() {
		return city;
	}
	/* (non-Javadoc)
	 * @see domain.Address#setCity(java.lang.String)
	 */
	@Override
	public void setCity(String city) {
		this.city = city;
	}
	/* (non-Javadoc)
	 * @see domain.Address#getCountry()
	 */
	@Override
	public Country getCountry() {
		return country;
	}
	/* (non-Javadoc)
	 * @see domain.Address#setCountry(domain.Country)
	 */
	@Override
	public void setCountry(Country country) {
		this.country = country;
	}
	/* (non-Javadoc)
	 * @see domain.Address#getStreetAddress()
	 */
	@Override
	public String getStreetAddress() {
		return streetAddress;
	}
	/* (non-Javadoc)
	 * @see domain.Address#setStreetAddress(java.lang.String)
	 */
	@Override
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
}
