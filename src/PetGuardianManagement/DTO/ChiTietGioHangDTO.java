/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.DTO;

public class ChiTietGioHangDTO {
    private int iMaGioHang, iMaLoaiVe; 
    private long longSoLuongMua;
    
    public ChiTietGioHangDTO(){
        
    }
    
    public ChiTietGioHangDTO(int iMaGioHang, int iMaLoaiVe, long longSoLuongMua){
        this.iMaGioHang = iMaGioHang;
        this.iMaLoaiVe = iMaLoaiVe;
        this.longSoLuongMua = longSoLuongMua;
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
    
    public long getLongSoLuongMua() {
        return longSoLuongMua;
    }

    public void setLongSoLuongMua(long iSoLuongMua) {
        this.longSoLuongMua = iSoLuongMua;
    }
    
    @Override
    public String toString() {
        return "GioHangDTO{" + "iMaGioHang=" + iMaGioHang + ", iMaLoaiVe=" + iMaLoaiVe + ", longSoLuongMua=" + longSoLuongMua + '}';
    }
}
