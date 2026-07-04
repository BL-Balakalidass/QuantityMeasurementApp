# 📏 Quantity Measurement App

<div align="center">

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data-JPA-blue)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-brown)
![H2](https://img.shields.io/badge/Database-H2-blue)
![MySQL](https://img.shields.io/badge/Database-MySQL-orange)
![JUnit5](https://img.shields.io/badge/Testing-JUnit5-success)
![Mockito](https://img.shields.io/badge/Mockito-Test-yellowgreen)

**A Spring Boot REST API for performing Quantity Measurement, Unit Conversion, Comparison, and Arithmetic Operations using clean architecture and object-oriented design principles.**

</div>

---

# 📖 Overview

The **Quantity Measurement App** is a RESTful web application developed using **Spring Boot**. It enables users to compare quantities, convert measurement units, and perform arithmetic operations across multiple measurement categories.

Supported measurement categories include:

* 📏 Length
* ⚖ Weight
* 🌡 Temperature
* 🧪 Volume

The application stores operation history in a relational database and exposes REST APIs for performing calculations and retrieving previous operations.

---

# 🚀 Features

* ✅ Quantity Comparison
* ✅ Quantity Addition
* ✅ Unit Conversion
* ✅ Operation History
* ✅ Operation Count
* ✅ H2 Database Integration
* ✅ MySQL Support
* ✅ RESTful APIs
* ✅ Spring Data JPA
* ✅ Hibernate ORM
* ✅ Global Exception Handling
* ✅ DTO-Based Design
* ✅ Layered Architecture
* ✅ Swagger/OpenAPI Documentation
* ✅ Unit Testing
* ✅ Mockito Testing
* ✅ MockMvc Controller Testing

---

# 🏗 Project Architecture

```
                   Client

                      │
                      ▼

          QuantityMeasurementController

                      │
                      ▼

         QuantityMeasurementService

                      │
                      ▼

      QuantityMeasurementRepository

                      │
                      ▼

            H2 / MySQL Database
```


# 📐 Supported Measurement Types

## Length

* Feet
* Inch
* Yard
* Centimeter
* Meter
* Kilometer

---

## Weight

* Gram
* Kilogram
* Ton

---

## Volume

* Milliliter
* Liter
* Gallon

---

## Temperature

* Celsius
* Fahrenheit
* Kelvin

---

# 📡 REST APIs

---

## Compare Quantities


---



# 💾 Database

## H2 Database

Console

```
http://localhost:8080/h2-console
```

Configuration

```
JDBC URL:
jdbc:h2:mem:testdb

Username:
sa

Password:
```

---

## MySQL

Example

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/quantity_measurement

spring.datasource.username=root

spring.datasource.password=password

spring.jpa.hibernate.ddl-auto=update
```

---

# 📖 Swagger Documentation

Swagger UI

```
http://localhost:8080/swagger-ui/index.html
```

OpenAPI

```
http://localhost:8080/v3/api-docs
```

---

# 🧪 Testing

The project includes

* Unit Testing
* Service Testing
* Controller Testing
* Integration Testing
* Mockito
* MockMvc

Example Test Classes

```
QuantityMeasurementControllerTest

QuantityMeasurementServiceTest
```

---

# 🎯 Concepts Covered

## Core Java

* Classes
* Objects
* Encapsulation
* Polymorphism
* Inheritance
* Abstraction
* Enum
* Exception Handling

---

## Spring Boot

* REST APIs
* Spring MVC
* Dependency Injection
* Bean Validation
* Controller Advice

---

## Spring Data JPA

* Repository Pattern
* Entity Mapping
* CRUD Operations

---

## Hibernate

* ORM
* Persistence
* Auto Table Creation

---

## REST API Concepts

* GET
* POST
* JSON Request
* JSON Response
* HTTP Status Codes

---

## Testing

* JUnit 5
* Mockito
* MockMvc
* Assertions
* Integration Testing

---

## Design Patterns

* Layered Architecture
* DTO Pattern
* Repository Pattern
* Strategy Pattern
* Factory Pattern
* Dependency Injection

---

# ▶️ Running the Project

## Clone Repository

```bash
git clone https://github.com/BL-Balakalidass/QuantityMeasurementApp.git
```

---

## Open Project

Open the project using IntelliJ IDEA, Eclipse, or Spring Tool Suite (STS).

---

## Build Project

```bash
mvn clean install
```

---

## Run Application

```bash
mvn spring-boot:run
```

Or run

```
QuantityMeasurementApplication.java
```

directly from your IDE.

---

# 📈 Learning Outcomes

This project demonstrates

* Spring Boot REST API Development
* Layered Architecture
* Spring Data JPA
* Hibernate ORM
* DTO Design
* Unit Conversion Logic
* Object-Oriented Programming
* Exception Handling
* Unit Testing
* Mockito
* MockMvc
* Clean Code Practices

---

# 🚀 Future Enhancements

* JWT Authentication
* Spring Security
* Docker Integration
* Redis Cache
* PostgreSQL Support
* Kafka Event Streaming
* GraphQL APIs
* Kubernetes Deployment
* Interactive Unit Conversion Dashboard
* Microservices Architecture

---

# 🤝 Contributing

Contributions are welcome!

### Fork Repository

```bash
git fork
```

### Create a Branch

```bash
git checkout -b feature/new-feature
```

### Commit Changes

```bash
git commit -m "Added new feature"
```

### Push Changes

```bash
git push origin feature/new-feature
```

### Create a Pull Request

Submit your Pull Request for review.

---

# 👨‍💻 Author

## **Balakalidass**

**Java Full Stack Developer**

### Skills

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* REST APIs
* Microservices
* Docker

### GitHub

```
https://github.com/BL-Balakalidass
```
---

# 📄 License

Developed by **Balakalidass** for learning, practice, and educational purposes.
