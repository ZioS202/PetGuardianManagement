
drop table nguoidung cascade CONSTRAINTS;
drop table thucung cascade CONSTRAINTS;
drop table khachhang cascade CONSTRAINTS;
drop table c_ve cascade CONSTRAINTS;
drop table loaive cascade CONSTRAINTS;
drop table chitietravao cascade CONSTRAINTS;
drop table chitiethoadon cascade CONSTRAINTS;
drop table hoadon cascade CONSTRAINTS;
drop table giohang cascade CONSTRAINTS;
drop table chitietgiohang cascade CONSTRAINTS;


-- Tao bang NguoiDung
create table NguoiDung (
    MaND Number,
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
    MaThuCung Number,
    TenThuCung varchar2(30),
    GiongLoai varchar2(20),
    CanNang int,
    MaKHSoHuu Number,
    
    CONSTRAINT PK_MaThuCung PRIMARY KEY (MaThuCung)
);



-- Tao bang KhachHang
create table KhachHang (
    MaKH Number,
    SoDu Number,
    
    CONSTRAINT PK_MaKH PRIMARY KEY (MAKH)
);


-- Tao bang LoaiVe
create table LoaiVe(
    MaLoaiVe Number,
    TenLoaiVe varchar2(30),
    GiaVe number,
    
    CONSTRAINT PK_MaLoaiVe PRIMARY KEY (MaLoaiVe)
);



-- Tao bang Ve
create table c_Ve(
    MaVe Number,
    MaLoaiVe Number,
    MaKH Number,
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
    MaKH Number,
    MaThuCung Number,
    CONSTRAINT PK_CTRV PRIMARY KEY (MaKH,MaThuCung)
);


-- Tao bang HoaDon
create table HoaDon(
    MaHD Number,
    MaKH Number,
    NgayHD Date,
    TongGiaTien Number,
    
    CONSTRAINT PK_MaHD PRIMARY KEY (MaHD)
);

-- Tao bang ChiTietHoaDon
create table ChiTietHoaDon(
    MaHD Number,
    MaLoaiVe Number,
    SoLuongVe Number,
    
    CONSTRAINT PK_CTHD PRIMARY KEY (MaHD, MaLoaiVe)
);

--Tao bang GioHang
create table GioHang(
    MaGioHang Number,
    MaKH Number,
    
    CONSTRAINT PK_MaGioHang PRIMARY KEY (MaGioHang)
    );
    
--Tao bang ChiTietGioHang
create table ChiTietGioHang(
    MaGioHang Number,
    MaLoaiVe Number,
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


--auto_ID
--NguoiDung
create sequence NguoiDung_seq
  start with 1
  increment by 1
  nomaxvalue;

create or replace trigger NguoiDung_trigger
  before insert on NguoiDung
  referencing OLD as old NEW as new
  for each row
  begin
      :new.MaND:=NguoiDung_seq.nextval;
  end;  
 / 
 

--C_Ve
create sequence C_Ve_seq
  start with 1
  increment by 1
  nomaxvalue;
  
create or replace trigger C_Ve_trigger
  before insert on C_Ve
  referencing OLD as old NEW as new
  for each row
  begin
      :new.MaVe:=C_Ve_seq.nextval;
  end;  
 / 
 

--LoaiVe
create sequence LoaiVe_seq
  start with 1
  increment by 1
  nomaxvalue;
  
create or replace trigger LoaiVe_trigger
  before insert on LoaiVe
  referencing OLD as old NEW as new
  for each row
  begin
      :new.MaLoaiVe:=LoaiVe_seq.nextval;
  end;  
 / 
 

--HoaDon
create sequence HoaDon_seq
  start with 1
  increment by 1
  nomaxvalue;
  
create or replace trigger HoaDon_trigger
  before insert on HoaDon
  referencing OLD as old NEW as new
  for each row
  begin
      :new.MaHD:=HoaDon_seq.nextval;
  end;  
 / 
 
--GioHang 
 create sequence GioHang_seq
  start with 1
  increment by 1
  nomaxvalue;
  
create or replace trigger GioHang_trigger
  before insert on GioHang
  referencing OLD as old NEW as new
  for each row
  begin
      :new.MaGioHang:=GioHang_seq.nextval;
  end;  
 / 
 
--ThuCung
 create sequence ThuCung_seq
  start with 1
  increment by 1
  nomaxvalue;
  
create or replace trigger ThuCung_trigger
  before insert on ThuCung
  referencing OLD as old NEW as new
  for each row
  begin
      :new.MaThuCung:=ThuCung_seq.nextval;
  end;  
 /
 
--reset sequence
ALTER SEQUENCE NguoiDung_seq RESTART;
ALTER SEQUENCE C_Ve_seq RESTART;
ALTER SEQUENCE LoaiVe_seq RESTART;
ALTER SEQUENCE HoaDon_seq RESTART;
ALTER SEQUENCE GioHang_seq RESTART;
ALTER SEQUENCE ThuCung_seq RESTART;

--Them du lieu
alter session set nls_date_format = 'yyyy-mm-dd hh24:mi:ss';
--IMPORT du lieu tu excel
 
