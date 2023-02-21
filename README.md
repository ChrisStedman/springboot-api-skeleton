# Spring-API-Skeleton

## Overview

A generic Spring-boot skeleton which provides all the necessary dependencies and configurations to create a simple Spring based API.

Project can be run from a main branch very basic example, you can switch to an example branch for a more detailed example, or you can create your own API using any branch as a base.

### Includes:
  
| Functionality                               | Dependency                             |
| -------------                               | -------------                          |
| Generate code from specifications           | OpenApi Generator                      |
| Postgres connectivity                       | Docker</br>Postgres</br>JPA</br>       |
| Generate boilerplate code                   | Lombok                                 |


## Project Setup
Depending on your local setup, some of these values may already be configfured correct.

1. Link Gradle project
   1. Open app
   2. Right-click `build.gradle`
   3. Click `Link Gradle Project`
2. Set Project SDK
   1. File > Project Structure > Project
   2. Set `SDK` to `corretto-17`
      1. May need to select `add sdk` and `download`
   3. Apply
3. Remove `app` from modules
   1. File > Project Structure > Modules
   2. If `app` is shown as a module on the same level as `spring-boot-api-skeleton` (not nested inside it), remove it by clicking the `-` symbol
   3. Apply
4. Set Gradle JVM
   1. IntelliJ IDEA > Preferences
   2. Build, Execution and  Deployment > Build Tools > Gradle
      1. Or search `Gradle`
   3. At bottom, set `Gradle JVM` to `Prokect SDK`
      1. This should be `corretto-17`


## Running Project
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

## Postgres Database
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

## Guides
[OpenApi Generator](./docs/OpenApi-Generator.md)