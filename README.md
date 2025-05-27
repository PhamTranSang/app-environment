# App Environment

## About this project

This project uses Spring Boot and demonstrates how to integrate external configurations into the application.  
It utilizes the `exec-maven-plugin` to create a custom Maven build process and uses Docker Compose for database setup.

## How to build this project

1. Set a system variable called `ROOT_FOLDER` with the value:

2. Navigate to the `bin/env/postgresql` folder and run:

3. Finally, execute the shell script with the `ROOT_FOLDER` argument:

## Technologies Used

- Java 21+.
- Spring Boot.
- Maven (`exec-maven-plugin`).
- Docker & Docker Compose.
- Shell scripting.
