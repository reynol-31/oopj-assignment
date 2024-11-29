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