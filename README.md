# 🛒 E-Commerce Web Application

This is a simple **E-Commerce Web Application** built using **Spring Boot**. It demonstrates the basic structure of an online store, including products and user management. This project showcases a clean backend architecture with REST APIs and uses H2 for the database.

## 🚀 Features

- Add and manage products
- Add and manage users
- View product list
- View user list
- RESTful API design
- In-memory H2 database integration

## 🛠️ Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Lombok


## 📡 API Endpoints

### 🔹 Product APIs

| Method | Endpoint            | Description         |
|--------|---------------------|---------------------|
| GET    | `/products`         | Get all products    |
| GET    | `/products/{id}`    | Get product by ID   |
| POST   | `/products`         | Create new product  |
| PUT    | `/products/{id}`    | Update a product    |
| DELETE | `/products/{id}`    | Delete a product    |

### 🔹 User APIs

| Method | Endpoint         | Description        |
|--------|------------------|--------------------|
| GET    | `/users`         | Get all users      |
| GET    | `/users/{id}`    | Get user by ID     |
| POST   | `/users`         | Create new user    |
| PUT    | `/users/{id}`    | Update a user      |
| DELETE | `/users/{id}`    | Delete a user      |

## ⚙️ Configuration

Example of `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:ecommercedb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
```
# 🧪 How to Run
> Clone the repository:
```
git clone https://github.com/Prakash123456780/Ecommerce-web-site.git
cd Ecommerce-web-site
```
> Build the project:
```
mvn clean install
```
> Run the Spring Boot application:
```
mvn spring-boot:run
```
The app will be available at http://localhost:8082.

