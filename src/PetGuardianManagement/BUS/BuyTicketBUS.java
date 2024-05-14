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
 * @author DucTran
 */
public class BuyTicketBUS {

    private ArrayList<LoaiVeDTO> lstLoaiVe;
    private static BuyTicketBUS instance;

    // Public static method to access the single instance
    public static BuyTicketBUS getInstance() {
        if (instance == null) {
            instance = new BuyTicketBUS();
        }
        return instance;
    }

    private BuyTicketBUS() {
        lstLoaiVe = LoaiVeDAO.getInstance().selectAll();
    }

    // Method get LoaiVe at index i in lstLoaiVe
    public LoaiVeDTO getLoaiVe(int i) {
        if (i >= 0 && i < lstLoaiVe.size()) {
            return lstLoaiVe.get(i);
        } else {
            System.out.println("Invalid index.");
            return null;
        }
    }

    // Method get size of lstLoaiVe
    public int getLstLoaiVeSize() {
        return lstLoaiVe.size();
    }

    // Method search LoaiVe in lstLoaiVe need to known iMaLoaiVe
    public LoaiVeDTO searchLoaiVe(int iMaLoaiVe) {
        for (LoaiVeDTO loaiVe : lstLoaiVe) {
            if (loaiVe.getIMaLoaiVe() == iMaLoaiVe) {
                return loaiVe;
            }
        }
        System.out.println("LoaiVe that have iMaLoaiVe=" + iMaLoaiVe + " not found.");
        return null;
    }

    public int buyTicket(int iMaLoaiVe) {
        int result = 0;

        // Check if User already has a shopping cart
        GioHangDTO gioHang = GioHangDAO.getInstance().selectByMaKH(8);
        if (gioHang != null) {
            result = addToCart(gioHang.getIMaGioHang(), iMaLoaiVe);
        } else {
            result = createAndAddToCart(iMaLoaiVe);
        }

        return result;
    }

    private int addToCart(int iMaGioHang, int iMaLoaiVe) {
        // Check if LoaiVe already has in lstModelItem(CartBUS)
        ModelItem item = CartBUS.getInstance().searchModelItem(iMaLoaiVe);
        if (item == null) {
            CartBUS.getInstance().addModelItem(new ModelItem(searchLoaiVe(iMaLoaiVe), 1));
        } else {
            item.setSoLuong(item.getSoLuong() + 1);
            CartBUS.getInstance().updateModelItem(item);
        }

        // Check if LoaiVe already has in User's shopping cart
        ChiTietGioHangDTO chiTietGioHang = ChiTietGioHangDAO.getInstance().selectById(iMaGioHang, iMaLoaiVe);
        if (chiTietGioHang == null) {
            // Add chosen LoaiVe to User's shopping cart
            return ChiTietGioHangDAO.getInstance().insert(iMaGioHang, iMaLoaiVe, 1);
        } else {
            // Increase the quantity of LoaiVe by 1 in User's shopping cart
            chiTietGioHang.setISoLuongMua(chiTietGioHang.getISoLuongMua() + 1);
            return ChiTietGioHangDAO.getInstance().update(chiTietGioHang);
        }
    }

    private int createAndAddToCart(int iMaLoaiVe) {
        // Create a shopping cart for the User
        int tmp = GioHangDAO.getInstance().insert(8);
        // // Add chosen LoaiVe to lstModelItem(CartBUS) and User's shopping cart
        if (tmp > 0) {
            CartBUS.getInstance().addModelItem(new ModelItem(searchLoaiVe(iMaLoaiVe), 1));
            int iMaGioHang = GioHangDAO.getInstance().selectByMaKH(8).getIMaGioHang();
            CartBUS.getInstance().iMaGioHang = iMaGioHang;
            return ChiTietGioHangDAO.getInstance().insert(iMaGioHang, iMaLoaiVe, 1);
        } else {
            return 0; // Failed to create shopping cart
        }
    }

}
