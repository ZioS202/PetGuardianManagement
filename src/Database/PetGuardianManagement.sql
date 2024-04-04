/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  DucTran
 * Created: 4 Apr 2024
 */

--drop table nguoidung cascade CONSTRAINTS;
--drop table thucung cascade CONSTRAINTS;
--drop table nhanvien cascade CONSTRAINTS;
--drop table khachhang cascade CONSTRAINTS;
--drop table c_ve cascade CONSTRAINTS;
--drop table loaive cascade CONSTRAINTS;
--drop table chitietravao cascade CONSTRAINTS;
--drop table chitiethoadon cascade CONSTRAINTS;
--drop table hoadon cascade CONSTRAINTS;
--drop table giohang cascade CONSTRAINTS;
--drop table chitietgiohang cascade CONSTRAINTS;
--

-- Tao bang NguoiDung
create table NguoiDung (
    MaND varchar2(5),
    Email varchar2(32) not null,
    MatKhau varchar2(64) not null,
    HoTen varchar2(50),
    GioiTinh varchar2(3),
    NgSinh Date,
    DiaChi varchar2(256),
    QueQuan varchar2(256),
    SDT varchar2(10),
    VaiTro varchar2(10),

    CONSTRAINT PK_MaND PRIMARY KEY (MaND),   
   
    CONSTRAINT check_GioiTinh CHECK (GioiTinh = 'Nam' or GioiTinh = 'Nu'),
    CONSTRAINT check_VaiTro CHECK (VaiTro ='Khach hang' or VaiTro = 'Nhan vien')
);


-- Tao bang ThuCung
create table ThuCung (
    MaThuCung varchar2(5),
    TenThuCung varchar2(30),
    GiongLoai varchar2(20),
    CanNang int,
    MaKHSoHuu varchar2(5),
    
    CONSTRAINT PK_MaThuCung PRIMARY KEY (MaThuCung)
);

-- Tao bang NhanVien
create table NhanVien  (
    MaNV varchar2(5),
    ViTriNhanVien varchar2(30),
    
    CONSTRAINT PK_MaNV PRIMARY KEY (MaNV),
    CONSTRAINT check_ViTriNhanVien CHECK (ViTriNhanVien in ('Quan ly', 'Bao ve'))
);


-- Tao bang KhachHang
create table KhachHang (
    MaKH varchar2(5),
    SoDu Number,
    
    CONSTRAINT PK_MaKH PRIMARY KEY (MAKH)
);


-- Tao bang LoaiVe
create table LoaiVe(
    MaLoaiVe varchar2(5),
    TenLoaiVe varchar2(30),
    GiaVe number,
    
    CONSTRAINT PK_MaLoaiVe PRIMARY KEY (MaLoaiVe)
);



-- Tao bang Ve
create table c_Ve(
    MaVe varchar2(5),
    MaLoaiVe varchar2(5),
    MaKH varchar2(5),
    NgayMua Date,
    NgayHetHan Date,
    TrangThai Varchar(30),
    
    CONSTRAINT PK_MaVe PRIMARY KEY (MaVe),
    CONSTRAINT check_TrangThai CHECK (TrangThai in ('Dang su dung', 'Da het han'))
);



-- Tao bang ChiTietRaVao
create table ChiTietRaVao(
    ThoiGianVao Date,
    ThoiGianRa Date,
    MaKH varchar2(5),
    MaThuCung varchar2(5),
    CONSTRAINT PK_CTRV PRIMARY KEY (MaKH,MaThuCung)
);


-- Tao bang HoaDon
create table HoaDon(
    MaHD varchar2(5),
    MaKH Varchar2(5),
    NgayHD Date,
    TongGiaTien Number,
    
    CONSTRAINT PK_MaHD PRIMARY KEY (MaHD)
);

-- Tao bang ChiTietHoaDon
create table ChiTietHoaDon(
    MaHD varchar2(5),
    MaLoaiVe varchar2(5),
    SoLuongVe Number,
    
    CONSTRAINT PK_CTHD PRIMARY KEY (MaHD, MaLoaiVe)
);

--Tao bang GioHang
create table GioHang(
    MaGioHang varchar2(5),
    MaKH varchar2(5),
    
    CONSTRAINT PK_MaGioHang PRIMARY KEY (MaGioHang)
    );
    
--Tao bang ChiTietGioHang
create table ChiTietGioHang(
    MaGioHang varchar2(5),
    MaLoaiVe varchar2(5),
    SoLuongMua int,
    
    CONSTRAINT PK_ChiTietGioHang PRIMARY KEY (MaGioHang,MaLoaiVe)
    );
    
-- Tao khoa ngoai

-- FK CUA NhanVien
ALTER TABLE NhanVien ADD CONSTRAINT FK_NhanVien_MaNV FOREIGN KEY(MaNV) REFERENCES NguoiDung(MaND);
    
-- FK CUA KhachHang
ALTER TABLE KhachHang ADD CONSTRAINT FK_KhachHang_MaKH FOREIGN KEY(MaKH) REFERENCES NguoiDung(MaND);

-- FK CUA c_Ve 
ALTER TABLE c_Ve ADD CONSTRAINT FK_c_Ve_MaLoaiVe FOREIGN KEY(MaLoaiVe) REFERENCES LoaiVe(MaLoaiVe);
ALTER TABLE c_Ve ADD CONSTRAINT FK_c_Ve_MaKH FOREIGN KEY(MaKH) REFERENCES KhachHang(MaKH);

-- FK CUA ChiTietRaVao
ALTER TABLE ChiTietRaVao ADD CONSTRAINT FK_CTRaVao_MaKH FOREIGN KEY(MaKH) REFERENCES KhachHang(MaKH);
ALTER TABLE ChiTietRaVao ADD CONSTRAINT FK_CTRaVao_MaThuCung FOREIGN KEY(MaThuCung) REFERENCES ThuCung(MaThuCung);

-- FK CUA ThuCung
ALTER TABLE ThuCung ADD CONSTRAINT FK_ThuCung_KhachHang FOREIGN KEY(MaKHSoHuu) REFERENCES KhachHang(MaKH);

-- FK CUA ChiTietHoaDon
ALTER TABLE ChiTietHoaDon ADD CONSTRAINT FK_CTHD_MaHD FOREIGN KEY(MaHD) REFERENCES HoaDon(MaHD);
ALTER TABLE ChiTietHoaDon ADD CONSTRAINT FK_CTHD_MaLoaiVe FOREIGN KEY(MaLoaive) REFERENCES LoaiVe(MaLoaiVe);

-- FK CUA HoaDonMuaVe
ALTER TABLE HoaDon ADD CONSTRAINT FK_HoaDon_MaKH FOREIGN KEY(MaKH) REFERENCES KhachHang(MaKH);

-- FK CUA GioHang
ALTER TABLE GioHang ADD CONSTRAINT FK_GioHang_KhachHang FOREIGN KEY(MaKH) REFERENCES KhachHang(MaKH);

--FK CUA ChiTietGioHang
ALTER TABLE ChiTietGioHang ADD CONSTRAINT FK_ChiTietGioHang_GioHang FOREIGN KEY(MaGioHang) REFERENCES GioHang(MaGioHang);
ALTER TABLE ChiTietGioHang ADD CONSTRAINT FK_ChiTietGioHang_LoaiVe FOREIGN KEY(MaLoaiVe) REFERENCES LoaiVe(MaLoaiVe);
