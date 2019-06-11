# Financial Scheduler

A simple app with API interface that creates scheduled transactions.

* Used SpringBoot 2.2.0.M3 for portability (it can run in any computer with java installed without a web server).
* Used H2 database as in-memory database because it has a large documentation and tutorials across the internet and does not require any database to be installed. (but any data persisted will be lost and the termination of the app)
* Used Swagger 2.6.1 as a API Documentation Builder since it's quite simple and straightforward
* Had to override spring-plugin-core to version 1.2.0.RELEASE since the version 2.2.0.M3 has bugs when working in conjunction with Swagger 2.6.1, it had no side effect on the way that the app works
* Used Java in version JDK 1.8 so I could use various of it's new features and I felt more confortable with it
* Used jackson-datatype-hibernate5 and added configuration class in config package to avoid exceptions when Hibernate queries return null objects

To generate the base project I used Spring Initializr at https://start.spring.io/

To build this app, you should have Maven and Java 8 installed in your system.

If you have those installed in your system, simple git clone this repository and run

mvn spring-boot:run

But if you want to make sure that everything is sounding, you can run all the test cases by runinng

mvn clean install

To access the API of the application open your browser and insert the following URL:
http://localhost:8080/swagger-ui.html

From there, you can see the basic information stored and add more.

To access the database manager, open your browser and insert the following URL:
/h2_console

Login: sa

leave password field in blanck

from there, you can make queries once the app is up and running.
