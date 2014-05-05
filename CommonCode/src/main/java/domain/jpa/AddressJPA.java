package domain.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import domain.Address;
import domain.Country;

@Entity
public class AddressJPA implements Serializable, Address {

	private static final long serialVersionUID = -3488970592612474703L;

	private int id;
	
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
	
	@Override
	public String toString() {
		return id + ": " + streetAddress + ", " + city;
	}
}
