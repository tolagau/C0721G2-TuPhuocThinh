create database my_database1;
drop database my_database1;
use my_database1;
create table student (
id int not null,
name nvarchar(256) not null,
age int not null,
country nvarchar(256) not null,
primary key (id));