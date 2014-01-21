The Android ORM Project

Having worked with JPA and Hibernate for years, I was flabbergasted by the design of Android's "ContentValues" and "ContentProvider"
wherein everything is reduced to mush, or at least hash, before it can be processed. So we undertook this little study.

| Technology         | URL  | Type | JPA Annot? | Tech  | Notes
| ------------------:|------|:-------:|-------|------|-----|
| AndroidRecord      | http://www.activeandroid.com/ | Active Record | ?| |  None yet |
| Batoo JPA          | | JPA with Batoo Provider | HSQL database | ?|
| greenDAO           | http://greendao-orm.com/ | ? | ? | ?|
| Gwenn SQLite       | https://github.com/gwenn/sqlite-dialect/ | Hibernate dialect for SQLite | N/A |
| Hibernate          | http://hibernate.org | ORM | Y | with Gwenn SQLite-dialect | None yet
| Jpa-hibernate      | n/a | ORM | Y | JPA with Hibernate and Gwenn | None yet
| ORMLite            | orlite.com | ORM | Y | Supports JDBC, Android | custom | 
| Sugar ORM          | http://satyan.github.io/sugar/ | ? | Active Record | | None yet |
| Xerial JDBC-Driver | ihttp://code.google.com/p/xerial/ | JDBC-SQLite| n/a | n/a |
