drop database if exists furama_resort;
create database furama_resort;
use furama_resort;
create table position (
	positionId int primary key,
	positionName varchar(256)
);
#insert position values (1,"Manager"),(2,'HR'),(3,'Chef'),(4,'Staff');
create table education_level (
	levelId int primary key,
	levelName varchar (45) 
);
#insert position values(1,'DH'),(2,'CD'),	(3,'TC');
create table part (
	partId int primary key,
	partNane varchar (45)
);
#insert part values 	(1,'operation'),	(2,'kitchen'),	(3,'restaurant');
create table staff (
	staffId int primary key auto_increment,
	staffName varchar (45),
	positionId int,
	levelId int,
	partId int,
	dayOfBirth date,
	idNumber varchar(12),
	salary varchar(45),
	phoneNumber varchar(20),
	email varchar(45),
	address varchar(45),
	foreign key (partId) references part (partId),
	foreign key (levelId) references education_level (levelId),
	foreign key (positionId) references position (positionId)
);
#insert staff (staffId, staffName,positionId,levelId, partId, dayOffBirth) values
-- (1001,'Nguyen Hung',1,2,3,'1989-09-09'),
-- (1002,'Nguyen Thang',2,3,3,'1990-09-08'),
-- (1003,'Nguyen Khanh',3,3,'1989-08-08'),
#	(1004,'Nguyen Hung',3,2,3,'1992-08-12');
create table type_of_customer(
	typeId int primary key,
	typeName varchar(45)
);
create table customer (
	customerId int primary key auto_increment,
	typeId int,
	foreign key (typeId) references type_of_customer (typeId),
	customerName varchar (45),
	dayOfBirth date,
	idNumber varchar(12),
	phoneNumber varchar(20),
	email varchar(45),
	address varchar(45)
);
create table accompanied_service (
	aId int primary key auto_increment,
	aName varchar(45),
	aPrice int,
	unit int,
	`status` bit
);
create table type_of_service(
	typeServiceId int primary key auto_increment,
	typeServiceName varchar(45)
);
create table type_of_rental(
	typeRentalId int primary key auto_increment,
	typeRentalName varchar(45),
	rentalPrice int
);
create table service(
	serviceId int primary key auto_increment,
	serviceName varchar(45),
	area int,
	numberOfFloors int,
	numberOfPerson int,
	cost varchar(45),
	typeRentalId int,
	typeServiceId int,
	`status` bit,
	foreign key (typeRentalId) references type_of_rental(typeRentalId),
	foreign key (typeServiceId) references type_of_service(typeServiceId)
);
create table contract(
	contractId int primary key auto_increment,
	staffId int,
	customerId int,
	serviceId int,
	checkIn date,
	checkOut date,
	deposit int,
	totalMoney int,
	foreign key (staffId) references staff (staffId),
	foreign key (serviceId) references service (serviceId),
	foreign key (customerId)  references customer (customerId)
);
create table detail_contract (
	detaiContracId int primary key auto_increment,
	aId int,
	contractId int,
	quantity int,
	foreign key (contractId) references contract (contractId),
	foreign key (aId)  references accompanied_service (aId)
);