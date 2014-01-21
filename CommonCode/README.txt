This project contains the RainForest domain model implemented using Annotations,
and has both Hibernate and JPA versions of many of the demo programs, including
the famous (working) ManyToManyDemo.

The domain model is annotated using JPA annotations, and is used by both
sets of demos without change.

The JPA versions can run using either Hibernate or EclipseLink as their
JPA provider; see the persistence.xml file for the properties to change.