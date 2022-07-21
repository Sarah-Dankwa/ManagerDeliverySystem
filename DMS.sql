CREATE DATABASE DMS;
Use DMS;

CREATE TABLE Orders(
order_id int not null AUTO_INCREMENT,
dateOfOrder DATETIME,
location varchar (50),
PRIMARY KEY (order_id)
);

CREATE TABLE Drivers(
driver_id int not null AUTO_INCREMENT,
first_name char (40),
surname char (40),
PRIMARY KEY (driver_id)
);

CREATE TABLE Delivery_Orders(
delivery_id int not null AUTO_INCREMENT,
order_id int not null,
driver_id int not null,
deliveryDate DATETIME,
PRIMARY KEY (delivery_id),
FOREIGN KEY (order_id) references Orders(order_id),
FOREIGN KEY (driver_id) references Drivers(driver_id)
);





