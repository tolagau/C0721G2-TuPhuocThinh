drop database if exists furama_resort;
create database furama_resort;
use furama_resort;
create table Chuc_Vu (
ma_chuc_vu int primary key,
ten_chuc_cu varchar(45)
);
insert Chuc_Vu values 
(1,'Manager'),(2,'HR'),(3,'Chef'),(4,'Staff');
create table Trinh_Do (
ma_trinh_do int primary key,
ten_trinh_do varchar (45) 
);
insert Trinh_Do values
(1,'DH'),(2,'CD'),(3,'TC');
create table Bo_Phan (
ma_bo_phan int primary key,
ten_bo_Phan varchar (45)
);
insert Bo_Phan values 
(1,'operation'),(2,'Service'),(3,'Administrative'), (4,'Sale-Marketing');
create table Nhan_Vien (
ma_nhan_vien int primary key auto_increment,
ten_nhan_vien varchar (45),
ma_chuc_vu int,
ma_trinh_do int,
ma_bo_phan int,
ngay_sinh date,
so_cmnd varchar(12),
luong varchar(45),
sdt varchar(20),
email varchar(45),
dia_chi varchar(45),
foreign key (ma_bo_phan) references Bo_Phan(ma_bo_phan),
foreign key (ma_trinh_do) references Trinh_Do(ma_trinh_do),
foreign key (ma_chuc_vu) references Chuc_Vu(ma_chuc_vu)
);
 insert Nhan_Vien values
	(101,'Thịnh',1,2,1,'1998-09-09','123456789','6000','123456789','thinh@gmail.com','Quảng Ngãi'),
	(102,'Thạch',2,1,1,'1988-02-09','123456789','4000','123456789','thanh@gmail.com','Quảng Nam'),
	(103,'Trung',3,3,1,'1978-01-09','123456789','8000','123456789','trunh@gmail.com','Quảng Ninh'),
	(104,'Tiến',4,2,1,'1996-08-09','123456789','9000','123456789','tien@gmail.com','Quảng Trị'),
	(105,'Khải',2,3,1,'1997-10-09','123456789','10000','123456789','khai@gmail.com','Quảng Nam'),
	(106,'Bảo',1,3,1,'1978-12-09','123456789','5000','123456789','bao@gmail.com','Đà Nẵng'),
    (107,'Ti',1,3,1,'1978-12-09','123456789','5000','123456789','ti@gmail.com','Đà Nẵng');
      
create table Loai_Khach_Hang(
ma_loai_Khach_Hang int primary key,
ten_loai_Khach_Hang varchar(45)
);
insert Loai_Khach_Hang value
	(1,'Diamond'),
    (2,'Platium'),
    (3,'Gold'),
    (4,'Sliver'),
    (5,'Member');
create table Khach_Hang (
ma_Khach_Hang int primary key auto_increment,
ma_loai_Khach_Hang int,
ten_Khach_Hang varchar (256),
ngay_sinh date,
so_cmnd varchar(256),
sdt varchar(256),
email varchar(256),
dia_chi varchar(256),
foreign key (ma_loai_Khach_Hang) references Loai_Khach_Hang(ma_loai_Khach_Hang)
);
insert Khach_Hang(ma_Khach_Hang,ma_loai_Khach_Hang,ten_Khach_Hang,ngay_sinh,dia_chi) values
(101,2,'Nguyen An', '1980-10-20', 'Da Nang'),
(102,3,'Nguyen Binh', '1989-10-20', 'Quang Tri'),
(103,4,'Nguyen Anh', '1965-10-20', 'Quang Nam'),
(104,4,'Nguyen Trung', '1988-11-20', 'Quang Nam'),
(105,1,'Nguyen Thinh', '1989-10-20', 'Ha Noi'),
(106,1,'Nguyen Tung', '1965-10-20', 'Da Nang'),
(107,1,'Nguyen Tinh', '1965-10-20', 'Quang Ngai'),
(108,3,'Nguyen A', '1965-10-20', 'Vinh'),
(109,1,'Nguyen The', '1965-10-20', 'Vinh');

create table Dich_Vu_Di_Kem (
	ma_dvdk int primary key auto_increment,
	ten_dvdk varchar(45),
	gia int,
	don_vi int,
	trang_thai bit
);
insert Dich_Vu_Di_Kem() value 
	(1, 'massage',500,1,1),
    (2, 'karaoke',500,1,1),
    (3, 'thức ăn',500,2,1),
    (4, 'nước uống',500,4,1),
	(5, 'thuê xe di chuyển ',500,2,1);
    
create table Loai_Dich_Vu(
	ma_loai_dich_vu int primary key auto_increment,
	ten_loai_dich_vu varchar(45)
);
insert Loai_Dich_Vu() value
	(1,'Room'),
    (2,'House'),
    (3,'Villa');
create table Kieu_Thue(
	ma_kieu_thue int primary key auto_increment,
	ten_kieu_thue varchar(45),
	gia int
);
	insert Kieu_Thue() value
    (1,'Ngày',1000),
    (2,'Tuần',2000),
    (3,'Tháng',3000);

create table Dich_Vu(
	ma_dich_vu int primary key auto_increment,
	ten_dich_vu varchar(45),
	dien_tich int,
	so_tang int,
	so_nguoi int,
	chi_phi varchar(45),
	ma_kieu_thue int,
	ma_loai_dich_vu int,
	trang_thai bit,
	foreign key (ma_kieu_thue) references Kieu_Thue(ma_kieu_thue),
	foreign key (ma_loai_dich_vu) references Loai_Dich_Vu(ma_loai_dich_vu)
);
insert into Dich_Vu() value
	(101,'Villa_A',50, 2,10, 3000,1,3,null),
	(102,'Villa_B',60, 2,8, 3500,1,3,null),
	(103,'House_A',30, 1,4, 1500,2,2,null),
	(104,'House_B',40, 2,2, 2000,1,2,null),
	(105,'Room_A',20, 1,2, 800,1,1,null);
create table Hop_Dong(
	ma_hop_dong int primary key auto_increment,
	ma_nhan_vien int,
	ma_Khach_Hang int,
	ma_dich_vu int,
	check_in date,
	check_out date,
	tien_coc int,
	tong_tien int,
	foreign key (ma_nhan_vien) references Nhan_Vien (ma_nhan_vien),
	foreign key (ma_dich_vu) references Dich_Vu (ma_dich_vu),
	foreign key (ma_Khach_Hang)  references Khach_Hang (ma_Khach_Hang)
);
insert Hop_Dong values 
	(1,101,103,101,'2020-10-10','2020-10-11',1000,2000),
	(2,103,101,102,'2021-10-10','2021-10-11',1000,2000),
	(3,102,102,103,'2021-10-12','2021-10-13',1000,2000),
	(4,103,104,105,'2021-10-15','2021-10-18',400,800),
    (5,102,105,103,'2021-09-12','2021-10-13',1000,2000),
	(6,103,106,105,'2021-08-15','2021-09-18',400,800),
    (7,103,106,105,'2019-02-24','2021-03-18',400,800),
    (8,103,106,105,'2019-05-24','2021-03-18',400,800),
    (9,101,106,105,'2019-03-02','2021-03-18',400,800),
	(10,103,106,105,'2018-05-24','2021-03-18',400,800),
    (11,101,106,105,'2018-03-02','2021-03-18',400,800),
	(12,103,106,null,'2019-05-24','2021-03-18',400,800),
    (13,101,106,null,'2019-03-02','2021-03-18',400,800);
create table Hop_Dong_Chi_Tiet (
	ma_hdct int primary key auto_increment,
	ma_dvdk int,
	ma_hop_dong int,
	so_luong int,
	foreign key (ma_hop_dong) references Hop_Dong (ma_hop_dong),
	foreign key (ma_dvdk)  references Dich_Vu_Di_Kem (ma_dvdk)
);
insert Hop_Dong_Chi_Tiet values
(1,1,1,1),(2,3,2,1),(3,2,3,2),(4,3,2,1),(5,2,1,3);
-- ~~ -- -- ~~ -- -- ~~ -- -- ~~ -- -- ~~ -- -- ~~ -- -- ~~ -- -- ~~ -- -- ~~ -- -- ~~ -- -- ~~ --


# 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên 
# bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.

select *
from Nhan_Vien
where (Nhan_Vien.ten_nhan_vien like '%H' or Nhan_Vien.ten_nhan_vien like '%T' ) and length(ten_nhan_vien) < 15;

# 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi 
# 		và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select *
from Khach_Hang
where ((datediff(now(),ngay_sinh)/365)<50) 
and (dia_chi like 'Da Nang' or dia_chi like 'Quang Tri');

# 4. Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
#Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
#Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select  Khach_Hang.ten_Khach_Hang, count(Khach_Hang.ma_Khach_Hang)
from Khach_Hang 
join Hop_Dong on Hop_Dong.ma_Khach_Hang = Khach_Hang.ma_Khach_Hang
join Loai_Khach_Hang on Khach_Hang.ma_loai_Khach_Hang= Loai_Khach_Hang.ma_loai_Khach_Hang
where Loai_Khach_Hang.ten_loai_Khach_Hang = 'Diamond'
group by Hop_Dong.ma_Khach_Hang
order by count(Khach_Hang.ma_Khach_Hang);

# 5.Hiển thị IDKhach_Hang, HoTen, ten_loai_Khach_HangKhach, IDHop_Dong, ten_dich_vu, NgayLamHop_Dong, NgayKetThuc, 
#tong_tien 
#(Với tong_tien được tính theo công thức như sau: chi_phiThue + so_luong*Gia, với so_luong và Giá là từ bảng Dich_Vu_Di_Kem) 
#cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

select Khach_Hang.ma_Khach_Hang, Khach_Hang.ten_Khach_Hang, Loai_Khach_Hang.ten_loai_Khach_Hang, 
Hop_Dong.ma_hop_dong, Dich_Vu.ten_dich_vu, Hop_Dong.check_in, Hop_Dong.check_out, 
(Dich_Vu.chi_phi + Hop_Dong_Chi_Tiet.so_luong * Dich_Vu_Di_Kem.gia) as tong_tien
from Khach_Hang 
join Loai_Khach_Hang on Khach_Hang.ma_loai_Khach_Hang = Loai_Khach_Hang.ma_loai_Khach_Hang
join Hop_Dong on Khach_Hang.ma_Khach_Hang = Hop_Dong.ma_Khach_Hang
join Dich_Vu on Dich_Vu.ma_dich_vu = Hop_Dong.ma_dich_vu
join Hop_Dong_Chi_Tiet on Hop_Dong_Chi_Tiet.ma_hop_dong = Hop_Dong.ma_hop_dong
join Dich_Vu_Di_Kem on Hop_Dong_Chi_Tiet.ma_dvdk = Dich_Vu_Di_Kem.ma_dvdk;

# 6.Hiển thị IDDich_Vu, ten_dich_vu, dien_tich, chi_phiThue, ten_loai_Khach_HangDich_Vu 
#của tất cả các loại Dịch vụ chưa từng được 
#Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).

select v.ma_dich_vu, v.ten_dich_vu, v.dien_tich, v.chi_phi, Loai_Dich_Vu.ten_loai_dich_vu, Hop_Dong.ma_hop_dong
from Dich_Vu v 
join Hop_Dong on Hop_Dong.ma_dich_vu = v.ma_dich_vu
join Loai_Dich_Vu on Loai_Dich_Vu.ma_loai_dich_vu = v.ma_loai_dich_vu
where year(Hop_Dong.check_in) = '2019' and (month(Hop_Dong.check_in) between 1 and 3);

#7 7.Hiển thị thông tin IDDich_Vu, ten_dich_vu, dien_tich, so_nguoiToiDa, chi_phiThue, ten_loai_Khach_HangDich_Vu của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
#nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.

 select Hop_Dong.* ,Kieu_Thue.ten_kieu_thue
 from Hop_Dong
 right join Dich_Vu  on Hop_Dong.ma_dich_vu = Dich_Vu.ma_dich_vu
 right join Kieu_Thue  on Kieu_Thue.ma_kieu_thue = Dich_Vu.ma_kieu_thue
 where (year(Hop_Dong.check_in) = '2018') 
 and Hop_Dong.ma_hop_dong
 not in (
 select Hop_Dong.ma_hop_dong
from Hop_Dong 
 right join Dich_Vu  on Hop_Dong.ma_dich_vu = Dich_Vu.ma_dich_vu
 right join Kieu_Thue  on Kieu_Thue.ma_kieu_thue = Dich_Vu.ma_kieu_thue
 where (year(Hop_Dong.check_in) = '2019'));

# 8.Hiển thị thông tin Hoten_Khach_Hangach_hang có trong hệ thống, với yêu cầu HoThenKhach_Hang không trùng nhau.
# Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên

-- cách 1
 select ten_Khach_Hang
 from Khach_Hang 
 left join Hop_Dong on Khach_Hang.ma_Khach_Hang = Hop_Dong.ma_Khach_Hang
 union
select ten_Khach_Hang
from Khach_Hang
left join Hop_Dong  on Khach_Hang.ma_Khach_Hang = Hop_Dong.ma_Khach_Hang;

-- cách 2
select distinct ten_Khach_Hang
from Khach_Hang;

 -- cách 3
 
 
 # 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
 
 
--  select (Dich_Vu.chi_phi + sum(Hop_Dong_Chi_Tiet.so_luong * Dich_Vu_Di_Kem.gia)) as tong_tien
--  from Hop_Dong
-- join Dich_Vu on Dich_Vu.ma_dich_vu = Hop_Dong.ma_dich_vu
-- join Hop_Dong_Chi_Tiet on Hop_Dong_Chi_Tiet.ma_hop_dong = Hop_Dong.ma_hop_dong
-- join Dich_Vu_Di_Kem on Hop_Dong_Chi_Tiet.ma_dvdk = Dich_Vu_Di_Kem.ma_dvdk
-- group by Hop_Dong.ma_hop_dong 
-- having (year(Hop_Dong.check_in) = '2019');
  -- Đang bị lỗi having chưa biết fix làm s cả :(
  
  # 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
  #Kết quả hiển thị bao gồm IDHop_Dong, NgayLamHop_Dong, NgayKetthuc, TienDatCoc, so_luongDich_Vu_Di_Kem 
  #(được tính dựa trên việc count các IDHop_Dong_Chi_Tiet).
  
 

select  Hop_Dong.ma_hop_dong, Dich_Vu.ten_dich_vu, Hop_Dong.check_in, Hop_Dong.check_out, Hop_Dong.tien_coc,
		count(Hop_Dong.ma_hop_dong) as SoDich_Vu_Di_Kem
from Hop_Dong
join Dich_Vu on Dich_Vu.ma_dich_vu = Hop_Dong.ma_dich_vu
join Hop_Dong_Chi_Tiet on Hop_Dong_Chi_Tiet.ma_hop_dong = Hop_Dong.ma_hop_dong
join Dich_Vu_Di_Kem on Dich_Vu_Di_Kem.ma_dvdk = Hop_Dong_Chi_Tiet.ma_dvdk
group by Hop_Dong.ma_hop_dong;
 
 # 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có ten_loai_Khach_Hang_Khach_Hang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
 
 select Dich_Vu_Di_Kem.ten_dvdk, Hop_Dong.ma_Khach_Hang, Khach_Hang.ten_Khach_Hang, Khach_Hang.ma_loai_Khach_Hang, Khach_Hang.dia_chi
from Hop_Dong
join Hop_Dong_Chi_Tiet on Hop_Dong_Chi_Tiet.ma_hop_dong = Hop_Dong.ma_hop_dong
join Dich_Vu_Di_Kem on Dich_Vu_Di_Kem.ma_dvdk = Hop_Dong_Chi_Tiet.ma_dvdk
join Khach_Hang on Hop_Dong.ma_Khach_Hang = Hop_Dong.ma_Khach_Hang
where Khach_Hang.ma_loai_Khach_Hang = '1' and (dia_chi like 'Quang Ngai' or dia_chi like 'Vinh');
-- group by ????
 -- Dữ liệu đang bị trùng lặp nhờ tutor giúp đỡ
 
 # 12 Hiển thị thông tin IDHop_Dong, TenNhan_Vien, ten_Khach_Hangach_hang, SoDienThoaiKhach_Hang, ten_dich_vu, so_luongDich_Vu_Di_Kem (được tính dựa trên tổng Hợp đồng chi tiết), 
 #TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.
 
select Hop_Dong.ma_hop_dong, Nhan_Vien.ten_nhan_vien, Khach_Hang.ten_Khach_Hang, Khach_Hang.sdt, Dich_Vu.ten_dich_vu, Hop_Dong.tien_coc
		, Hop_Dong.check_in, Dich_Vu_Di_Kem.ten_dvdk , count(Dich_Vu_Di_Kem.ma_dvdk) as so_luongDich_Vu_Di_Kem
from Dich_Vu
join Hop_Dong on Dich_Vu.ma_dich_vu = Hop_Dong.ma_dich_vu
join Nhan_Vien on Nhan_Vien.ma_nhan_vien = Hop_Dong.ma_nhan_vien
join Khach_Hang on Khach_Hang.ma_Khach_Hang = Hop_Dong.ma_Khach_Hang
left join Hop_Dong_Chi_Tiet on Hop_Dong_Chi_Tiet.ma_hop_dong = Hop_Dong.ma_hop_dong
left join Dich_Vu_Di_Kem on Dich_Vu_Di_Kem.ma_dvdk = Hop_Dong_Chi_Tiet.ma_dvdk
where year(Hop_Dong.check_in) = 2019 and month(Hop_Dong.check_in) between 10 and 12 
and not exists (
select Hop_Dong.check_in
from Hop_Dong
where (Hop_Dong.ma_dich_vu = Dich_Vu.ma_dich_vu) and (year(Hop_Dong.check_in) = 2019 and month(Hop_Dong.check_in) between 1 and 6)
)
group by Hop_Dong.ma_hop_dong;


# 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
#(Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
	select * sum(so_luong) as Tong
    from Dich_Vu_Di_Kem
    join Hop_Dong on Hop_Dong.ma_hop_dong = Hop_Dong_Chi_Tiet. ma_hop_dong
    join Hop_Dong_Chi_Tiet on Hop_Dong_Chi_Tiet.ma_DVDK = Dich_Vu_Di_Kem.ma_DVDK
    group by Hop_Dong_Chi_Tiet.so_luong


# 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
#Thông tin hiển thị bao gồm IDHop_Dong, ten_loai_Khach_HangDich_Vu, ten_dich_vu_Di_Kem, SoLanSuDung

select Dich_Vu_Di_Kem.ten_dvdk, Hop_Dong.ma_hop_dong, Dich_Vu.ten_dich_vu, count(Dich_Vu_Di_Kem.ma_dvdk)
from Dich_Vu_Di_Kem
join Hop_Dong_Chi_Tiet on Dich_Vu_Di_Kem.ma_dvdk = Hop_Dong_Chi_Tiet.ma_dvdk
join Hop_Dong on Hop_Dong.ma_hop_dong = Hop_Dong_Chi_Tiet.ma_hdct
join Dich_Vu on Dich_Vu.ma_dich_vu = Hop_Dong.ma_dich_vu
group by Dich_Vu_Di_Kem.ma_dvdk
having count(Dich_Vu_Di_Kem.ma_dvdk) = 1;

# 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhan_Vien, HoTen, Trinh_Do, ten_bo_Phan, SoDienThoai, dia_chi
#  mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

select Nhan_Vien.ma_nhan_vien, Nhan_Vien.ten_nhan_vien ,Nhan_Vien.ma_trinh_do, Nhan_Vien.dia_chi, Nhan_Vien.sdt
, Hop_Dong.ma_hop_dong, Bo_Phan.ten_bo_Phan, count(Nhan_Vien.ma_nhan_vien)
from Nhan_Vien
join Hop_Dong on Hop_Dong.ma_nhan_vien = Nhan_Vien.ma_nhan_vien
join Bo_Phan on Bo_Phan.ma_bo_phan = Nhan_Vien.ma_bo_phan
where (year(Hop_Dong.check_in) between 2018 and 2019)
group by Nhan_Vien.ma_nhan_vien
having count(Nhan_Vien.ma_nhan_vien)<=3;

# 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

	#đúng
-- SET FOREIGN_KEY_CHECKS=0;
-- delete 
-- from Nhan_Vien
-- where Nhan_Vien.ma_nhan_vien not in (
-- select Hop_Dong.ma_nhan_vien
-- from Hop_Dong
-- where year(Hop_Dong.check_in) between 2017 and 2019
-- );
-- SET FOREIGN_KEY_CHECKS=1;


# 17.	Cập nhật thông tin những khách hàng có ten_loai_Khach_Hang_Khach_Hang từ  Platinium lên Diamond, 
#chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

SET SQL_SAFE_UPDATES = 0;
update Khach_Hang
set Khach_Hang.ma_Khach_Hang = 1
where Khach_Hang.ma_Khach_Hang in (
select *
from (select Khach_Hang.ma_Khach_Hang
from Khach_Hang
join Hop_Dong on Hop_Dong.ma_Khach_Hang = Khach_Hang.ma_Khach_Hang
where year(Hop_Dong.check_in) = 2019 and Khach_Hang.ma_Khach_Hang = 2
group by Khach_Hang.ma_Khach_Hang
having sum(tong_tien) > 100)
tdlTmp
);
SET SQL_SAFE_UPDATES = 1;

# 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).

--  delete
--   from Hop_Dong
--   where not year(check_in) between 2016 and 2021;

# 19.Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
	insert into hop_dong_chi_tiet value 
	(6,2,6,10);
    
SET SQL_SAFE_UPDATES = 0;

	update Dich_Vu_Di_Kem
    set Dich_Vu_Di_Kem.gia = Dich_Vu_Di_Kem.gia * 2 
    
    where Dich_Vu_Di_Kem.ma_dvdk in (
    select *
    from (
    select Dich_Vu_Di_Kem.ma_dvdk
    from Hop_Dong 
    join Hop_Dong_Chi_Tiet on Hop_Dong_Chi_Tiet.ma_hop_dong = Hop_Dong.ma_hop_dong
    join Dich_Vu_Di_Kem on Hop_Dong_Chi_Tiet.ma_dvdk = Dich_Vu_Di_Kem.ma_dvdk
    group by Hop_Dong_Chi_Tiet.so_luong
    having sum(Hop_Dong_Chi_Tiet.so_luong) >= 10)
    tblTmc);
    
SET SQL_SAFE_UPDATES = 1;

	

# 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm 
# ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.

select Nhan_Vien.*, Khach_Hang.*
from Khach_Hang
join Hop_Dong on Hop_Dong.ma_khach_hang = Khach_Hang.ma_khach_hang
join Nhan_Vien on Nhan_Vien.ma_nhan_vien = Hop_Dong.ma_nhan_vien





