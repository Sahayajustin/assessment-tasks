# Employee Task Management System

## Project Overview

The Employee Task Management System is a Spring MVC web application developed as part of a programming assessment. The application allows users to manage employees and assign tasks efficiently.

It follows a clean layered architecture using Controller, Service, DAO, and Model layers. The system demonstrates core concepts such as Spring MVC flow, Object-Oriented Programming, CRUD operations, and database interaction using JPA (Hibernate).

---

## Objective

* Implement Spring MVC architecture
* Perform CRUD operations for Employee and Task modules
* Demonstrate layered architecture design
* Integrate database using JPA and MySQL
* Build a simple JSP-based user interface

---

## Features

### Employee Management

* Add Employee
* View Employee List
* Edit Employee
* Delete Employee

### Task Management

* Create Task
* Assign Task to Employee
* View Task List
* Edit Task
* Delete Task
* Update Task Status (PENDING, IN_PROGRESS, COMPLETED)

---

## Technologies Used

* Java (JDK 8+)
* Spring MVC
* JPA (Hibernate)
* JSP (Java Server Pages)
* Maven
* MySQL Database
* Apache Tomcat
* Lombok

---

## Project Structure

```
src/main/java
└── com.assessment.taskmanagement
     ├── config
     │    ├── AppConfig.java
     │    └── WebConfig.java
     │
     ├── controller
     │    ├── EmployeeController.java
     │    └── TaskController.java
     │
     ├── dao
     │    ├── EmployeeDAO.java
     │    └── TaskDAO.java
     │
     ├── model
     │    ├── Employee.java
     │    └── Task.java
     │
     ├── service
     │    ├── EmployeeService.java
     │    └── TaskService.java
     
src/main/resources
└── META-INF
     └── persistence.xml

webapp
└── WEB-INF
     └── views
          ├── Employee.jsp
          ├── Task.jsp
     └── web.xml

root
└── index.jsp
```

---

## Architecture

The application follows a layered architecture:

* Controller Layer
  Handles HTTP requests and navigation

* Service Layer
  Contains business logic

* DAO Layer
  Handles database operations using EntityManager

* Model Layer
  Represents database entities

* View Layer (JSP)
  Displays UI to the user

---

## Entity Relationship

* One Employee is associated with one Task
* One Task is assigned to one Employee
* Implemented using One-to-One mapping

---

## Functional Flow

### Employee Flow

1. Open Employee page
2. Add new employee
3. Save employee
4. View employee list
5. Edit or delete employee

### Task Flow

1. Open Task page
2. Add new task
3. Assign employee from dropdown
4. Save task
5. View task list
6. Edit or delete task

---

## URLs

| Module   | Endpoint    |
| -------- | ----------- |
| Home     | `/`         |
| Employee | `/employee` |
| Task     | `/task`     |

---

## Database Configuration (Important)

Before running the application, update the database configuration based on your local system.

Open the file:

src/main/resources/META-INF/persistence.xml

Modify the following properties:

```
<property name="javax.persistence.jdbc.url"
          value="jdbc:mysql://localhost:3306/YourDatabaseName?createDatabaseIfNotExist=true"/>

<property name="javax.persistence.jdbc.user"
          value="your-username"/>

<property name="javax.persistence.jdbc.password"
          value="your-password"/>
```

### Notes for Users

* Replace `YourDatabaseName` with your database name (e.g., TaskApp)
* Replace `your-username` with your MySQL username (e.g., root)
* Replace `your-password` with your MySQL password
* Ensure MySQL server is running before starting the application
* The database will be created automatically if it does not exist

### Example Configuration

```
URL: jdbc:mysql://localhost:3306/TaskApp?createDatabaseIfNotExist=true
Username: root
Password: root123
```

---

## How to Run

### Prerequisites

* Java JDK 8+
* Apache Tomcat Server
* MySQL Database
* Maven

### Steps

1. Clone or download the project
2. Import into IDE (Eclipse / IntelliJ)
3. Configure database in persistence.xml
4. Build project using Maven
5. Deploy on Tomcat server
6. Run the application

---

## Key Concepts Demonstrated

* Spring MVC request flow
* Dependency Injection
* JPA (EntityManager)
* Hibernate ORM
* MVC Architecture
* CRUD Operations
* JSP View Rendering
* Layered Design Pattern

---

## Validation

Basic validations implemented:

* Employee Name: Required
* Email: Required
* Department: Required
* Task Title: Required
* Priority: Required
* Status: Required
* Assigned Employee: Required

---

## Limitations

* No authentication or authorization
* No REST API (MVC only)
* Manual transaction management
* One-to-One relationship limits scalability
* Basic UI design

---

## Future Enhancements

* Convert to Spring Boot
* Add REST APIs
* Implement validation using Hibernate Validator
* Add authentication using Spring Security
* Change to One-to-Many relationship
* Add pagination and filtering
* Improve UI with modern frontend frameworks

---

## Challenges Faced

* Managing EntityManager manually
* Handling bidirectional mapping between Task and Employee
* Synchronizing UI with backend data
* Ensuring correct task assignment

---

## Author

Sahaya Justin A

---

## Submission Details

This project is submitted as part of a Spring MVC programming assessment. It demonstrates understanding of application flow, layered architecture, CRUD operations, and database integration.

---

## Presentation Points (For Viva)

* Explain Spring MVC flow
* Explain Controller → Service → DAO flow
* Show Employee CRUD operations
* Show Task CRUD operations
* Explain Employee-Task mapping
* Explain database configuration
* Discuss improvements and scalability
