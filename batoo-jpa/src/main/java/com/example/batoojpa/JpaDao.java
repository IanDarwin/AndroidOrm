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

import domain.jpa.AddressJPA;
import domain.jpa.CustomerJPA;
import domain.jpa.PersonJPA;

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
                AddressJPA.class.getName(),
                CustomerJPA.class.getName(),
                PersonJPA.class.getName(),
			});
		entityManager = entityMgrFactory.createEntityManager();
	}

	public void savePerson(PersonJPA np) {
		if (entityMgrFactory == null) {
			init();
		}
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		// Create an entity in the database.
		System.out.println("Trying to save " + np);
		entityManager.persist(np);
		transaction.commit();

		long id = np.getId();
		System.out.println("Created Person with Id " + id);
	}

	public PersonJPA getPersonById(long id) {
		if (entityMgrFactory == null) {
			init();
		}
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		PersonJPA np = entityManager.find(PersonJPA.class, id);
		transaction.commit();
		return np;
	}

	public List<PersonJPA> getAllPersons() {
		if (entityMgrFactory == null) {
			init();
		}

		Query query = entityManager.createQuery("select p from Person p order by p.lastName");
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		@SuppressWarnings("unchecked")
		List<PersonJPA> list = query.getResultList();
		transaction.commit();
		return list;
	}
}
