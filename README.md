# Toll Management System

## Overview

The **Toll Management System** is a Java-based application designed to streamline toll collection processes, provide a summary of toll records, and manage toll plaza information. It incorporates features for vehicle data entry, fee calculation, toll plaza management, and record viewing. The application interacts with a MySQL database to store and retrieve toll-related data.

---

## Features

- **Insert Vehicle Data:** Allows users to input vehicle registration numbers, types, and toll plaza details.
- **View Toll Plaza Information:** Displays details of the toll plazas such as location, tollable length, and fee effective dates.
- **View Toll Records:** Summarizes daily, monthly, and overall toll collection data, sorted by toll plaza.
- **View Toll Fees:** Shows toll fees for various vehicle types.
- **Add New Toll Plaza:** Dynamically add new toll plazas to the system.

---

## Installation and Setup

1. Clone the repository or download the project files.
2. Set up a MySQL database named `toll`.
3. Use the following script to create the required tables:

```sql
CREATE TABLE vehicles (
    reg_no VARCHAR(20),
    vehicle_type VARCHAR(20),
    toll_plaza VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE toll_plaza_info (
    name VARCHAR(50),
    location VARCHAR(100),
    stretch VARCHAR(50),
    tollable_length FLOAT,
    fee_effective_date DATE,
    due_date_of_toll_revision DATE
);
```

4. Update the `DatabaseConnection` class with your MySQL credentials.
5. Run the application in any Java IDE or compile it using the command line.

---

## Usage

1. Navigate through the menu options in the main program to:
   - Insert vehicle data.
   - View toll plaza or toll records.
   - Check the toll fees for various vehicle types.
   - Add new toll plazas.
2. Ensure the `vehicle_fees.txt` file is updated with vehicle types and their respective fees in the following format:
   ```
   car, 50
   bus, 100
   ```

---

## Technologies Used

- **Programming Language:** Java
- **Database:** MySQL
- **Libraries:** JDBC for database connectivity

---

## Team Members

- **Reynol Dsouza** - [LinkedIn](https://www.linkedin.com/in/reynol-d-souza-593543290?utm_source=share\&utm_campaign=share_via\&utm_content=profile\&utm_medium=android_app)
- **Manoj Kumar** - [LinkedIn](https://www.linkedin.com/in/manoj-kumar-72065728b?utm_source=share\&utm_campaign=share_via\&utm_content=profile\&utm_medium=android_app)
- **Prajwal Shanbhag** - [LinkedIn](https://in.linkedin.com/in/prajwal-shanbhag-68a983224)
- **Nishith Poojary** - [LinkedIn](https://www.linkedin.com/in/nishith-poojary-51278028b?utm_source=share\&utm_campaign=share_via\&utm_content=profile\&utm_medium=android_app)

---

## Acknowledgements

We would like to extend our gratitude to the following for their guidance and technical assistance:

- **ChatGPT**
- **YouTube Tutorials**
- **Mr. Chandrashekar Rao Kuthyar** - [LinkedIn](https://www.linkedin.com/in/ckuthyar?utm_source=share\&utm_campaign=share_via\&utm_content=profile\&utm_medium=android_app)
- **GeeksforGeeks** - [Website](https://www.geeksforgeeks.org/)

---

## License

This project is developed for educational purposes. Please contact the authors for licensing queries.

