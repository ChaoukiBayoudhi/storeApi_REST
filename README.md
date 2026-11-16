# Store API REST

A REST API built with Spring Boot around 4 JPA entities, using PostgreSQL.

## Tech stack

- Java 19, built with Maven
- Spring Boot 2.7.4
- Spring Web (REST controllers)
- Spring Data JPA (Hibernate)
- Spring Data REST
- Spring Boot Actuator
- Lombok
- PostgreSQL driver
- Database: PostgreSQL (`store_db` in `application.properties`)

## Data model

| Entity | Fields |
|---|---|
| `Product` | id, name, price, fabricationDate, expirationDate, description, stock, image, productProvider |
| `Provider` | id, name, email, telephoneNumber, urlWebSite, products |
| `Customer` | id, firstName, lastName, type, customerAddress |
| `Address` | id, streetNumber, streetName, province, postalCode, customer |

## REST endpoints

Found in the controllers (`ProductController`):

| Method | Path |
|---|---|
| GET | `/all` |
| GET | `/product/{id}` |
| POST | `/add` |
| DELETE | `/delete/{id}` |
| PUT | `/update/{id}` |

## Project structure

- `tn.esb.storeApi`: StoreApiApplication
- `tn.esb.storeApi.Entities`: Address, Customer, Product, Provider
- `tn.esb.storeApi.Enumerations`: CustomerType
- `tn.esb.storeApi.Repositories`: CustomRepository, ProductRepository
- `tn.esb.storeApi.Services`: CustomerService, ProductService
- `tn.esb.storeApi.Web`: ProductController
- Tests: 1 test class

## How to run

Requirements: a JDK 19+ and Maven (or the included Maven wrapper).
Create the `store_db` database and set your own username and password in `src/main/resources/application.properties`.

```bash
./mvnw spring-boot:run
```

The API then listens on `http://localhost:8080`.

---

Author: [Chaouki Bayoudhi](https://github.com/ChaoukiBayoudhi)
