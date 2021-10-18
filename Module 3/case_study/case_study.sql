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
(106,1,'Nguyen Tung', '1965-10-20', 'Da Nang'),
(107,1,'Nguyen Tinh', '1965-10-20', 'Quang Ngai'),
(108,3,'Nguyen A', '1965-10-20', 'Vinh'),
(109,1,'Nguyen The', '1965-10-20', 'Vinh');

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
    (9,101,106,105,'2019-03-02','2021-03-18',400,800),
	(10,103,106,105,'2018-05-24','2021-03-18',400,800),
    (11,101,106,105,'2018-03-02','2021-03-18',400,800),
	(12,103,106,null,'2019-05-24','2021-03-18',400,800),
    (13,101,106,null,'2019-03-02','2021-03-18',400,800);
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
where year(hopdong.checkIn) = '2019' and (month(hopdong.checkIn) between 1 and 3);

#7 7.Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
#nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.

 select hopdong.* ,kieuthue.tenKieuThue
 from hopdong
 right join dichvu  on hopdong.maDichVu = dichvu.maDichVu
 right join kieuthue  on kieuthue.maKieuThue = dichvu.maKieuThue
 where (year(hopdong.checkIn) = '2018') 
 and hopdong.maHopDong
 not in (
 select hopdong.maHopDong
from hopdong 
 right join dichvu  on hopdong.maDichVu = dichvu.maDichVu
 right join kieuthue  on kieuthue.maKieuThue = dichvu.maKieuThue
 where (year(hopdong.checkIn) = '2019'));

# 8.Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
# Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên

-- cách 1
 select tenKH
 from khachhang 
 left join hopdong on khachhang.maKH = hopdong.maKH
 union
select tenKH
from khachhang
left join hopdong  on khachhang.maKH = hopdong.maKH;

-- cách 2
select distinct tenKH
from khachhang;

 -- cách 3
 
 
 # 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
 
 
--  select (dichvu.chiPhi + sum(hopdongchitiet.soLuong * dichvudikem.gia)) as TongTien
--  from hopdong
-- join dichvu on dichvu.maDichVu = hopdong.maDichVu
-- join hopdongchitiet on hopdongchitiet.maHopDong = hopdong.maHopDong
-- join dichvudikem on hopdongchitiet.maDVDK = dichvudikem.maDVDK
-- group by hopdong.maHopDong 
-- having (year(hopdong.checkIn) = '2019');
  -- Đang bị lỗi having chưa biết fix làm s cả :(
  
  # 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
  #Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
  #(được tính dựa trên việc count các IDHopDongChiTiet).
  
 

select  hopdong.maHopDong, dichvu.tenDichVu, hopdong.checkIn, hopdong.checkOut, hopdong.tienCoc,
		count(hopdong.maHopDong) as SoDichVuDiKem
from hopdong
join dichvu on dichvu.maDichVu = hopdong.maDichVu
join hopdongchitiet on hopdongchitiet.maHopDong = hopdong.maHopDong
join dichvudikem on dichvudikem.maDVDK = hopdongchitiet.maDVDK
group by hopdong.maHopDong;
 
 # 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
 
 select dichvudikem.tenDVDK, hopdong.maKH, khachhang.tenKH, khachhang.maLoai, khachhang.diachi
from hopdong
join hopdongchitiet on hopdongchitiet.maHopDong = hopdong.maHopDong
join dichvudikem on dichvudikem.maDVDK = hopdongchitiet.maDVDK
join khachhang on hopdong.maKH = hopdong.maKH
where khachhang.maLoai = '1' and (diachi like 'Quang Ngai' or diachi like 'Vinh');
-- group by ????
 -- Dữ liệu đang bị trùng lặp nhờ tutor giúp đỡ
 
 # 12 Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), 
 #TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.
 
select hopdong.maHopDong, nhanvien.tenNV, khachhang.tenKH, khachhang.sdt, dichvu.tenDichVu, hopdong.tienCoc
		, hopdong.checkIn, dichvudikem.tenDVDK , count(dichvudikem.maDVDK) as SoLuongDichVuDikem
from dichvu
join hopdong on dichvu.maDichVu = hopdong.maDichVu
join nhanvien on nhanvien.maNV = hopdong.maNV
join khachhang on khachhang.maKH = hopdong.maKH
left join hopdongchitiet on hopdongchitiet.maHopDong = hopdong.maHopDong
left join dichvudikem on dichvudikem.maDVDK = hopdongchitiet.maDVDK
where year(hopdong.checkIn) = 2019 and month(hopdong.checkIn) between 10 and 12 
and not exists (
select hopdong.checkIn
from hopdong
where (hopdong.maDichVu = dichvu.maDichVu) and (year(hopdong.checkIn) = 2019 and month(hopdong.checkIn) between 1 and 6)
)
group by hopdong.maHopDong;


# 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
#(Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).



# 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
#Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung

select dichvudikem.tenDVDK, hopdong.maHopDong, dichvu.tenDichVu, count(dichvudikem.maDVDK)
from dichvudikem
join hopdongchitiet on dichvudikem.maDVDK = hopdongchitiet.maDVDK
join hopdong on hopdong.maHopDong = hopdongchitiet.maHDCT
join dichvu on dichvu.maDichVu = hopdong.maDichVu
group by dichvudikem.maDVDK
having count(dichvudikem.maDVDK) = 1;

# 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi
#  mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

select nhanvien.maNV, nhanvien.tenNV ,nhanvien.maTD, nhanvien.diachi, nhanvien.sdt
, hopdong.maHopDong, bophan.tenBoPhan, count(nhanvien.maNV)
from nhanvien
join hopdong on hopdong.maNV = nhanvien.maNV
join bophan on bophan.maBoPhan = nhanvien.maBoPhan
where (year(hopdong.checkIn) between 2018 and 2019)
group by nhanvien.maNV
having count(nhanvien.maNV)<=3;

# 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

delete from nhanvien
where not exists (
select nhanvien.maNV
from hopdong 
where hopdong.maNV = nhanvien.maNV and year(hopdong.checkIn) between 2017 and 2019
);

# 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
#chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

SET SQL_SAFE_UPDATES = 0;
update khachhang
set khachhang.maKH = 1
where khachhang.maKH in (
select *
from (select khachhang.maKH
from khachhang
join hopdong on hopdong.maKH = khachhang.maKH
where year(hopdong.checkIn) = 2019 and khachhang.maKH = 2
group by khachhang.maKH
having sum(tongtien) > 100)
tdlTmp
);
# 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).

delete
 from hopdong
 where not year(checkIn) between 2016 and 2021;

# 19.Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.






