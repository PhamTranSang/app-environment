# App Environment

## About this project

This project uses Spring Boot and demonstrates how to integrate external configurations into the application.  
It utilizes the `exec-maven-plugin` to create a custom Maven build process and uses Docker Compose for database setup.

## How to build this project

1. Set a system variable called `ROOT_FOLDER` with the value: `${HOME}/environment/bin/env/runtime/settings/`.

2. Run command `chmod +x start-dev-app.sh` to change permissions access.

3. Navigate to the `bin/env/postgresql` folder and execute the shell: `./start-dev-app.sh`.

## Technologies Used

- Java 21+
- Spring Boot (v3.4.5).
- Maven (`exec-maven-plugin`).
- Docker & Docker Compose.
- Shell scripting.
