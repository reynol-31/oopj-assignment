/*code meant to be executed on mySql workbench */
use toll;
show tables;
create table vehicles(
vehicle_id int primary key auto_increment,
reg_no varchar(15) unique not null,
vehicle_type varchar(20),
created_at timestamp default current_timestamp);
SELECT * FROM vehicles;	
DELETE FROM vehicles;
ALTER TABLE vehicles AUTO_INCREMENT = 1;   

CREATE TABLE toll_plaza_info (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    location VARCHAR(255),
    stretch VARCHAR(255),
    tollable_length FLOAT,
    fee_effective_date DATE,
    due_date_of_toll_revision DATE
);


INSERT INTO toll_plaza_info (name, location, stretch, tollable_length, fee_effective_date, due_date_of_toll_revision)
VALUES ('Gundmi (Sasthan)', 'Km 300.480 - NH-66 in Karnataka', 'Kundapur to Uduyavara', 40.530, '2024-06-03', '2025-03-31');