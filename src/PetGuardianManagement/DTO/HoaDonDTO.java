/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.DTO;

import java.util.Date;

public class HoaDonDTO {
    private int iMaHD, iMaKH;
    private Date dateNgayHD;
    private long longTongTriGia;

    public HoaDonDTO() {
    }

    public HoaDonDTO(int iMaHD, int iMaKH, Date dateNgayHD, long longTongTriGia) {
        this.iMaHD = iMaHD;
        this.iMaKH = iMaKH;
        this.dateNgayHD = dateNgayHD;
        this.longTongTriGia = longTongTriGia;
    }


    public int getIMaHD() {
        return iMaHD;
    }

    public void setIMaHD(int iMaHD) {
        this.iMaHD = iMaHD;
    }

    public int getIMaKH() {
        return iMaKH;
    }

    public void setIMaKH(int iMaKH) {
        this.iMaKH = iMaKH;
    }

    public Date getDateNgayHD() {
        return dateNgayHD;
    }

    public void setDateNgayHD(Date dateNgayHD) {
        this.dateNgayHD = dateNgayHD;
    }

    public long getLongTongTriGia() {
        return longTongTriGia;
    }

    public void setLongTongTriGia(long longTongTriGia) {
        this.longTongTriGia = longTongTriGia;
    }

    @Override
    public String toString() {
        return "HoaDonDTO{" + "iMaHD=" + iMaHD + ", iMaKH=" + iMaKH + ", dateNgayHD=" + dateNgayHD + ", longTongTriGia=" + longTongTriGia + '}';
    }
    
}