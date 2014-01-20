The Android ORM Project

Having worked with JPA and Hibernate for years, I was flabbergasted by the design of Android's "ContentValues" and "ContentProvider"
wherein everything is reduced to mush, or at least hash, before it can be processed. So we undertook this little study.

| Technology         | URL  | Type | Tech  | Results
| ------------------:|------|:-------:|------|
| AndroidRecord      | http://www.activeandroid.com/ | Active Record | |  None yet |
| Batoo JPA          | | JPA with Batoo Provider | HSQL database |
| greenDAO           | http://greendao-orm.com/ | ? | ? |
| Gwenn SQLite       | https://github.com/gwenn/sqlite-dialect/ | Hibernate dialect for SQLite |
| Hibernate          | http://hibernate.org | ORM | with Gwenn SQLite-dialect | None yet
| Jpa-hibernate      | n/a | ORM | JPA with Hibernate and Gwenn | None yet
| Sugar ORM          | http://satyan.github.io/sugar/ | Active Record | | None yet |
| Xerial JDBC-Driver | ihttp://code.google.com/p/xerial/ | JDBC-SQLite; see source/browse/src/main/java/org/sqlite/DB.java?repo=sqlite | n/a |
