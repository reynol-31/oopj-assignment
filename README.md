
# Toll Management System

## Description
This project is a Java-based Toll Management System that allows users to manage toll records, view fees, insert vehicle data, and display toll plaza information. It integrates with a MySQL database for storing and retrieving vehicle and toll data.

---

## Software Requirements

- **Programming Language:** Java
- **Database:** MySQL
- **Java Development Kit (JDK):** Version 8 or higher
- **IDE:** Any Java IDE (e.g., IntelliJ IDEA, Eclipse, NetBeans)
- **Database Driver:** MySQL Connector/J

---

## Classes and Interfaces

### 1. **FeeViewer**
   - **Methods:**
     - `getFee(String vehicleType): double`  
       Returns the toll fee for a given vehicle type.
     - `displayFees(): void`  
       Displays a table of toll fees for different vehicle types.

### 2. **TollRecordViewer**
   - **Methods:**
     - `viewRecords(): void`  
       Retrieves and displays toll records from the database, including daily summaries, monthly summaries, and total amounts collected.

### 3. **DatabaseConnection**
   - **Methods:**
     - `getConnection(): Connection`  
       Establishes and returns a connection to the MySQL database.

### 4. **InsertVehicle**
   - **Methods:**
     - `insertData(String regNo, String vehicleType): boolean`  
       Inserts a new vehicle record into the database with the registration number, vehicle type, and the current timestamp.

### 5. **TollPlazaInfo**
   - **Methods:**
     - `displayInfo(): void`  
       Displays static information about the toll plaza, including location, stretch, and effective dates.

### 6. **TestClassJava**
   - **Methods:**
     - `main(String[] args): void`  
       Main entry point of the application. Provides a menu-driven interface to interact with the system functionalities.

---

## Database Schema

- **Table:** `vehicles`
  - `reg_no` (VARCHAR) - Registration number of the vehicle.
  - `vehicle_type` (VARCHAR) - Type of vehicle (e.g., car, bus, truck).
  - `created_at` (TIMESTAMP) - Timestamp of when the record was created.

---

## How to Run the Project

1. Clone or download the project files.
2. Configure the MySQL database:
   - Create a database named `toll`.
   - Import the necessary table schema (ensure the `vehicles` table exists).
3. Update database credentials in the `DatabaseConnection` class.
4. Compile and run the `TestClassJava` file.
5. Interact with the menu to manage toll data and view information.

---
