drop database if exists furama_resort;
create database furama_resort;
use furama_resort;
create table ChucVu (
maChucVu int primary key,
tenChucVu varchar(45)
);
insert ChucVu values 
(1,'Manager'),(2,'HR'),(3,'Chef'),(4,'Staff');
create table TrinhDo (
maTD int primary key,
tenTD varchar (45) 
);
insert TrinhDo values
(1,'DH'),(2,'CD'),(3,'TC');
create table BoPhan (
maBoPhan int primary key,
tenBoPhan varchar (45)
);
insert BoPhan values 
(1,'operation'),(2,'Service'),(3,'Administrative'), (4,'Sale-Marketing');
create table NhanVien (
maNV int primary key auto_increment,
tenNV varchar (45),
maChucVu int,
maTD int,
maBoPhan int,
ngaysinh date,
soCMND varchar(12),
luong varchar(45),
sdt varchar(20),
email varchar(45),
diachi varchar(45),
foreign key (maBoPhan) references BoPhan(maBoPhan),
foreign key (maTD) references TrinhDo(maTD),
foreign key (maChucVu) references ChucVu(maChucVu)
);
 insert NhanVien values
	(101,'Thịnh',1,2,1,'1998-09-09','123456789','6000','123456789','thinh@gmail.com','Quảng Ngãi'),
	(102,'Thạch',2,1,1,'1988-02-09','123456789','4000','123456789','thanh@gmail.com','Quảng Nam'),
	(103,'Trung',3,3,1,'1978-01-09','123456789','8000','123456789','trunh@gmail.com','Quảng Ninh'),
	(104,'Tiến',4,2,1,'1996-08-09','123456789','9000','123456789','tien@gmail.com','Quảng Trị'),
	(105,'Khải',2,3,1,'1997-10-09','123456789','10000','123456789','khai@gmail.com','Quảng Nam'),
	(106,'Bảo',1,3,1,'1978-12-09','123456789','5000','123456789','bao@gmail.com','Đà Nẵng');
      
create table loaiKhachHang(
maLoai int primary key,
tenLoai varchar(45)
);
insert loaiKhachHang value
	(1,'Diamond'),
    (2,'Platium'),
    (3,'Gold'),
    (4,'Sliver'),
    (5,'Member');
create table KhachHang (
maKH int primary key auto_increment,
maLoai int,
tenKH varchar (256),
ngaysinh date,
soCMND varchar(256),
sdt varchar(256),
email varchar(256),
diachi varchar(256),
foreign key (maLoai) references loaiKhachHang (maLoai)
);
insert KhachHang(maKH,maLoai,tenKH,ngaysinh,diachi) values
(101,2,'Nguyen An', '1980-10-20', 'Da Nang'),
(102,3,'Nguyen Binh', '1989-10-20', 'Quang Tri'),
(103,4,'Nguyen Anh', '1965-10-20', 'Quang Nam'),
(104,4,'Nguyen Trung', '1988-11-20', 'Quang Nam'),
(105,1,'Nguyen Thinh', '1989-10-20', 'Ha Noi'),
(106,1,'Nguyen Tung', '1965-10-20', 'Da Nang');

create table DichVuDiKem (
	maDVDK int primary key auto_increment,
	tenDVDK varchar(45),
	gia int,
	donvi int,
	trangthai bit
);
insert DichVuDiKem() value 
	(1, 'massage',500,1,1),
    (2, 'karaoke',500,1,1),
    (3, 'thức ăn',500,2,1),
    (4, 'nước uống',500,4,1),
	(5, 'thuê xe di chuyển ',500,2,1);
    
create table LoaiDichVu(
	maLoaiDV int primary key auto_increment,
	tenLoaiDV varchar(45)
);
insert LoaiDichVu() value
	(1,'Room'),
    (2,'House'),
    (3,'Villa');
create table KieuThue(
	maKieuThue int primary key auto_increment,
	tenKieuThue varchar(45),
	gia int
);
	insert KieuThue() value
    (1,'Ngày',1000),
    (2,'Tuần',2000),
    (3,'Tháng',3000);

create table DichVu(
	maDichVu int primary key auto_increment,
	tenDichVu varchar(45),
	dienTich int,
	soTang int,
	soNguoi int,
	chiPhi varchar(45),
	maKieuThue int,
	maLoaiDV int,
	trangthai bit,
	foreign key (maKieuThue) references KieuThue(maKieuThue),
	foreign key (maLoaiDV) references LoaiDichVu(maLoaiDV)
);
insert into DichVu() value
	(101,'Villa_A',50, 2,10, 3000,1,3,null),
	(102,'Villa_B',60, 2,8, 3500,1,3,null),
	(103,'House_A',30, 1,4, 1500,2,2,null),
	(104,'House_B',40, 2,2, 2000,1,2,null),
	(105,'Room_A',20, 1,2, 800,1,1,null);
create table HopDong(
	maHopDong int primary key auto_increment,
	maNV int,
	maKH int,
	maDichVu int,
	checkIn date,
	checkOut date,
	tienCoc int,
	tongTien int,
	foreign key (maNV) references NhanVien (maNV),
	foreign key (maDichVu) references DichVu (maDichVu),
	foreign key (maKH)  references KhachHang (maKH)
);
insert HopDong values 
	(1,101,103,101,'2020-10-10','2020-10-11',1000,2000),
	(2,103,101,102,'2021-10-10','2021-10-11',1000,2000),
	(3,102,102,103,'2021-10-12','2021-10-13',1000,2000),
	(4,103,104,105,'2021-10-15','2021-10-18',400,800),
    (5,102,105,103,'2021-09-12','2021-10-13',1000,2000),
	(6,103,106,105,'2021-08-15','2021-09-18',400,800),
    (7,103,106,105,'2019-02-24','2021-03-18',400,800),
    (8,103,106,105,'2019-05-24','2021-03-18',400,800),
    (9,101,106,105,'2019-03-02','2021-03-18',400,800);
create table HopDongChiTiet (
	maHDCT int primary key auto_increment,
	maDVDK int,
	maHopDong int,
	soLuong int,
	foreign key (maHopDong) references HopDong (maHopDong),
	foreign key (maDVDK)  references DichVuDiKem (maDVDK)
);
insert HopDongChiTiet values
(1,1,1,1),(2,3,2,1),(3,2,3,2),(4,3,2,1),(5,2,1,3);
-- ~~ -- -- ~~ -- -- ~~ -- -- ~~ -- -- ~~ -- -- ~~ -- -- ~~ -- -- ~~ -- -- ~~ -- -- ~~ -- -- ~~ --


# 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên 
# bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.

select *
from nhanvien
where (nhanvien.tenNV like '%H' or nhanvien.tenNV like '%T' ) and length(tenNV) < 15;

# 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi 
# 		và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select *
from khachhang
where ((datediff(now(),ngaysinh)/365)<50) 
and (diachi like 'Da Nang' or diachi like 'Quang Tri');

# 4. Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
#Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
#Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select  khachhang.tenKH, count(khachhang.maKH)
from khachhang 
join hopdong on hopdong.maKH = khachhang.maKH
join loaikhachhang on khachhang.maloai= loaikhachhang.maloai
where loaikhachhang.tenloai = 'Diamond'
group by hopdong.maKH
order by count(khachhang.maKH);

# 5.Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, 
#TongTien 
#(Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
#cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

select khachhang.maKH, khachhang.tenKH, loaikhachhang.tenloai, 
hopdong.maHopDong, dichvu.tenDichVu, hopdong.checkIn, hopdong.checkOut, 
(dichvu.chiPhi + hopdongchitiet.soLuong * dichvudikem.gia) as TongTien
from khachhang 
join loaikhachhang on khachhang.maLoai = loaikhachhang.maLoai
join hopdong on khachhang.maKH = hopdong.maKH
join dichvu on dichvu.maDichVu = hopdong.maDichVu
join hopdongchitiet on hopdongchitiet.maHopDong = hopdong.maHopDong
join dichvudikem on hopdongchitiet.maDVDK = dichvudikem.maDVDK;

# 6.Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu 
#của tất cả các loại Dịch vụ chưa từng được 
#Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).

select v.maDichVu, v.tenDichVu, v.dienTich, v.chiPhi, loaidichvu.tenLoaiDV, hopdong.maHopDong
from dichvu v 
join hopdong on hopdong.maDichVu = v.maDichVu
join loaidichvu on loaidichvu.maLoaiDV = v.maLoaiDV
where year(hopdong.checkIn) = '2019' and (month(hopdong.checkIn) between 1 and 3)
























