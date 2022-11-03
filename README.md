# MCB-Backend Project

This is a Java / Maven / Spring Boot application.

## How to Run 

* Clone this repository 
* Make sure you are using JDK 17 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the application using below command:
```
        mvn spring-boot:run -Drun.arguments="spring.profiles.active=test"
```

Once the application runs you should see something like this

```
2017-08-29 17:31:23.091  INFO 19387 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2017-08-29 17:31:23.097  INFO 19387 --- [           main] com.khoubyari.example.Application        : Started Application in 22.285 seconds (JVM running for 23.032)
```

## About the Service

The service is just a simple institute management application. It uses an in-memory database (H2) to store the data, Hiberante mappings to prrovide the relationship between  students,groups ,teachers, subjects.
It uses Spring security with JWT Authorization.
It has functionality to limit the no of unsucessfull login attempts for 24 hrs, if invalid login>3.
It has SchedulerSearvice to reset the invalid logins after 24 hrs.
All APIs are "self-documented" by Swagger2 using annotations 

Here are some endpoints you can call:

### To view Swagger 2 API docs

Run the server and browse to http://localhost:8080/swagger-ui/

### API to register user and generate Jwt token 

```
POST http://localhost:8080/api/login

Accept: application/json
Content-Type: application/json

{
  "password": "password",
  "username": "prashansa"
}

RESPONSE: HTTP 200 
BODY - JWT Token
```
### Set API Key to Authorize requests
```
JWT  (apiKey)
Name: Authorization
value  - Bearer generated-jwt-token
```
### Register a new User 
```
POST http://localhost:8080/api/register
Accept: application/json
Content-Type: application/json

{
  "businessTitle": "consultant",
  "email": "dummyxyz.gmail.com",
  "password": "password",
  "phone": "1234567890",
  "username": "john"
}

RESPONSE: HTTP 201 (Created)

```

### get total Marks of student using student id

```
http://localhost:8080/api/students/1/marks

Response: HTTP 200
Content: total marks of the student for all subjects
```

###  List subject with marks for given student id 

```
http://localhost:8080/api/students/1/subjects/marks
Accept: application/json
Content-Type: application/json



RESPONSE: HTTP 200
```
### Get total no of student under given teacher Id

```
http://localhost:8080/api/students/teachers/1
RESPONSE: HTTP 200

```

