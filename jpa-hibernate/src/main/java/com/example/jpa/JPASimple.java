package com.example.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import domain.Person;

public class JPASimple {

	EntityManagerFactory entityMgrFactory;
	EntityManager entityManager;

	public void init() {

		// These two steps would be done for you
		// were you running in an EE App Server.
		// Or just the EntityManager injected if you were using JavaEE or Spring
		entityMgrFactory = Persistence.createEntityManagerFactory("androidorm");
		entityManager = entityMgrFactory.createEntityManager();
	}

	public void persist(Person np) {

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		// Create an entity in the database.
		System.out.println("Trying to save " + np);
		entityManager.persist(np);
		transaction.commit();

		long id = np.getId();
		System.out.println("Created Person with Id " + id);
	}

	public Person getPersonById(long id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Person np = entityManager.find(Person.class, id);
		transaction.commit();
		return np;
	}

	public List<Person> getAllPersons() {

		Query query = entityManager.createQuery("select p from Person p order by p.lastName");
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		@SuppressWarnings("unchecked")
		List<Person> list = query.getResultList();
		transaction.commit();
		return list;
	}

}
