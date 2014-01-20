package hibernate;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Person;

/**
 "A transaction can span more than one session" -- Max, Hibernate team.
 * https://forum.hibernate.org/viewtopic.php?f=1&t=959085&sid=0edccdb475ed7779304bed650877c0e5&start=15
 * The code below DOES NOT WORK because it is not the Hibernate Transaction object that spans, but
 * the global UserTransaction object, which can be started by the @Transactional annotation.
 * Note that Distributed Transactions require a full Java EE Application Server, not a standalone program.
 */
public class MultiSessionTX {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Configuration cf = new Configuration();
		cf.configure();
		SessionFactory sessionFactory = cf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		// Persist an object
		Transaction tx = session.beginTransaction();
		Person rec = new Person();
		rec.setFirstName("Cookin'");
		rec.setLastName("Programmer");
		session.save(rec);
		
		// Query some entities		
		Session session2 = sessionFactory.openSession();
		Query q = session2.createQuery("From Person");
		List<Person> list = q.list();
		for (Person t : list) {
			System.out.println(t);
		}
		session2.close();
		
		// Shut it down
		tx.commit();
		sessionFactory.close();
	}
}
