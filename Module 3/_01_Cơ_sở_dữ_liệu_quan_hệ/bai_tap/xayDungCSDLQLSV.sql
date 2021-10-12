use my_database1;
create table Class (
id int not null,
name nvarchar(256) not null,
age int not null,
country nvarchar(256) not null,
primary key (id));
create table Teacher (
id int not null,
name nvarchar(256) not null,
age int not null,
country nvarchar(256) not null,
primary key (id));