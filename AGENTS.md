# AI Agent Guidelines for Basic-SpringBoot

## Architecture Overview
This is a Spring Boot REST API application with layered architecture: Controllers handle HTTP requests, Services contain business logic, Repositories (MyBatis mappers) manage database operations. Uses PostgreSQL with MyBatis for ORM instead of JPA. Key components:
- **Controllers**: REST endpoints in `controller/` package, wrap responses in `ApiResponse<T>` (see `EmployeeController.java`)
- **Services**: Business logic in `service/imp/` implementations, annotated with `@Transactional` (e.g., `EmployeeServiceImp.java`)
- **Repositories**: MyBatis interfaces with SQL annotations in `repository/` (e.g., `EmployeeRepo.java`)
- **Models**: Lombok-annotated POJOs in `model/` (e.g., `Employee.java`)

## Key Patterns
- **Database Mapping**: Use underscore column names (e.g., `employee_id`) mapped to camelCase fields via `mybatis.configuration.map-underscore-to-camel-case=true` in `application.properties`
- **CRUD Operations**: Controllers follow GET `/all`, POST `/add`, GET `/{id}`, PUT `/{id}`, DELETE `/{id}` pattern (see `ProductController.java`)
- **Response Wrapping**: All endpoints return `ApiResponse<T>` with success flag, message, and data (example in `EmployeeController.getAllEmployees()`)
- **Service Injection**: Services manually configured in `AppConfig.java` for ProductService; others use `@Service` annotation
- **Transaction Management**: All service methods are transactional; updates fetch entity first, set ID, then update (see `EmployeeServiceImp.updateEmployeeById()`)
- **Add Operations**: Employee add fetches after insert to return with generated ID; Product add assumes ID is set by MyBatis `@Options`

## Developer Workflows
- **Build & Run**: Use `mvn spring-boot:run` for development; requires PostgreSQL running on localhost:5432 with database `basic-spring-boot`
- **Database Setup**: Connect with user `postgres` password `12345`; tables `employees` and `products` expected (schema not included)
- **API Testing**: Swagger UI available at `/swagger-ui/index.html`; endpoints under `/api/v1/` are open (no auth required despite SecurityConfig)
- **Testing**: Run `mvn test`; only context load test exists currently
- **Dependencies**: Install via `mvn clean install`; uses Lombok (configure IDE annotation processing)

## Conventions
- **Package Structure**: Implementations in `service/imp/` subdirectory
- **Naming**: Repositories end with `Repo`, Services with `Service`, implementations with `Imp`
- **Security**: In-memory users `admin`/`12345` (ADMIN) and `user`/`12345` (USER); CORS allows `localhost:3000`
- **Error Handling**: Controllers return 404 with `ApiResponse` for not found; no global exception handling
- **Imports**: Use constructor injection for dependencies (e.g., in `EmployeeServiceImp`)

## Integration Points
- **Database**: PostgreSQL via JDBC; MyBatis handles mapping
- **Security**: Spring Security configured but API endpoints permit all; CORS enabled for frontend
- **API Docs**: SpringDoc OpenAPI generates Swagger from annotations (no custom annotations used yet)</content>
<parameter name="filePath">D:\FullStack\Spring\Basic-SpringBoot\AGENTS.md
