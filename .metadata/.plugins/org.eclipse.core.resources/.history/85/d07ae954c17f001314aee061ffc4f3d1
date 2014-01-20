package hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import domain.Address;
import domain.Person;
import domain.sales.Customer;

public class HibernateSimple {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		System.out.println("HibernateSimple.main()");

		Configuration cf = new AnnotationConfiguration();
		cf.configure();
		SessionFactory sf = cf.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		// Create an entity in the database.
		Person np = new Person("Tom", "Boots");
		System.out.println(np);
		session.save(np);
		tx.commit();

		int id = np.getId();
		System.out.println("Created Person with Id " + id);

		tx = session.beginTransaction();

		Customer person = new Customer("Happy", "User");
		person.getHomeAddress().setStreetAddress("123 Main St");
		Address home = person.getHomeAddress();
		if (home != null && (home.getStreetAddress() != null || home.getCity() != null)) {
			session.save(home);
		} else {
			person.setHomeAddress(null);
		}
		Address work = person.getWorkAddress();
		if (work != null && (work.getStreetAddress() != null || work.getCity() != null)) {
			session.save(work);
		} else {
			person.setWorkAddress(null);
		}
		session.save(person);
		tx.commit();
		System.out.println("Created Customer " + person + ", HomeAddress = " + person.getHomeAddress());

		Query query = session.createQuery("select p from Person p order by p.lastName");

		List<Person> list = query.list();
		System.out.println("There are " + list.size() + " persons:");
		for (Person p : list) {
			System.out.println(
					p.getFirstName() + ' ' + p.getLastName());
		}
		System.out.println();

		session.close();
	}

}
