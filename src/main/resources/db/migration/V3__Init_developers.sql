CREATE TABLE developers (
id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL,
first_Name varchar(50) NOT NULL,
last_Name varchar(50) NOT NULL,
specialty int NOT NULL,
status varchar(50) NOT NULL,
CONSTRAINT spec FOREIGN KEY (specialty) REFERENCES specialties (specialty_id));