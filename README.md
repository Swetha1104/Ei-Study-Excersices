# 🧩 Java Exercises: Design Patterns & Virtual Classroom Manager

This repository contains **two Java exercises** that showcase essential **Object-Oriented Programming (OOP)** concepts and **Software Design Patterns**.  
Both exercises emphasize **modularity**, **scalability**, and **clean architecture** with real-world Java implementations.

---

## 🚀 EXERCISE 1 — Design Patterns

This project demonstrates multiple **Design Patterns** implemented in Java, organized into three categories: **Creational**, **Structural**, and **Behavioural**.

---

### 🧠 Behavioural Design Patterns

#### 🪜 Chain of Responsibility Pattern  
**File:** `ExamReviewSystem.java`  
- Models an exam review process where a request moves through multiple handlers (Student → Instructor → Admin) until one processes it.  
- Promotes decoupled and flexible request handling.

#### 🎯 Strategy Pattern  
**File:** `Main.java`  
- Demonstrates dynamic selection of algorithms (e.g., discount calculation strategies in an e-commerce system).  
- Encourages flexibility and code reuse.

---

### 🏗️ Creational Design Patterns

#### 🏭 Factory Design Pattern  
**File:** `NotificationSystem.java`  
- Creates various notification types (Email, SMS, Push) without exposing object creation logic.  
- Promotes scalability and abstraction.

#### 🔒 Singleton Design Pattern — *Healthcare System*  
Implements a **singleton database connection** used by multiple modules like Billing, Pharmacy, and Registration.

##### 📂 Folder Structure
```
Healthcare/
├── db/
│   └── DatabaseConnection.java        # Singleton database connection
├── modules/
│   ├── BillingModule.java             # Handles billing operations
│   ├── PharmacyModule.java            # Manages pharmacy functionality
│   └── RegistrationModule.java        # Handles patient registration
└── MainDemo.java                      # Entry point for Healthcare system
```

🧠 **Concept:**  
Ensures that only **one instance** of the database connection exists application-wide for resource efficiency and data consistency.

---

### 🧱 Structural Design Patterns

#### 🎧 Adapter Design Pattern  
**File:** `MediaPlayerAdapterDemo.java`  
- Adapts incompatible interfaces to allow different media player types to interoperate seamlessly.

#### ☕ Decorator Design Pattern  
**File:** `CoffeeShopDecoratorDemo.java`  
- Dynamically adds features (like milk, sugar, whipped cream) to a coffee object at runtime.  
- Demonstrates the **Open–Closed Principle**.

---

## 🎓 EXERCISE 2 — Virtual Classroom Manager

A **console-based educational management system** that simulates classroom operations.  
It demonstrates **data persistence**, **logging**, and **modular design** in Java.

---

### ✨ Features

- Add, manage, and view students and classrooms  
- Record and retrieve attendance data  
- Persist data using Java serialization (`.ser` files)  
- Maintain detailed logs of actions via `app.log`  

---

### 📂 Folder Structure
```
Virtual Classroom Manager/
├── data/
│   └── classrooms_data.ser            # Serialized data file
├── logs/
│   └── app.log                        # Log file for operations
└── src/
    └── edtech/
        ├── manager/
        │   └── VirtualClassroomManager.java   # Core business logic
        ├── models/
        │   ├── AttendanceRecord.java          # Entity for attendance tracking
        │   ├── Classroom.java                 # Entity representing a classroom
        │   └── Student.java                   # Entity representing a student
        ├── persistence/
        │   └── PersistenceManager.java        # Handles data saving/loading
        └── Main.java                          # Entry point of the application
```

---

### ▶️ How to Run

1. **Clone the Repository**
   ```bash
   git clone https://github.com/Swetha1104/Ei-Study-Excersices
   cd Ei-Study-Excersices
   ```

2. **Navigate to the Virtual Classroom Manager source directory**
   ```bash
   cd "Virtual Classroom Manager/src/edtech"
   ```

3. **Compile the Java files**
   ```bash
   javac */*.java */*/*.java
   ```

4. **Run the program**
   ```bash
   java Main
   ```

---

## 🧠 Concepts Demonstrated

- **Object-Oriented Programming (OOP)**  
  Encapsulation, Abstraction, Inheritance, and Polymorphism  

- **Design Patterns**  
  - Creational: Factory, Singleton  
  - Structural: Adapter, Decorator  
  - Behavioural: Chain of Responsibility, Strategy  

- **Java Concepts**  
  - File I/O and Serialization  
  - Logging (`Logger` API)  
  - Exception Handling  
  - Data Structures (Lists, Maps)

---

## 🛠️ Tools & Technologies

- **Language:** Java 17+  
- **IDE:** IntelliJ IDEA / Eclipse / VS Code  
- **Build Tool:** javac (manual compilation)  
- **Logging:** Java `Logger` class  
- **Persistence:** Object serialization (`.ser` files)

---

## 👩‍💻 Author

**Swetha Thavamani**  
 
> 💡 *A hands-on collection of Java exercises showcasing real-world design patterns, persistence, and structured OOP development.*
