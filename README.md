# Employee Management System 

## Project Overview
The Employee Management System is a backend-focused application designed to manage employee and department data efficiently. The project is built using **Spring Boot**, leveraging **REST APIs** for communication, **Spring Data JPA** and **Hibernate** for data persistence, and **MySQL Workbench** as the database. **Postman** was used for API testing.

## Features
1. **Employee and Department CRUD Operations**:
   - Create new employee and department records.
   - Retrieve employee and department details.
   - Update employee and department information.
   - Delete employee and department records.

2. **API Endpoints**:
   - Designed RESTful APIs for all operations.

3. **Database Interaction**:
   - Used MySQL database to store and manage employee and department data.
   - Configured with Spring Data JPA and Hibernate for ORM capabilities.

## Technologies Used
1. **Backend Framework**: Spring Boot
2. **Database**: MySQL (Workbench used for schema and data visualization)
3. **ORM**: Hibernate (via Spring Data JPA)
4. **Testing**: Postman for API testing
5. **Language**: Java

## Project Configuration
### Application Properties:
```properties
spring.application.name=EmployeeManagementSystem
spring.datasource.url=jdbc:mysql://localhost:3306/employeedb
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
server.port=8080
```

### Dependencies:
1. **Spring Boot Starter Web**: To create REST APIs.
2. **Spring Boot Starter Data JPA**: For database interactions.
3. **MySQL Connector**: To connect with MySQL database.
4. **Spring Boot DevTools**: For faster application development and hot-reloading

## Database Schema
### Employee Table:
| Column Name | Data Type       | Constraints        |
|-------------|-----------------|--------------------|
| id          | INT            | Primary Key, Auto-Increment |
| name        | VARCHAR(100)   | Not Null           |
| email       | VARCHAR(100)   | Unique, Not Null   |
| department_id | INT          | Foreign Key to Department Table |
| salary      | DECIMAL(10, 2) | Not Null           |

### Department Table:
| Column Name | Data Type       | Constraints        |
|-------------|-----------------|--------------------|
| id          | INT            | Primary Key, Auto-Increment |
| name        | VARCHAR(100)   | Not Null           |
| location    | VARCHAR(100)   | Not Null           |

## API Endpoints
### Employee Endpoints
1. **POST** /api/employees
   - Create a new employee record.

2. **GET** /api/employees
   - Retrieve all employee records.

3. **GET** /api/employees/{id}
   - Retrieve an employee record by ID.

4. **PUT** /api/employees/{id}
   - Update an employee record by ID.

5. **DELETE** /api/employees/{id}
   - Delete an employee record by ID.

### Department Endpoints
1. **POST** /api/departments
   - Create a new department record.

2. **GET** /api/departments
   - Retrieve all department records.

3. **GET** /api/departments/{id}
   - Retrieve a department record by ID.

4. **PUT** /api/departments/{id}
   - Update a department record by ID.

5. **DELETE** /api/departments/{id}
   - Delete a department record by ID.

## Testing
1. **Postman**:
   - Used to test the REST APIs for functionality and error handling.

2. **JUnit**:
   - (Optional) Unit tests for service and controller layers.

## Challenges Faced
1. Setting up database configurations.
2. Managing bi-directional relationships with Hibernate.
3. Handling exception scenarios in REST APIs.

## Future Enhancements
1. Implement role-based access control (RBAC).
2. Add frontend integration using Angular or React.
3. Include Swagger documentation for better API understanding.
4. Add more detailed logging and monitoring.

## Repository
- **GitHub**: [Employee Management System](https://github.com/divyapatil015)

---

### Contact Information
- **Name**: Divya Patil
- **Email**: divyapatil336@gmail.com
- **Phone**: +91 7879338580
- **LinkedIn**: [Divya Patil](https://linkedin.com/in/divya-patil0512)
- **GitHub**: [Divya's GitHub](https://github.com/divyapatil015)

