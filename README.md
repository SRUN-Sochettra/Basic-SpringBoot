# Basic-SpringBoot

## Tech Stack
* **Language:** Java 17
* **Framework:** Spring Boot (v4.0.5)
* **Persistence:** MyBatis (v4.0.1)
* **Database:** PostgreSQL
* **Security:** Spring Security (In-Memory Authentication)
* **Documentation:** Springdoc OpenAPI / Swagger UI (v2.8.0)
* **Utilities:** Lombok

## Features
* Complete CRUD operations for `Employee` and `Product` entities.
* Standardized JSON response wrapper (`ApiResponse`).
* Global CORS configuration permitting cross-origin requests from `http://localhost:3000`.
* In-memory user authentication configuration via `InMemoryUserDetailsManager`.
* Auto-generated API documentation.

## Prerequisites
* Java Development Kit (JDK) 17
* PostgreSQL server instance
* Maven

## Configuration
Database connection properties are defined in `src/main/resources/application.properties`. Default configuration requires a local PostgreSQL instance:
* **URL:** `jdbc:postgresql://localhost:5432/basic-spring-boot`
* **Username:** `postgres`
* **Password:** `12345`

Ensure the target database `basic-spring-boot` is created before execution. The application maps database underscores to camelCase automatically.

## Installation & Execution
1. Clone the repository.
2. Navigate to the root directory.
3. Build the project using the Maven wrapper:
   ```bash
   ./mvnw clean install
   ```
4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

## API Endpoints
The application exposes the following primary endpoints. Spring Security is configured to permit all requests to `/api/v1/products/**` and `/api/v1/employees/**` without authentication.

### Employees (`/api/v1/employees`)
* `GET /all` : Retrieve all employees
* `GET /{id}` : Retrieve an employee by ID
* `POST /add` : Create a new employee
* `PUT /{id}` : Update an existing employee
* `DELETE /{id}` : Delete an employee

### Products (`/api/v1/products`)
* `GET /all` : Retrieve all products
* `GET /{id}` : Retrieve a product by ID
* `POST /add` : Create a new product
* `PUT /{id}` : Update an existing product
* `DELETE /{id}` : Delete a product

## API Documentation
When the application is running, the interactive Swagger UI and API docs are accessible at:
* `/swagger-ui/index.html`
* `/v3/api-docs`

## Author
[SRUN-Sochettra](https://github.com/SRUN-Sochettra)
