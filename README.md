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