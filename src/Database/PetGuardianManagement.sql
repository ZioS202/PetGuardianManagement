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

--Them du lieu
alter session set nls_date_format = 'yyyy-mm-dd hh24:mi:ss';

-- IMPORT du lieu tu excel


--Trigger

--Check_SoDu_trigger
create or replace trigger Check_SoDu_trigger
before insert or update on KhachHang 
for each row
begin
    if (:new.SoDu < 0) then
        raise_application_error(-20001, 'So du phai lon hon hoac bang không 0');
    end if;
end;

--ThuCung_trigger
create or replace trigger Check_CanNang_trigger
before insert or update on ThuCung
for each row
begin
    if(:NEW.CanNang < 0) then
        raise_application_error(-20001, 'Can nang cua thu cung phai lon hon 0');
    end if;
end;

-- Check_GiaVe_trigger
create or replace trigger Check_GiaVe_trigger
before insert or update on LoaiVe
for each row
begin
    if (:new.GiaVe < 0) then
        raise_application_error(-20002, 'Gia ve phai lon hon hoac bang không 0');
    end if;
end;


--NgayHetHan_trigger
create or replace trigger Check_NgayHetHan_trigger 
before insert or update on c_Ve 
for each row
begin
    if (:new.NgayHetHan < :new.NgayMua) then
        raise_application_error(-20003, 'Ngay het han phai lon hon hoac bang ngay mua ve');
    end if;
end;


--Check_ThoiGianVaoRa_trigger
create or replace trigger Check_ThoiGianVaoRa_trigger
before insert or update on ChiTietRaVao
for each row
begin
    if ( to_char(:new.ThoiGianRa,'dd-mm-yyyy') = to_char(:new.ThoiGianVao,'dd-mm-yyyy') and to_char(:new.ThoiGianRa,'HH24') = to_char(:new.ThoiGianVao,'HH24') and  to_char(:new.ThoiGianRa,'MI') = to_char(:new.ThoiGianVao,'MI') AND to_char(:new.ThoiGianRa,'SS') - to_char(:new.ThoiGianVao,'SS') < 30 ) then
        raise_application_error(-20004, 'Thoi gian ra phai lon hon thoi gian vao it nhat 30s');
    end if;
end;

-- Check_SoLuongVe_trigger
create or replace trigger Check_SoLuongVe_trigger
before insert or update on ChiTietHoaDon
for each row
begin
    if (:new.SoLuongVe < 0) then
        raise_application_error(-20004, 'So luong ve phai lon hon hoac bang không 0');
    end if;
end;

-- Check_SoLuongMua_trigger
create or replace trigger Check_SoLuongMua_trigger
before insert or update on ChiTietGioHang
for each row
begin
    if (:new.SoLuongMua < 0) then
        raise_application_error(-20004, 'So luong ve mua phai lon hon hoac bang không 0');
    end if;
end;

-- Check_TongGiaTien_trigger
create or replace trigger Check_TongGiaTien_trigger
before insert or update on HoaDon
for each row
begin
    if (:new.TongGiaTien < 0) then
        raise_application_error(-20004, 'Tong gia tien cua hoa don phai lon hon hoac bang không 0');
    end if;
end;

--Procedure
--CAP NHAT GIA VE
create or replace procedure CapNhat_GiaVe(i_MaLoaiVe LoaiVe.MaLoaiVe%type, i_GiaVe LoaiVe.GiaVe%type)
is
PRAGMA AUTONOMOUS_TRANSACTION;
    l_MaLoaiVe varchar2(5);
begin
    select MaLoaiVe into l_MaLoaiVe
    from LoaiVe
    where MaLoaiVe = i_MaLoaiVe;
    if l_MaLoaiVe is null then
        dbms_output.put_line('MaLoaiVe khong ton tai');
    else
        update LoaiVe
        set GiaVe = i_GiaVe
        where MaLoaiVe = i_MaLoaiVe;
    end if;
    exception when no_Data_found then
    dbms_output.put_line('MaLoaiVe khong ton tai');
end;

--CAP NHAT LOAI VE
create or replace procedure CapNhat_LoaiVe(i_MaLoaiVe LoaiVe.MaLoaiVe%type, i_TenLoaiVe LoaiVe.TenLoaiVe%type, i_GiaVe LoaiVe.GiaVe%type)
is
    l_MaLoaiVe varchar2(5);
begin
    select MaLoaiVe into l_MaLoaiVe
    from LoaiVe
    where MaLoaiVe = i_MaLoaiVe;
    if l_MaLoaiVe is null then
        dbms_output.put_line('MaLoaiVe khong ton tai');
    else
        update LoaiVe
        set TenLoaiVe = i_TenLoaiVe, GiaVe = i_GiaVe
        where MaLoaiVe = i_MaLoaiVe;
    end if;
    exception when no_Data_found then
    dbms_output.put_line('MaLoaiVe khong ton tai');
end;

-- CAP NHAT NGUOI DUNG
create or replace procedure CapNhat_NguoiDung(i_MaND NguoiDung.MaND%type, i_Email NguoiDung.Email%type, i_MatKhau NguoiDung.MatKhau%type, i_HoTen NguoiDung.HoTen%type, i_GioiTinh NguoiDung.GioiTinh%type, i_NgSinh NguoiDung.NgSinh%type, i_DiaChi NguoiDung.DiaChi%type, i_QueQuan NguoiDung.QueQuan%type, i_SDT NguoiDung.SDT%type)
is
    l_MaND varchar2(5);
begin
    select MaND into l_MaND
    from NguoiDung
    where MaND = i_MaND;
    if l_MaND is null then
        dbms_output.put_line('MaND khong ton tai');
    else
        update NguoiDung
        set Email = i_Email, MatKhau = i_MatKhau, HoTen = i_HoTen, GioiTinh = i_GioiTinh, NgSinh = i_NgSinh, DiaChi = i_DiaChi, QueQuan = i_QueQuan, SDT = i_SDT
        where MaND = i_MaND;
    end if;
    exception when no_Data_found then
    dbms_output.put_line('MaND khong ton tai');
end;

-- CAP NHAT NHAN VIEN
create or replace procedure CapNhat_NhanVien(i_MaNV NhanVien.Manv%type, i_ViTriNhanVien NhanVien.ViTriNhanVien%type)
is
    l_MaNV varchar2(5);
begin
    select Manv into l_MaNV
    from NhanVien
    where Manv = i_MaNV;
    if l_MaNV is null then
        dbms_output.put_line('MaNV khong ton tai');
    else
        update NhanVien
        set ViTriNhanVien = i_ViTriNhanVien
        where Manv = i_MaNV;
    end if;
    exception when no_Data_found then
    dbms_output.put_line('MaNV khong ton tai');
end;

--CAP NHAT THU CUNG
create or replace procedure CapNhat_ThuCung(i_MaThuCung ThuCung.MaThuCung%type, i_TenThuCung ThuCung.TenThuCung%type, i_GiongLoai ThuCung.GiongLoai%type, i_CanNang ThuCung.CanNang%type)
is
    l_MaThuCung varchar2(5);
begin
    select MaThuCung into l_MaThuCung
    from ThuCung
    where MaThuCung = i_MaThuCung;
    if l_MaThuCung is null then
        dbms_output.put_line('MaThuCung khong ton tai');
    else
        update ThuCung
        set TenThuCung = i_TenThuCung, GiongLoai = i_GiongLoai, CanNang = i_CanNang
        where MaThuCung = i_MaThuCung;
    end if;
    exception when no_Data_found then
    dbms_output.put_line('MaThuCung khong ton tai');
end;

-- KIEM TRA VE HET HAN
create or replace procedure check_Ve_HetHan
as
    l_NgayHetHan date;

    Cursor List_id is
    select * 
    from C_Ve;

begin
    for l_Ve in list_id loop

        select NgayHetHan into l_NgayHetHan
        from c_Ve
        where MaVe =l_Ve.MaVe;
        if to_char(sysdate,'dd/mm/yyyy') > to_char(l_NgayHetHan,'dd/mm/yyyy') then
            update c_Ve
            set TrangThai = 'Da het han'
             where MaVe =l_Ve.MaVe;
        end if;
    end loop;
end;

--NAP TIEN
create or replace procedure NapTien(i_MaKH KhachHang.MaKH%type, i_SoDu KhachHang.SoDu%type)
is
    l_MaKH varchar2(5);
begin
    select MaKH into l_MaKH
    from KhachHang
    where MaKH = i_MaKH;
    if l_MaKH is null then
        dbms_output.put_line('MaKH khong ton tai');
    else
        update KhachHang
        set SoDu = SoDu + i_SoDu
        where MaKH = i_MaKH;
    end if;
    exception when no_Data_found then
    dbms_output.put_line('MaKH khong ton tai');
end;

-- THEM KHACH HANG
create or replace procedure Them_KhachHang(i_MaKH KhachHang.MaKH%type)
is
    l_MaKH varchar2(5);
begin
    insert into KhachHang values(i_MaKH, 0);
    exception when no_Data_found then
    dbms_output.put_line('Them khong thanh cong');
end;

--THEM LOAI VE
create or replace procedure Them_LoaiVe(i_MaLoaiVe LoaiVe.MaLoaiVe%type, i_TenLoaiVe LoaiVe.TenLoaiVe%type, i_GiaVe LoaiVe.GiaVe%type)
is
    l_MaLoaiVe varchar2(5); 
begin
    insert into LoaiVe values(i_MaLoaiVe, i_TenLoaiVe, i_GiaVe);
    exception when no_Data_found then
    dbms_output.put_line('Them khong thanh cong');
end;

-- THEM NGUOI DUNG
create or replace procedure Them_NguoiDung(i_Id NguoiDung.MaND%type, i_Email NguoiDung.Email%type, i_MatKhau NguoiDung.MatKhau%type, i_HoTen NguoiDung.HoTen%type, i_VaiTro NguoiDung.VaiTro%type)
is
l_id varchar2(5);
l_numid number;
    l_maMaxND varchar2(5);
begin
        insert into NguoiDung values(i_Id, i_Email,i_MatKhau,i_HoTen,'','','','','', i_VaiTro);
    exception 
    when no_Data_found then
    dbms_output.put_line('Them khong thanh cong');
end;

--THEM NHAN VIEN 
create or replace procedure Them_NhanVien(i_MaNV NhanVien.Manv%type, i_ViTriNhanVien NhanVien.ViTriNhanVien%type)
is
    l_MaNV varchar2(5);
begin
    insert into NhanVien values(i_MaNV, i_ViTriNhanVien);
    exception when no_Data_found then
    dbms_output.put_line('Them khong thanh cong');
end;

--THEM THU CUNG
create or replace procedure Them_ThuCung(i_MaThuCung ThuCung.MaThuCung%type, i_TenThuCung ThuCung.TenThuCung%type, i_GiongLoai ThuCung.GiongLoai%type, i_CanNang ThuCung.CanNang%type, i_MaKHSoHuu ThuCung.MaKHSoHuu%type)
is
    l_MaThuCung varchar2(5);
begin
    insert into ThuCung values(i_MaThuCung, i_TenThuCung, i_GiongLoai, i_CanNang, i_MaKHSoHuu);
    exception when no_Data_found then
    dbms_output.put_line('Them khong thanh cong');
end;

--THEM GIO HANG
create or replace procedure Them_GioHang(i_MaGioHang GioHang.MaGioHang%type,i_MaKH GioHang.MaKH%type)
is
    l_MaGioHang varchar2(5);
begin
    insert into GioHang values(i_MaGioHang, i_MaKH);
    exception when no_Data_found then
    dbms_output.put_line('Them khong thanh cong');
end;

--XOA LOAI VE
create or replace procedure Xoa_LoaiVe(i_MaLoaiVe LoaiVe.MaLoaiVe%type)
is
    l_MaLoaiVe varchar2(5);
begin
    select MaLoaiVe into l_MaLoaiVe
    from LoaiVe
    where MaLoaiVe = i_MaLoaiVe;
    if l_MaLoaiVe is null then
        dbms_output.put_line('MaLoaiVe khong ton tai');
    else
        delete from LoaiVe
        where MaLoaiVe = i_MaLoaiVe;
    end if;
    exception when no_Data_found then
    dbms_output.put_line('MaLoaiVe khong ton tai');
end;

-- XOA NGUOI DUNG
create or replace procedure Xoa_NguoiDung(i_MaND NguoiDung.MaND%type)   
is
    l_MaND varchar2(5);
begin
    select MaND into l_MaND
    from NguoiDung
    where MaND = i_MaND;
    if l_MaND is null then
        dbms_output.put_line('MaND khong ton tai');
    else
        delete from NguoiDung
        where MaND = i_MaND;
    end if;
    exception when no_Data_found then
    dbms_output.put_line('MaND khong ton tai');
end;

-- XOA THU CUNG
create or replace procedure Xoa_ThuCung(i_MaThuCung ThuCung.MaThuCung%type)
is
    l_MaThuCung varchar2(5);
begin
    select MaThuCung into l_MaThuCung
    from ThuCung
    where MaThuCung = i_MaThuCung;
    if l_MaThuCung is null then
        dbms_output.put_line('MaThuCung khong ton tai');
    else
        delete from ThuCung
        where MaThuCung = i_MaThuCung;
    end if;
    exception when no_Data_found then
    dbms_output.put_line('MaThuCung khong ton tai');
end;

--XOA GIO HANG
create or replace procedure Xoa_GioHang(i_MaGioHang GioHang.MaGioHang%type)
is
    l_MaGioHang varchar2(5);
begin
    select MaGioHang into l_MaGioHang
    from GioHang
    where MaGioHang = i_MaGioHang;
    if l_MaGioHang is null then
        dbms_output.put_line('MaGioHang khong ton tai');
    else
        delete from GioHang
        where MaGioHang = i_MaGioHang;
    end if;
    exception when no_Data_found then
    dbms_output.put_line('MaGioHang khong ton tai');
end;

-- FUNCTION
-- kiem tra khach hang co dang gui thu cung hay khong
create or replace function check_MaKH_dangguithucung(i_MaKH Khachhang.MaKH%type)
return number is l_MaKH varchar2(5);

begin 
    select KH.MaKH into l_MaKH
    from KhachHang KH, ThuCung TC
    where KH.MaKH = TC.MaKHSoHuu
        and KH.MaKH = i_MaKH;
    if l_MaKH is null then
        return 0;
    else 
        return 1;
    end if;
    exception when no_data_found then
        DBMS_output.put_line('MaKH khong ton tai!');
        return null;
end;

-- tinh doanh thu theo ngay
create or replace function DoanhThu_TheoNgay(p_NgayHD Date )
return number
is DoanhThu HoaDon.TongGiaTien%type :=0;
begin
    select sum(TongGiaTien) into DoanhThu
    from HoaDon HD join ChiTietHoaDon CTHD on HD.MaHD = CTHD.MaHD
    where HD.NgayHD = p_NgayHD;
    if DoanhThu > 0 then 
        return DoanhThu;
    end if;
    exception when no_data_found then
        dbms_output.put_line('Khong co ngay phu hop!');
        return null;
end;

-- So luong thu cung ra theo ngay
create or replace function SoLuongThuCungRa_TheoNgay(p_NgayHD Date)
return number
as SoLuongThuCungRa number;
   begin
    select count(MaThuCung) into SoLuongThuCungRa
    from ChiTietRaVao CTRV 
    where CTRV.ThoiGianRa = p_NgayHD;
    return SoLuongThuCungRa;
    exception when no_Data_found then
    dbms_output.put_line('Thong tin nhap khong hop le!');
    return null;
end;

--so luong thu cung vao theo ngay
create or replace function SoLuongThuCungVao_TheoNgay(p_NgayHD Date)
return number
as SoLuongThuCungVao number;
begin
    select count(MaThuCung) into SoLuongThuCungVao
    from ChiTietRaVao CTRV 
    where CTRV.ThoiGianVao = p_NgayHD;
    return SoLuongThuCungVao;
    exception when no_Data_found then
    dbms_output.put_line('Thong tin nhap khong hop le!');
    return null;
end;

