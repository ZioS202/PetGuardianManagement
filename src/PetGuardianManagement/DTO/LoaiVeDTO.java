/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.DTO;

public class LoaiVeDTO {

    private int iMaLoaiVe;
    private String strTenLoaiVe;
    private long lGiaVe;

    public LoaiVeDTO() {
    }

    public LoaiVeDTO(int iMaLoaiVe, String strTenLoaiVe, long lGiaVe) {
        this.iMaLoaiVe = iMaLoaiVe;
        this.strTenLoaiVe = strTenLoaiVe;
        this.lGiaVe = lGiaVe;
    }

    public int getIMaLoaiVe() {
        return iMaLoaiVe;
    }

    public void setIMaLoaiVe(int iMaLoaiVe) {
        this.iMaLoaiVe = iMaLoaiVe;
    }

    public String getStrTenLoaiVe() {
        return strTenLoaiVe;
    }

    public void setStrTenLoaiVe(String strTenLoaiVe) {
        this.strTenLoaiVe = strTenLoaiVe;
    }

    public long getLGiaVe() {
        return lGiaVe;
    }

    public void setLGiaVe(long lGiaVe) {
        this.lGiaVe = lGiaVe;
    }

    @Override
    public String toString() {
        return "LoaiVeDTO{" + "iMaLoaiVe=" + iMaLoaiVe + ", strTenLoaiVe=" + strTenLoaiVe + ", lGiaVe=" + lGiaVe + '}';
    }
}
