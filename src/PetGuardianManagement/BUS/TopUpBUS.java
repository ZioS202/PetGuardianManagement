/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.BUS;

import PetGuardianManagement.DAO.KhachHangDAO;
import PetGuardianManagement.DTO.KhachHangDTO;

public class TopUpBUS {

    private static TopUpBUS instance;

    // Public static method to access the single instance
    public static TopUpBUS getInstance() {
        if (instance == null) {
            instance = new TopUpBUS();
        }
        return instance;
    }

    public int TopUpAcc(KhachHangDTO data) {
        long currentSoDu = KhachHangDAO.getInstance().selectById(8).getLongSoDu();
        long newSoDu = currentSoDu + data.getLongSoDu();
        data.setLongSoDu(newSoDu);
        return KhachHangDAO.getInstance().update(data);
    }
}
