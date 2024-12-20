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
     - `displayFeesAndTotal(): void`  
       Displays a table of toll fees for different vehicle types and calculates the total fee dynamically by fetching data from the database.
     - `calculateTotalFee(): double`  
       Computes the total toll fee collected from the `vehicles` table in the database.

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

- **Table 1:** `vehicles`
  ```sql
  CREATE TABLE vehicles (
      id INT AUTO_INCREMENT PRIMARY KEY,
      reg_no VARCHAR(50),
      vehicle_type VARCHAR(50),
      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  );
  ```

- **Table 2:** `toll_plaza_info`
  ```sql
  CREATE TABLE toll_plaza_info (
      id INT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(100),
      location VARCHAR(255),
      stretch VARCHAR(255),
      tollable_length FLOAT,
      fee_effective_date DATE,
      due_date_of_toll_revision DATE
  );
  ```

---

## How to Run the Project

1. Clone or download the project files.
2. Configure the MySQL database:
   - Create a database named `toll`.
   - Import the necessary table schemas (ensure the `vehicles` and `toll_plaza_info` tables exist).
3. Update database credentials in the `DatabaseConnection` class.
4. Compile and run the `TestClassJava` file.
5. Interact with the menu to manage toll data and view information.

---

