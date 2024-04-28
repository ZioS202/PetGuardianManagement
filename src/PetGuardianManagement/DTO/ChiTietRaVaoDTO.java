/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.DTO;

import java.util.Date;

public class ChiTietRaVaoDTO {
    int iMaKH, iMaThuCung;
    Date dateThoiGianVao, dateThoiGianRa;

    public ChiTietRaVaoDTO() {
    }
    
    public ChiTietRaVaoDTO(Date dateThoiGianVao, Date dateThoiGianRa, String strMaNV, int iMaKH, int iMaThuCung) {
        this.dateThoiGianVao = dateThoiGianVao;
        this.dateThoiGianRa = dateThoiGianRa;
        this.iMaKH = iMaKH;
        this.iMaThuCung = iMaThuCung;
    }


    public Date getDateThoiGianVao() {
        return dateThoiGianVao;
    }

    public void setDateThoiGianVao(Date dateThoiGianVao) {
        this.dateThoiGianVao = dateThoiGianVao;
    }

    public Date getDateThoiGianRa() {
        return dateThoiGianRa;
    }

    public void setDateThoiGianRa(Date dateThoiGianRa) {
        this.dateThoiGianRa = dateThoiGianRa;
    }

    public int getIMaKH() {
        return iMaKH;
    }

    public void setIMaKH(int iMaKH) {
        this.iMaKH = iMaKH;
    }

    public int getIMaThuCung() {
        return iMaThuCung;
    }

    public void setIMaThuCung(int iMaThuCung) {
        this.iMaThuCung = iMaThuCung;
    }

    @Override
    public String toString() {
        return "ChiTietRaVaoDTO{" + ", dateThoiGianVao=" + dateThoiGianVao + ", dateThoiGianRa=" + dateThoiGianRa + ", iMaKH=" + iMaKH + ", iMaThuCung=" + iMaThuCung + '}';
    }

}
