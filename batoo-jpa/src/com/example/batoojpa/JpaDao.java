package com.example.batoojpa;

import java.sql.Driver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.batoo.jpa.BJPASettings;
import org.batoo.jpa.JPASettings;
import org.batoo.jpa.core.BatooPersistenceProvider;
import org.batoo.jpa.jdbc.DDLMode;

import domain.Address;
import domain.Customer;
import domain.Person;

public class JpaDao {

	EntityManagerFactory entityMgrFactory;
	EntityManager entityManager;

	public void init() {

		// These two steps would be done for you
		// were you running in an EE App Server.
		// Or just the EntityManager injected if you were using JavaEE or Spring
		 Map<String, String> properties = new HashMap<String, String>();
         properties.put(JPASettings.JDBC_DRIVER, Driver.class.getName());
         properties.put(JPASettings.JDBC_URL, "jdbc:h2:/data/data/com.example.batoojpa/databases/hello.h2;FILE_LOCK=FS");
         properties.put(JPASettings.JDBC_USER, "sa");
         properties.put(JPASettings.JDBC_PASSWORD, "");
         properties.put(BJPASettings.DDL, DDLMode.DROP.name());
		entityMgrFactory =  
			new BatooPersistenceProvider().createEntityManagerFactory("batoo", properties , new String[]{
                Address.class.getName(),
                Customer.class.getName(),
                Person.class.getName(),
			});
		entityManager = entityMgrFactory.createEntityManager();
	}

	public void savePerson(Person np) {
		if (entityMgrFactory == null) {
			init();
		}
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		// Create an entity in the database.
		System.out.println("Trying to save " + np);
		entityManager.persist(np);
		transaction.commit();

		int id = np.getId();
		System.out.println("Created Person with Id " + id);
	}

	public Person getPersonById(long id) {
		if (entityMgrFactory == null) {
			init();
		}
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Person np = entityManager.find(Person.class, id);
		transaction.commit();
		return np;
	}

	public List<Person> getAllPersons() {
		if (entityMgrFactory == null) {
			init();
		}

		Query query = entityManager.createQuery("select p from Person p order by p.lastName");
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		@SuppressWarnings("unchecked")
		List<Person> list = query.getResultList();
		transaction.commit();
		return list;
	}
}
