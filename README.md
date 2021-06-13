Tools Used:
The below are the list of tools and framework used in the project!

SpringBoot
Maven
Java 
Eclipse

How to run Application:
Get Private & Public keys from Marvel API website.

Below command to start the application

mvn spring-boot:run -Dspring-boot.run.arguments="--private.key={{VALUE}},--public.key={{VALUE}}"

API used:
/characters api retrieves all character IDs.
/characters/{characterid} api retrieves character details by Character id

Below link access the application:

http://localhost:8080/swagger-ui.html#/
