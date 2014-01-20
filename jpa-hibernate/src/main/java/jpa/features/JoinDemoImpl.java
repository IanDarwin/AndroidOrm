package jpa.features;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/** 
 * An example of a Join and also an example of a DTO creation
 * @author Ian Darwin
 */
@NamedQuery(name="joindemo",
	// Note that the DTO created with NEW here is not a JPA Entity!
	query="SELECT NEW JoinDemoImpl(p.name, SUM(s.amount))" + 
          "FROM Salesperson p LEFT JOIN p.sales s GROUP BY p.name")
public class JoinDemoImpl {
	String name;
	int amount;
	@PersistenceContext EntityManager em;
	
	@SuppressWarnings("unchecked")
	public void sendReport() {
		Query q = em.createNamedQuery("joindemo");
		final List<JoinDemoImpl> resultList = q.getResultList();
		for (JoinDemoImpl data : resultList) {
			System.out.printf("Name %s, Amount %s%n", data.name, data.amount);
		}
	}
	
	public JoinDemoImpl(String name, int amount) {
		super();
		this.name = name;
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
