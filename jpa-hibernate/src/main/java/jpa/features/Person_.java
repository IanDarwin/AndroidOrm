package jpa.features;

import javax.persistence.metamodel.SingularAttribute;

import domain.Person;

/** This single JPA MetaModel Class was hand-made to avoid having
 * to run the pre-processor to create them every time.
 * @author Ian Darwin
 *
 */
public class Person_ {

	public static SingularAttribute<Person, String> firstName;
	public static SingularAttribute<Person, String> lastName;
	public static SingularAttribute<Person, String> homePhone;
	public static SingularAttribute<Person, String> workPhone;

}
