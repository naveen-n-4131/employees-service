# 🧑‍💼 Employee Service

A simple Spring Boot CRUD application using PostgreSQL. This project is containerized with Docker and Docker Compose for easy setup.

---

## ✅ Features

- RESTful CRUD APIs for managing employees
- PostgreSQL database integration
- Dockerized setup for backend and database
- Schema and data auto-initialization

---

## 🔧 Prerequisites

Before you begin, ensure the following are installed on your machine:

| Tool           | Version       |
|----------------|---------------|
| Java           | 17 or later   |
| Maven          | 3.8+          |
| Docker         | Latest        |
| Docker Compose | v2+           |
| IntelliJ IDEA  | (Recommended) |

---

## 🛠️ Running the Application (Option 1: Docker Compose – Easiest)
### Steps:

1. **Clone the repository**
   ```bash
   git clone https://github.com/naveen-n-4131/employees-service.git
   cd employees-service

2. **Build the application**
   ```bash
    mvn clean package -DskipTests
   
3. **Run Service and PostgreSQL with Docker**

    ```bash
    docker compose up --build
4. **Access the app**

- Service is now running at: http://localhost:8080
- PostgreSQL is running at: localhost:5432 (User: postgres, Password: postgres, DB: employeedb)

## 🛠️ Running in IntelliJ IDEA (Option 2: Local Java + PostgreSQL via Docker)
### Steps:

1. **Start PostgreSQL using Docker**
   (This creates and runs a local PostgreSQL container.)

    ```bash
   docker run --name my-postgres \
    -e POSTGRES_DB=employeedb \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=postgres \
    -p 5432:5432 -d postgres:16
   
2. **Open IntelliJ**
   - Update application.properties for postgres with below properties
      ```
     spring.datasource.url=jdbc:postgresql://localhost:5432/employeedb
     spring.datasource.username=postgres
     spring.datasource.password=postgres
   - Start the application

## 🧪 Test the APIs
You can use Postman or curl to test endpoints like:

    GET    http://localhost:8080/api/employees
    POST   http://localhost:8080/api/employees
    PUT    http://localhost:8080/api/employees/{id}
    DELETE http://localhost:8080/api/employees/{id}

## ⚙️ Environment Variables
If using Docker, these are configured via docker-compose.yml:

    SPRING_DATASOURCE_URL
    SPRING_DATASOURCE_USERNAME
    SPRING_DATASOURCE_PASSWORD

## 🧼 Clean Up
- To stop and remove containers, volumes:
    ```bash
    docker-compose down --volumes --remove-orphans
- if you ran the DB manually
    ```bash
  docker stop my-postgres && docker rm my-postgres
