package hibernate;

import javax.persistence.*;

@Entity
public class Type1 {
	int id;

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Type1[" + id + "]";
	}
}
