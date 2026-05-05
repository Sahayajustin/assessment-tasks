# Task Management System (Core Java)

## Project Overview

The Task Management System is a console-based Java application designed to manage and process tasks efficiently. The application demonstrates core Java concepts such as Object-Oriented Programming, custom data structure implementation, and multithreading with synchronization.

A custom singly linked list is used to store tasks, and multiple worker threads are used to process them concurrently while ensuring that each task is handled exactly once.

---

## Features

### Task Management

* Add a new task
* Delete an existing task
* Search for a task
* Display all tasks
* Reverse the task list
* Get total task count

### Task Processing

* Process tasks using multiple worker threads
* Task lifecycle:

  * PENDING → IN_PROGRESS → COMPLETED
* Ensures no duplicate task processing

---

## Technologies Used

* Java (JDK 8 or above)
* Core Java
* Multithreading
* Custom Data Structures

---

## Project Structure

```
com.taskmanager
│
├── model
│   └── Task.java
│
├── linkedlist
│   └── TaskSinglyLinkedList.java
│
├── thread
│   └── WorkerThread.java
│
└── main
    └── TaskManagerApp.java
```

---

## How to Run

### Prerequisites

* Java JDK 8 or above
* IDE (Eclipse / IntelliJ / VS Code)

### Steps

1. Clone or download the project
2. Open the project in your IDE
3. Compile all files
4. Run:
   TaskManagerApp.java

---

## Menu Options

```
1. Add Task
2. Delete Task
3. Search Task
4. Display All Tasks
5. Reverse Task List
6. Start Task Processing
7. Exit
```

---

## Sample Output

```
Task List:
101 - Review Case File - HIGH - PENDING
102 - Generate Report - MEDIUM - PENDING

Starting Task Processing...

Worker-1 Processing Task ID: 101
Worker-2 Processing Task ID: 102

Worker-1 Completed Task ID: 101
Worker-2 Completed Task ID: 102

All tasks completed.
```

---

## Multithreading and Synchronization

* Multiple threads operate on a shared linked list
* Synchronization is used to avoid race conditions
* Ensures each task is processed only once

Example:

```
synchronized getNextPendingTask()
```

---

## Assumptions

* Task ID must be unique
* Priority values: HIGH, MEDIUM, LOW
* Tasks are processed only once

---

## Limitations

* No database (in-memory storage only)
* No persistence after program exit
* Console-based interface

---

## Future Enhancements

* Add database integration (MySQL/JDBC)
* Implement logging
* Add task scheduling
* Convert to Spring Boot application
* Build GUI using JavaFX or Web technologies

---

## Author

Sahaya Justin A

---

## Submission

This project is submitted as part of a Core Java programming assessment.
