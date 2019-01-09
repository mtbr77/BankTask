This program emulates some simple functionality of bank and contains info about clients, accounts, transactions. 

from db folder run creation.sql to create empty db

open localhost:8080 in browser

At first you need to enter all data, because DB is empty.
To make this data being saved it is needed in application.properties change spring.jpa.hibernate.ddl-auto=create to spring.jpa.hibernate.ddl-auto=none
