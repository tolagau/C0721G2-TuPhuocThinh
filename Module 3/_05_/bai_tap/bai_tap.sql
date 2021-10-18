drop database if exists demo;
create database demo;
use demo;
create table Products(
Id int primary key auto_increment,
productCode int,
productName varchar(45),
productPrice double,
productAmount int,
productDescription varchar(45),
productStatus varchar(45)
);

insert into Products (productCode,productName,productPrice,productStatus) values
(1,'Iphone 7', 7000000, 1),
(2,'Iphone 7 Plus', 8000000, 0),
(3,'Iphone 8', 9000000, 1),
(4,'Iphone 11', 12000000, 1),
(5,'Iphone 12', 20000000, 1),
(6,'Iphone 13', 3000000, 1);
--------------------------------- 

-- EXPLAIN SELECT * FROM product WHERE productName = 'Iphone 8'; 
-- create unique index index_product_code on product (productCode);
-- EXPLAIN SELECT * FROM product WHERE productCode = '3'; 
-- create  index index_name_price on product (productName, productPrice);
-- EXPLAIN SELECT * FROM product WHERE productName = 'Iphone 8'; 

create view view_products as
select  productCode, productName, productPrice, productStatus
from Products;

update view_products
set productPrice = 9000
where productCode = 1;




delimiter //
create procedure find_by_product()
begin
	select *
    from Products;
end;
// delimiter ;
-- drop procedure find_by_product;
call find_by_product();

DELIMITER //
create procedure insert_new_product (productCode int, productName varchar(45),
productPrice double, productStatus varchar(45))
 begin
	insert into Products (productCode,productName,productPrice,productStatus) values
	(productCode,productName,productPrice,productStatus);
 end //
 
DELIMITER ;

call insert_new_product(7,'Iphone XS', 3, 1);



DELIMITER //
create procedure edit_product (new_id int, new_code int, new_name varchar(45),
new_price double, new_status bit)
 begin
	update Products
	set productCode = new_code,
	productName = new_name,
	productPrice = new_price,
	productStatus =new_status
	where  Id = new_id;
 end //
 DELIMITER ;
DELIMITER //
call edit_product(7,8,'Iphone 13 P', 3000000, 1);


create procedure delete_product (new_id int)
 begin
	delete 
	from product
	where Id = new_id ;
 end //
DELIMITER ;
call delete_product(7);




