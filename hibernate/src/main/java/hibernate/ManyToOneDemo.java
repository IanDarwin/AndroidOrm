package hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class ManyToOneDemo {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Configuration cf = new AnnotationConfiguration();
		cf.configure();
		SessionFactory sf = cf.buildSessionFactory();
		Session session = sf.openSession();
		
		// Persist a many-to-one relationship
		// using a foreign-key relationship
		// (only one end of each, but it's the
		// syntax that counts...).
		Transaction tx = session.beginTransaction();
		Type1 one = new Type1();
		Type2 two = new Type2();
		two.setParent(one);
		session.save(two);
		tx.commit();
		
		// Query some entities		
		Query q = session.createQuery("From Type1");
		List<Type1> list = q.list();
		for (Type1 t : list) {
			System.out.println(t);
		}
		
		// Shut it down
		session.close();
		sf.close();
	}
}
