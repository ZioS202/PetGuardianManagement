package PetGuardianManagement.DTO;

import java.util.Date;

public class VeDTO {

    private int iMaVe, iMaLoaiVe, iMaKH;
    private Date dateNgayKichHoat;
    private Date dateNgayHetHan;
    private String strTrangThai;

    public VeDTO() {
    }

    public VeDTO(int iMaVe, int iMaLoaiVe, int iMaKH, Date dateNgayKichHoat, Date dateNgayHetHan, String strTrangThai) {
        this.iMaVe = iMaVe;
        this.iMaLoaiVe = iMaLoaiVe;
        this.iMaKH = iMaKH;
        this.dateNgayKichHoat = dateNgayKichHoat;
        this.dateNgayHetHan = dateNgayHetHan;
        this.strTrangThai = strTrangThai;
    }

    public int getIMaVe() {
        return iMaVe;
    }

    public void setIMaVe(int strMaVe) {
        this.iMaVe = strMaVe;
    }

    public int getIMaLoaiVe() {
        return iMaLoaiVe;
    }

    public void setIMaLoaiVe(int iMaLoaiVe) {
        this.iMaLoaiVe = iMaLoaiVe;
    }

    public int getIMaKH() {
        return iMaKH;
    }

    public void setIMaKH(int iMaKH) {
        this.iMaKH = iMaKH;
    }

    public Date getdateNgayKichHoat() {
        return dateNgayKichHoat;
    }

    public void setdateNgayKichHoat(Date dateNgayKichHoat) {
        this.dateNgayKichHoat = dateNgayKichHoat;
    }

    public Date getDateNgayHetHan() {
        return dateNgayHetHan;
    }

    public void setDateNgayHetHan(Date dateNgayHetHan) {
        this.dateNgayHetHan = dateNgayHetHan;
    }

    public String getStrTrangThai() {
        return strTrangThai;
    }

    public void setStrTrangThai(String strTrangThai) {
        this.strTrangThai = strTrangThai;
    }

    @Override
    public String toString() {
        return "VeDTO{" + "iMaVe=" + iMaVe + ", iMaLoaiVe=" + iMaLoaiVe + ", iMaKH=" + iMaKH + ", dateNgayKichHoat=" + dateNgayKichHoat + ", dateNgayHetHan=" + dateNgayHetHan + ", strTrangThai=" + strTrangThai + '}';
    }

}
