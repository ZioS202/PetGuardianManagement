/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.GUI.Cart.model;

import PetGuardianManagement.DTO.LoaiVeDTO;

/**
 *
 * @author ductt
 */
public class ModelItem {

    private LoaiVeDTO loaiVe;
    private int soLuong;

    public ModelItem() {
    }

    public ModelItem(LoaiVeDTO loaive, int soLuong) {
        this.loaiVe = loaive;
        this.soLuong = soLuong;
    }

    public LoaiVeDTO getLoaiVe() {
        return loaiVe;
    }

    public void setLoaiVe(LoaiVeDTO loaiVe) {
        this.loaiVe = loaiVe;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
