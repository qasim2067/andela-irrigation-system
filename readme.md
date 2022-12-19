# Automated Irrigation System 

## Technologies Used
### Java 17
### SpringBoot
### Maven
### Mariadb
### Flyway - for db creation
### Swagger 
 
## How to Run The project
#### 1. Clone the repo from github
#### 2. Import as existing maven project in eclipse/intellij or any other ide.
#### 3. Update the application.properties file with the dbuser and password as per your system setup.
#### 4. Create a new database irrigationsystem in your database
#### 5. Run the Project as springboot application OR run IrrigationSystemApplication class with no arguments.

## How to Access Api
#### There are 2 ways to access the apis for irrigation system
#### 1. Postman
##### For this import the postman collection included in repos with file name AIS.postman_collection.json
##### You can access the apis present in the collection to perform various operations
#### 2. Swagger
##### The apis can also be tested using the swagger configured within the applicaiton code as a dependency.
##### Go To swagger ui  default path of applciation after running the applicaiton 
##### You can use the apis from swagger ui to interact with the system and perform various operations.
