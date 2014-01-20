package jpa.features;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import jpa.JPAUtil;
import domain.Person;

public class CriteriaQueryExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Assume that the user has filled in a form field (Swing or Web, matters not)
		// and given us the following values:
		String firstName = "Ian";
		String lastName = null;
		//String workPhone = "+44 7910 123456";
		//String homePhone = null;
		// and we want to use each of these fields, where non-null, in the query.
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		CriteriaBuilder qb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Person> cq = qb.createQuery(Person.class);
		Root<Person> root = cq.from(Person.class);
		Predicate personPredicate = null;
		ParameterExpression<String> firstNameParameter = null;
		
		if (firstName != null) {
			firstNameParameter = qb.parameter(String.class);
			personPredicate = qb.equal(root.get(Person_.firstName), firstNameParameter);
		}
		if (personPredicate != null) {
			cq.where(personPredicate);
		}
		// And similar for lastName...
		
		TypedQuery<Person> q = entityManager.createQuery(cq);
		
		// Can't do these until the Query is finally created...
		if (firstName != null) {
			q.setParameter(firstNameParameter, firstName);
		}
		// And similar for lastName

		System.out.println("Running the generated Query: " + q);
		for (Person p : q.getResultList()) {
			System.out.println("Found person " + p);
		}
	}

}
