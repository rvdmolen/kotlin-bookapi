# BookAPI Kotlin springboot application

In this application, I am making a simple RestFul API with Spring Boot and Kotlin with the basic CRUD functionality. Here I am using M2 in memory as a database. You can clone this project as Open in IntelliJ IDEA start the application, will have the backend up and running at port 8080 in no time. Kotlin makes it so easy to spring up a backend. Spring applications created using Kotlin, when compared to those created using Java, are concise and easier to maintain. Kotlin is a first-class language for programming Spring applications.

## Setup Project

1. Switch to **develop** branch:
   ```bash
   git checkout develop
   ```

2. Go to the **app** folder:
   ```bash
   cd app
   ```

3. Install **Maven** dependencies:
   ```bash
   mvn clean install
   ```

   Or (to generate the model use openapi)

   ```bash
   mvn clean install -Pgenerate-api
   ```


## Start Project

1. To start the API locally:

```bash
mvn -f web spring-boot:run
```


## Running Unit Tests

We can run our unit tests by using the Maven Surefire plugin. When we want to run
our unit tests, we have to run the following command at command prompt:

    mvn clean test

## Running Integration Tests

We can run our integration tests by using the Maven Failsafe plugin. When we want to
run our integration tests, we have to run the following command at command prompt:

    mvn clean verify -P integration-test

## Running All Tests

When we want to run both unit and integration tests, we have to run the following
command at command prompt:

    mvn clean verify -P all-tests
    