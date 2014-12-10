package domain.stormgen;

import java.io.Serializable;

import com.turbomanage.storm.api.Entity;

import domain.Address;
import domain.Country;
import domain.pojo.PersonPojo;

@Entity
public class AddressSG extends PersonPojo implements Serializable, Address {

	private static final long serialVersionUID = -870189021612474705L;

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
