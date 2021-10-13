drop database if exists khohang;
create database khohang;
use khohang;

create table so_dien_thoai(
	sdt char(10) primary key,
    `name` varchar(50)
);
create table nha_c_c(
	idNCC  int auto_increment primary key,
    tenNCC varchar(50),
    diachi varchar(256),
    so_dien_thoai_sdt char(10),
    foreign key (so_dien_thoai_sdt) references so_dien_thoai(sdt)
);
create table vat_tu(
	idVT int auto_increment primary key,
    tenVT varchar(50)
);
create table don_dat_hang(
	idDH  int auto_increment primary key,
    ngayDH date,
    nha_c_c_idNCC  int,
    foreign key (nha_c_c_idNCC) references nha_c_c(idNCC)
);
create table phieu_xuat(
	idPX  int auto_increment primary key,
    ngayxuat date
    
);

create table phieu_nhap(
	idPN  int auto_increment primary key,
    ngaynhap date

);




create table chi_tiet_cung_cap(
	vat_tu_idVT int,
    don_dat_hang_idDH  int,
    primary key (vat_tu_idVT, don_dat_hang_idDH),
    foreign key (vat_tu_idVT) references vat_tu(idVT),
    foreign key (don_dat_hang_idDH) references don_dat_hang(idDH)
);
create table chi_tiet_phieu_nhap(
	vat_tu_idVT int,
    phieu_nhap_idPN  int,
    ngay date,
	primary key (vat_tu_idVT, phieu_nhap_idPN),
    foreign key (vat_tu_idVT) references vat_tu(idVT),
    foreign key (phieu_nhap_idPN) references phieu_nhap(idPN)
);
create table chi_tiet_phieu_xuat(
	vat_tu_idVT int,
    phieu_xuat_idPX  int,
    DGXuat double,
    SLXuat int,
    primary key (vat_tu_idVT, phieu_xuat_idPX),
    foreign key (vat_tu_idVT) references vat_tu(idVT),
    foreign key (phieu_xuat_idPX) references phieu_xuat(idPX)
);







