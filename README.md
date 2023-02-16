# Spring-API-Skeleton

## Database Set Up
### Running Database  
  - Open Docker Desktop
  - Using the terminal, navigate into the `postgres` directory
  - Execute `docker-compose up -d --build`
  - This will run Postgres database server in a docker container

### Stopping Database
  - Using the terminal, navigate into the `postgres` directory
  - Execute `docker-compose down -v`

### Modifying Database
  - Change the database name by modifying `POSTGRES_DB` in `docker-compose.yml
  - Create your own schemas, tables and values by adding SQL queries to `init.sql`
