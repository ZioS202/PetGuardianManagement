/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.DTO;

public class GioHangDTO {
    private int iMaGioHang, iMaKH;
    
    public GioHangDTO(){
        
    }
    
    public GioHangDTO(int iMaGioHang, int iMaKH) {
        this.iMaGioHang = iMaGioHang;
        this.iMaKH = iMaKH;
    }
    
    public int getIMaGioHang() {
        return iMaGioHang;
    }

    public void setIMaGioHang(int iMaGioHang) {
        this.iMaGioHang = iMaGioHang;
    }

    public int getIMaKH() {
        return iMaKH;
    }

    public void setIMaKH(int iMaKH) {
        this.iMaKH = iMaKH;
    }
    
    @Override
    public String toString() {
        return "GioHangDTO{" + "iMaGioHang=" + iMaGioHang + ", iMaKH=" + iMaKH + '}';
    }
    
}
