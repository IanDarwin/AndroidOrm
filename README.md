The Android ORM Project

Having worked with JPA and Hibernate for years, I was flabbergasted by the design of Android's "ContentValues" and "ContentProvider" wherein everything is reduced to mush, or at least hash, before it can be processed. So we undertook this little study.

The main project is in CommonCode, which provides JPA-annotated entities and a
"Signup" name-and-address form. When you submit the form, it passes the Person
object on to another Activity, which is expected to do the technology-specific
"save the Person to sqlite, and display the results" action. The Main activity's
class name must be listed in your AndroidManifest, and the taret "save and display"
must be listed in a Java Properties file in src/. See TemplateReceiver for example.

**Note that none of this works yet**; as present it's a POC to show if it is possible
to set things up this way.

| Technology         | URL  | Type | JPA Annot? | Tech  | Notes
| ------------------:|------|:-------:|-------|------|-----|
| AndroidRecord      | http://www.activeandroid.com/ | Active Record | ?| |   |
| Batoo JPA          | | JPA with Batoo Provider | Y | HSQL database | ?|
| greenDAO           | http://greendao-orm.com/ | ? | ? | ?|
| Gwenn SQLite       | https://github.com/gwenn/sqlite-dialect/ | Hibernate dialect for SQLite | N/A |
| Hibernate          | http://hibernate.org | ORM | Y | with Gwenn SQLite-dialect | 
| Jpa-hibernate      | n/a | ORM | Y | JPA with Hibernate and Gwenn | 
| ORMLite            | orlite.com | ORM | Y | Supports JDBC, Android | custom | 
| Sugar ORM          | http://satyan.github.io/sugar/ | Active Record | ? | 
| Xerial JDBC-Driver | http://code.google.com/p/xerial/ | JDBC-SQLite| n/a | n/a |
