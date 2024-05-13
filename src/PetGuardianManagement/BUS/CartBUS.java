/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.BUS;

import PetGuardianManagement.DAO.ChiTietGioHangDAO;
import PetGuardianManagement.DAO.GioHangDAO;
import PetGuardianManagement.DAO.LoaiVeDAO;
import PetGuardianManagement.DTO.ChiTietGioHangDTO;
import PetGuardianManagement.DTO.GioHangDTO;
import PetGuardianManagement.DTO.LoaiVeDTO;
import PetGuardianManagement.GUI.Cart.model.ModelItem;
import java.util.ArrayList;

/**
 *
 * @author ductt
 */
public class CartBUS {

    private ArrayList<ModelItem> lstModelItem;
    private int iMaGioHang;
    private static CartBUS instance;

    private CartBUS() {
        lstModelItem = new ArrayList<>();
        // Check if User already has a shopping cart
        GioHangDTO gioHang = GioHangDAO.getInstance().selectByMaKH(8);
        if (gioHang != null) {
            iMaGioHang = gioHang.getIMaGioHang();
            ArrayList<ChiTietGioHangDTO> lstChiTietGioHang = ChiTietGioHangDAO.getInstance().selectByMaGioHang(iMaGioHang);
            for (ChiTietGioHangDTO item : lstChiTietGioHang) {
                LoaiVeDTO loaiVe = LoaiVeDAO.getInstance().selectByMaLoaiVe(item.getIMaLoaiVe());
                ModelItem modelItem = new ModelItem(loaiVe, item.getISoLuongMua());
                lstModelItem.add(modelItem);
            }
        }
    }

    // Public static method to access the single instance
    public static CartBUS getInstance() {
        if (instance == null) {
            instance = new CartBUS();
        }
        return instance;
    }

    // Update SoLuongMua in ChiTietGioHang table
    public int updateSoLuongMua(ModelItem item) {
        ChiTietGioHangDTO data = new ChiTietGioHangDTO(iMaGioHang, item.getLoaiVe().getIMaLoaiVe(), item.getSoLuong());
        return ChiTietGioHangDAO.getInstance().update(data);
    }

    // Method add ModelItem to lstModelItem
    public int addModelItem(ModelItem data) {
        // Check if data aldready has in lstModelItem
        boolean isExist = false;
        for (ModelItem item : lstModelItem) {
            if (item.getLoaiVe().getIMaLoaiVe() == data.getLoaiVe().getIMaLoaiVe()) {
                isExist = true;
                break;
            }
        }
        // If data doesn't exist, add it to lstModelItem
        if (!isExist) {
            lstModelItem.add(data);
            System.out.println("Added ModelItem successfully.");
            return 1;
        } else {
            System.out.println("The ModelItem already exists. Update it's SoLuongMua instead.");
            return 0;
        }
    }

    // Method get ModelItem at index i in lstModelItem
    public ModelItem getModelItem(int i) {
        if (i >= 0 && i < lstModelItem.size()) {
            return lstModelItem.get(i);
        } else {
            System.out.println("Invalid index.");
            return null;
        }
    }

    // Method update ModelItem in lstModelItem, need to known iMaLoaiVe
    public int updateModelItem(ModelItem data) {
        for (ModelItem item : lstModelItem) {
            if (item.getLoaiVe().getIMaLoaiVe() == data.getLoaiVe().getIMaLoaiVe()) {
                item.setSoLuong(data.getSoLuong());
                System.out.println("Updated ModelItem successfully.");
                return 1;
            }
        }
        System.out.println("ModelItem that have iMaLoaiVe=" + data.getLoaiVe().getIMaLoaiVe() + " not found.");
        return 0;
    }

    // Method delete ModelItem from lstModelItem, need to known iMaLoaiVe
    public int deleteModelItem(int iMaLoaiVe) {
        for (ModelItem item : lstModelItem) {
            if (item.getLoaiVe().getIMaLoaiVe() == iMaLoaiVe) {
                lstModelItem.remove(item);
                System.out.println("Deleted ModelItem successfully.");
                return 1;
            }
        }
        System.out.println("ModelItem that have iMaLoaiVe=" + iMaLoaiVe + " not found.");
        return 0;
    }

    // Method get size of lstLoaiVe
    public int getLstModelItemSize() {
        return lstModelItem.size();
    }

    // Method search ModelItem in lstModelItem need to known iMaLoaiVe
    public ModelItem searchModelItem(int iMaLoaiVe) {
        for (ModelItem item : lstModelItem) {
            if (item.getLoaiVe().getIMaLoaiVe() == iMaLoaiVe) {
                return item;
            }
        }
        System.out.println("ModelItem that have iMaLoaiVe=" + iMaLoaiVe + " not found.");
        return null;
    }
}
