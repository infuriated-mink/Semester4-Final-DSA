# Binary Search Tree Backend

This is the backend of the Binary Search Tree application, built using Spring Boot. It handles the creation, storage, and retrieval of binary search trees.

## Table of Contents

1. [Introduction](#introduction)
2. [Setup and Installation](#setup-and-installation)
3. [Project Structure](#project-structure)
4. [API Endpoints](#api-endpoints)
5. [Database Configuration](#database-configuration)
6. [Running the Application](#running-the-application)
7. [Testing](#testing)

## Introduction

The backend of this application manages binary search trees, exposing RESTful APIs to interact with the frontend. It allows users to create, view, and store binary search trees.

## Setup and Installation

To set up and run the backend:

1. Ensure you have Java 17 and Maven installed.
2. Clone the repository.
3. Navigate to the backend directory.
4. Run `mvn clean install` to install dependencies.
5. Configure the database (see [Database Configuration](#database-configuration)).

## Project Structure

The backend project is structured as follows:
src/
├── main/
│ ├── java/
│ │ └── com.example.bst/
│ │ ├── controller/
│ │ │ └── TreeController.java
│ │ ├── entity/
│ │ │ └── TreeEntity.java
│ │ ├── service/
│ │ │ └── TreeService.java
│ │ └── model/
│ │ ├── BinaryNode.java
│ │ └── BinaryNodeConverter.java
│ └── resources/
│ ├── application.properties
│ └── data.sql
└── test/
└── java/
└── com.example.bst/
└── TreeServiceTest.java


## API Endpoints

The following endpoints are available:

- `POST /trees` - Creates a new binary search tree from a list of numbers.
- `GET /trees/{id}` - Retrieves a specific binary search tree by its ID.
- `GET /trees` - Retrieves a list of all saved binary search trees.

## Database Configuration

The backend uses an H2 in-memory database by default. You can configure the database settings in `src/main/resources/application.properties`.

Example configuration:

```properties
spring.datasource.url=jdbc:h2:mem:bstdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

## Running the Application
To run the application:
Navigate to the backend directory.

## Use the following command:
```
mvn spring-boot:run
```
The application will start on http://localhost:8080.

## Testing
Unit tests are provided to ensure the application works as expected. To run the tests:
```
mvn test
```


