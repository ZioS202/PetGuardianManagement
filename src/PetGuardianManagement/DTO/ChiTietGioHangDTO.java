/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.DTO;

public class ChiTietGioHangDTO {

    private int iMaGioHang, iMaLoaiVe;
    private int iSoLuongMua;

    public ChiTietGioHangDTO() {

    }

    public ChiTietGioHangDTO(int iMaGioHang, int iMaLoaiVe, int iSoLuongMua) {
        this.iMaGioHang = iMaGioHang;
        this.iMaLoaiVe = iMaLoaiVe;
        this.iSoLuongMua = iSoLuongMua;
    }

    public int getIMaGioHang() {
        return iMaGioHang;
    }

    public void setIMaGioHang(int iMaGioHang) {
        this.iMaGioHang = iMaGioHang;
    }

    public int getIMaLoaiVe() {
        return iMaLoaiVe;
    }

    public void setIMaLoaiVe(int iMaLoaiVe) {
        this.iMaLoaiVe = iMaLoaiVe;
    }

    public int getISoLuongMua() {
        return iSoLuongMua;
    }

    public void setISoLuongMua(int iSoLuongMua) {
        this.iSoLuongMua = iSoLuongMua;
    }

    @Override
    public String toString() {
        return "GioHangDTO{" + "iMaGioHang=" + iMaGioHang + ", iMaLoaiVe=" + iMaLoaiVe + ", iSoLuongMua=" + iSoLuongMua + '}';
    }
}
