/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.DTO;

public class ThuCungDTO {
    private int iMaThuCung, iMaKHSoHuu;
    private float fCanNang;
    private String strTenThuCung, strGiongLoai;
    
    public ThuCungDTO(){
        
    }
    
    public ThuCungDTO(int iMaThuCung, float fCanNang, int iMaKHSoHuu, String strTenThuCung, String strGiongLoai){
        this.iMaThuCung = iMaThuCung;
        this.strTenThuCung = strTenThuCung;
        this.strGiongLoai = strGiongLoai;
        this.fCanNang = fCanNang;
        this.iMaKHSoHuu = iMaKHSoHuu;
    }
    
 
    public int getIMaThuCung() {
        return iMaThuCung;
    }
    
    public void setIMaThuCung(int iMaThuCung) {
        this.iMaThuCung = iMaThuCung;
    }
    
    public float getFCanNang() {
        return fCanNang;
    }

    public void setFCanNang(float fCanNang) {
        this.fCanNang = fCanNang;
    }
    
    public int getIMaKHSoHuu() {
        return iMaKHSoHuu;
    }

    public void setIMaKHSoHuu(int iMaKHSoHuu) {
        this.iMaThuCung = iMaKHSoHuu;
    }
    
    public String getStrTenThuCung() {
        return strTenThuCung;
    }

    public void setStrTenThuCung(String strTenThuCung) {
        this.strTenThuCung = strTenThuCung;
    }
    
    public String getStrGiongLoai() {
        return strGiongLoai;
    }

    public void setStrGiongLoai(String strGiongLoai) {
        this.strGiongLoai = strGiongLoai;
    }
    
     @Override
    public String toString() {
        return "ThuCungDTO{" + "iMaThuCung=" + iMaThuCung + ", strTenThuCung=" + strTenThuCung + ", strGiongLoai=" + strGiongLoai + "fCanNang=" + fCanNang + "iMaKHSoHuu=" + iMaKHSoHuu + '}';
    }
}
