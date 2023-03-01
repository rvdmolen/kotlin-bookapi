# BookAPI Kotlin springboot application

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