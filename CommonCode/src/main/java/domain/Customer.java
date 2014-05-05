package domain;

import java.io.Serializable;

public interface Customer extends Serializable{

	public abstract Address getHomeAddress();

	public abstract void setHomeAddress(Address homeAddress);

	public abstract Person getSalesRep();

	public abstract void setSalesRep(Person rep);

	public abstract Address getWorkAddress();

	public abstract void setWorkAddress(Address workAddress);

}