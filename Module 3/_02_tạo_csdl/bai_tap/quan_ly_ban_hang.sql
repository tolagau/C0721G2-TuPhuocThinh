drop database if exists QuanLyBanHang;
create database QuanLyBanHang;

use QuanLyBanHang;

create table Customer(
cID int primary key auto_increment, 
cName varchar(50), 
cAge varchar(50)
);

create table `Order`(
oID int primary key auto_increment,
cID int, 
oDate date, 
oTatalPrice double,
foreign key(cID) references Customer (cID)
);

create table Product(
pID int primary key auto_increment, 
pName varchar(50), 
`pAge` varchar(50)
);

create table OrderDetail(
oID int, 
pID int, 
odQTY varchar(50),
foreign key(oID) references `Order` (oID),
foreign key(pID) references Product (pID)
);

