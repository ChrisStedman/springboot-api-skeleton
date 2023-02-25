# Spring-API-Skeleton

## 📜 Overview

A skeleton of a Spring-boot REST API skeleton which can be used to teach the basics of API development, or a starting point of a  new project. 

Examples which increase in complexity/functionality have been included to illustrate how different tools can be used. 

### Includes:
  
| Functionality                     | Dependency                   |
|-----------------------------------|------------------------------|
| Generate code from specifications | OpenApi Generator            |
| Postgres connectivity             | Docker</br>Postgres</br>JPA  |
| Generate boilerplate code         | Lombok                       |

## 🔨 Project Setup
Depending on your local setup, some of these values may already be configfured correct.

### Link Gradle project
   1. Open app directory
   2. Right-click `build.gradle`
   3. Click `Link Gradle Project`

### Set Project SDK
   1. File > Project Structure > Project
   2. Set `SDK` to `corretto-17`
      1. May need to select `add sdk` and `download`
   3. Apply 

### Remove `app` from modules
   1. File > Project Structure > Modules
   2. If `app` is shown as a module on the same level as `spring-boot-api-skeleton` (not nested inside it), remove it by clicking the `-` symbol
   3. Apply

### Set Gradle JVM
   1. IntelliJ IDEA > Preferences
   2. Build, Execution and  Deployment > Build Tools > Gradle
      1. Or search `Gradle`
   3. At bottom, set `Gradle JVM` to `Prokect SDK`
      1. This should be `corretto-17`


## 🏃 Running Project
### Without Postgres DB
1. When the project is configured correctly, a Spring run configuration should be automatically added.
   1. If not, then double-check the `Project Setup` section again
2. Select the configuration and click play.
3. The application will start, and you will be able to hit the API using Postman

### With Postgres DB
1. When the project is configured correctly, a Spring run configuration should be automatically added.
   1. If not, then double-check the `Project Setup` section again
2. Before running the application, we need to start the Postgres Docker container, as the application will try to connect to this on start up. To do this, go to the `Postgres Database` section and follow the steps under `Starting container`
3. Select the configuration and click play.
4. The application will start, and you will be able to hit the API using Postman

## 🎯 Usage
### Hitting an endpoint
Once the application is running, the defined endpoints can be called. The `main` branch contains an example endpoint `GET /example`, as well as a health endpoint `GET /health`. 
The definition of the `/example` endpoint can be found in the specification file `api-specifications.yaml`. See the [OpenApi Generator](#openapi-generator) guide for more information.  

Open Postman, import the example postman collection, and call the `/example` endpoint. You should receive a 200 status with the body seen below. For more information of installing, configuring and using postman, see the [Postman](#postman) guide.

```
{
    "Status": "Success"
}
```

### Creating an endpoint
Open the specification file `api-specification.yaml`. OpenApi generator uses this file to generate the required API and model classes for the API.  

Add a new `path`, a nested `http method` and at least one response to define a basic endpoint. Ideally, also add a `tag` and `operation-id` to improve the generated classes.
Use the pre-defined `/example` endpoint as a template, and see the [OpenApi Generator](#openapi-generator) guide for more information.  
  
Click the `build` button in IntelliJ, or run `gradle build` from the `Gradle` tab.

Create a new `delegateImpl` which extends the generated `apiDelegate` interface. Now override the method defined in the `apiDelegate` interface to define the handling of the endpoint.
Use the pre-defined class `ExampleApiDelegateImpl`  as a template.

Create a new postman request to hit the newly created endpoint. See the [Postman](#postman) guide for more information.

Run the application and hit the new endpoint using Postman.

## 🗄️ Postgres Database
### Starting container
- Open Docker Desktop
- Using the terminal, navigate into the `postgres` directory
- Execute `docker-compose up -d --build`
- This will run Postgres database server in a docker container

### Stopping container
- Using the terminal, navigate into the `postgres` directory
- Execute `docker-compose down -v`

### Modifying Database
- Change the database name by modifying `POSTGRES_DB` in `docker-compose.yml
- Create your own schemas, tables and values by adding SQL queries to `init.sql`

## 👌 Guides
#### [OpenApi Generator](docs/OpenApi-Generator.md)
#### [Postman](docs/Postman.md)  
