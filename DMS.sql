CREATE DATABASE IF NOT EXISTS DMS;
Use DMS;

CREATE TABLE IF NOT EXISTS Orders(
order_id int not null AUTO_INCREMENT,
dateOfOrder DATETIME,
location varchar (50),
order_picked boolean not null default false,
PRIMARY KEY (order_id)
);

CREATE TABLE IF NOT EXISTS Drivers(
driver_id int not null AUTO_INCREMENT,
first_name char (40),
surname char (40),
driver_busy boolean not null default false,
PRIMARY KEY (driver_id)
);

CREATE TABLE IF NOT EXISTS Delivery_Orders(
delivery_id int not null AUTO_INCREMENT,
order_id int not null,
driver_id int not null,
item_delivered boolean not null default false,
deliveryDate DATETIME default null,
PRIMARY KEY (delivery_id),
FOREIGN KEY (order_id) references Orders(order_id),
FOREIGN KEY (driver_id) references Drivers(driver_id)
);





