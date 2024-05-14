/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.BUS;

import PetGuardianManagement.DAO.ChiTietGioHangDAO;
import PetGuardianManagement.DAO.ChiTietHoaDonDAO;
import PetGuardianManagement.DAO.GioHangDAO;
import PetGuardianManagement.DAO.HoaDonDAO;
import PetGuardianManagement.DAO.KhachHangDAO;
import PetGuardianManagement.DAO.LoaiVeDAO;
import PetGuardianManagement.DAO.VeDAO;
import PetGuardianManagement.DTO.ChiTietGioHangDTO;
import PetGuardianManagement.DTO.ChiTietHoaDonDTO;
import PetGuardianManagement.DTO.GioHangDTO;
import PetGuardianManagement.DTO.HoaDonDTO;
import PetGuardianManagement.DTO.KhachHangDTO;
import PetGuardianManagement.DTO.LoaiVeDTO;
import PetGuardianManagement.DTO.VeDTO;
import PetGuardianManagement.GUI.Cart.model.ModelItem;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ductt
 */
public class CartBUS {

    private ArrayList<ModelItem> lstModelItem;
    public int iMaGioHang;
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

    // Get SoDu of KhachHang
    public long getSoDuKhachHang() {
        return KhachHangDAO.getInstance().selectById(8).getLongSoDu();
    }

    // Update SoDu of KhachHang
    public int updateSoDuKhachHang(long newSoDu) {
        return KhachHangDAO.getInstance().update(new KhachHangDTO(8, newSoDu));
    }

    // Delete ChiTietGioHang
    public int deleteChiTietGioHang(int iMaLoaiVe) {
        return ChiTietGioHangDAO.getInstance().delete(iMaGioHang, iMaLoaiVe);
    }

    public int deleteAllChiTietGioHang() {
        for (int i = 0; i < CartBUS.getInstance().getLstModelItemSize(); i++) {
            ModelItem modelItem = CartBUS.getInstance().getModelItem(i);
            if (deleteChiTietGioHang(modelItem.getLoaiVe().getIMaLoaiVe()) == 0) {
                return 0;
            }
        }
        return 1;
    }

    // Delete GioHang
    public int deleteGioHang() {
        return GioHangDAO.getInstance().delete(iMaGioHang);
    }

    // Create HoaDon and return MaHD
    public int createHoaDon(Date dateNgayHD, long lTongGiaTien) {
        return HoaDonDAO.getInstance().insert(new HoaDonDTO(0, 8, dateNgayHD, lTongGiaTien));
    }

    // Create ChiTietHoaDon for ModelItems in lstModelItem
    public int createChiTietHoaDons(int iMaHD) {
        for (ModelItem item : lstModelItem) {
            if (ChiTietHoaDonDAO.getInstance().insert(new ChiTietHoaDonDTO(iMaHD, item.getLoaiVe().getIMaLoaiVe(), item.getSoLuong())) == 0) {
                return 0;
            }
        }
        return 1;
    }

    // Create Ves for KhachHang corresponding to the ModelItems in lstModelItem
    public int createVes() {
        for (ModelItem item : lstModelItem) {
            if (VeDAO.getInstance().insert(new VeDTO(0, item.getLoaiVe().getIMaLoaiVe(), 8, null, null, "Chưa kích hoạt")) == 0) {
                return 0;
            }
        }
        return 1;
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

    // Method delete All ModelItem from lstModelItem
    public void clearLstModelItem() {
        lstModelItem.clear();
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
