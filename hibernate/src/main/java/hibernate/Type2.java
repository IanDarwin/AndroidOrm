package hibernate;

import javax.persistence.*;

@Entity
public class Type2 {
	int id;
	Type1 parent;


	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne
	public Type1 getParent() {
		return parent;
	}
	
	public void setParent(Type1 parent) {
		this.parent = parent;
	}
	
	@Override
	public String toString() {
		return "Type2[" + id + "]";
	}
}
