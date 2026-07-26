# Library Advanced API

Spring Boot REST API for library management.

## Features

- CRUD operations
- One-to-Many relationship (Book -> BorrowRecord)
- Many-to-Many relationship (Book <-> Category)
- JPQL queries
- Dynamic filtering with Specification API
- Transaction management using @Transactional
- Swagger/OpenAPI documentation

## Technologies

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Lombok
- Swagger UI

## Installation

Clone the repository

```bash
git clone https://github.com/fidashka07/library-advanced-api.git
```

Run the project

```bash
mvn spring-boot:run
```

## Swagger

```
http://localhost:8080/swagger-ui/index.html
```

## H2 Console

```
http://localhost:8080/h2-console
```

JDBC URL

```
jdbc:h2:mem:testdb
```

Username

```
sa
```

Password

```

```

## Author

Fidan Mammadli