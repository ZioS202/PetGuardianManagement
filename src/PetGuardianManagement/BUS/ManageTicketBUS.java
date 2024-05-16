/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.BUS;

import PetGuardianManagement.DAO.VeDAO;
import PetGuardianManagement.DTO.VeDTO;
import java.util.ArrayList;

/**
 *
 * @author ductt
 */
public class ManageTicketBUS {

    private ArrayList<VeDTO> lstVe;
    private static ManageTicketBUS instance;

    // Public static method to access the single instance
    public static ManageTicketBUS getInstance() {
        if (instance == null) {
            instance = new ManageTicketBUS();
        }
        return instance;
    }

    private ManageTicketBUS() {
        lstVe = VeDAO.getInstance().selectByMaKH(8);
        if (lstVe == null) {
            lstVe = new ArrayList<>();
        }
    }

    public int updateVEDB(VeDTO data) {
        return VeDAO.getInstance().update(data);
    }

    // Method add Ve to lstVe
    public void addVe(VeDTO data) {
        lstVe.add(data);
        System.out.println("Added Ve successfully.");
    }

    // Method get Ve at index i in lstVe
    public VeDTO getVe(int i) {
        if (i >= 0 && i < lstVe.size()) {
            return lstVe.get(i);
        } else {
            System.out.println("Invalid index.");
            return null;
        }
    }

    // Method update Ve in listVe. Need to known MaVe
    public int updateVe(VeDTO data) {
        for (VeDTO ve : lstVe) {
            if (ve.getIMaVe() == data.getIMaVe()) {
                ve.setdateNgayKichHoat(data.getdateNgayKichHoat());
                ve.setDateNgayHetHan(data.getDateNgayHetHan());
                ve.setStrTrangThai(data.getStrTrangThai());
                return 1;
            }
        }
        System.out.println("Ve " + data.getIMaVe() + " not found.");
        return 0;
    }

    // Method delete Ve in listVe. Need to known MaVe
    public int deleteVe(int iMaVe) {
        for (VeDTO ve : lstVe) {
            if (ve.getIMaVe() == iMaVe) {
                lstVe.remove(ve);
                return 1;
            }
        }
        System.out.println("Ve " + iMaVe + " not found.");
        return 0;
    }

    // Method delete All ModelItem from lstModelItem
    public void clearLstVe() {
        lstVe.clear();
    }

    // Method get size of lstLoaiVe
    public int getLstVeSize() {
        return lstVe.size();
    }
}
