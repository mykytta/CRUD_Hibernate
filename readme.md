# Console CRUD app
**Implement a console CRUD application that has the following entities:**

- Developer
   - id
   - firstName 
   - lastName 
   - List<Skill> skills
   - Specialty specialty
- Skill
- Specialty
- Status (ACTIVE, DELETED)

The user in the console should be able to create, read, edit, and delete data.

To run locally, you will need a PostgreSQL server, as well as enter your login and password in Hibernate configuration file to connect.

Also, to migrate all changes to your DB just enter your DB name in Flyway and change the path to migration files in configuration file then enter the command `mvn compile flyway:migrate` in the terminal =).


