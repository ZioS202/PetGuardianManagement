/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.DTO;

public class ChiTietHoaDonDTO {
 private int iMaHD, iMaLoaiVe;
    private long longSoLuongVe;

    public ChiTietHoaDonDTO() {
    }

    public ChiTietHoaDonDTO(int iMaHD, int iMaLoaiVe, long longSoLuongVe) {
        this.iMaHD = iMaHD;
        this.iMaLoaiVe = iMaLoaiVe;
        this.longSoLuongVe = longSoLuongVe;
    }


    public int getIMaHD() {
        return iMaHD;
    }

    public void setIMaHD(int iMaHD) {
        this.iMaHD = iMaHD;
    }

    public int getIMaLoaiVe() {
        return iMaLoaiVe;
    }

    public void setIMaLoaiVe(int iMaLoaiVe) {
        this.iMaLoaiVe = iMaLoaiVe;
    }

    public long getLongSoLuongVe() {
        return longSoLuongVe;
    }

    public void setLongSoLuongVe(long longSoLuongVe) {
        this.longSoLuongVe = longSoLuongVe;
    }
    
    @Override
    public String toString() {
        return "ChiTietHoaDonDTO{" + "iMaHD=" + iMaHD + ", strMaLoaiVe=" + iMaLoaiVe + ", longSoLuongVe=" + longSoLuongVe + '}';
    }
    
}
