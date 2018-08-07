from db folder run creation.sql to create empty db


open project in IntelliJ IDEA and run Application.main()


open localhost:8080 in browser

Поскольку я уже не успел написать скрипт который заполняет базу данных начальными данными то вначале надо ввести их.
Чтобы эти данные сохранились после окончания программы надо потом в application.properties поменять spring.jpa.hibernate.ddl-auto=create на spring.jpa.hibernate.ddl-auto=none
