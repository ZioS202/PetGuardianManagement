/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.BUS;

import PetGuardianManagement.DAO.KhachHangDAO;
import PetGuardianManagement.DTO.KhachHangDTO;
import PetGuardianManagement.GUI.Signin.main.Signin;

public class TopUpBUS {

    private static TopUpBUS instance;

    // Public static method to access the single instance
    public static TopUpBUS getInstance() {
        if (instance == null) {
            instance = new TopUpBUS();
        }
        return instance;
    }

    public int TopUpAcc(long amount) {
        long currentSoDu = KhachHangDAO.getInstance().selectById(Signin.User.getIMaND()).getLongSoDu();
        long newSoDu = currentSoDu + amount;
        KhachHangDTO data = new KhachHangDTO(Signin.User.getIMaND(), newSoDu);
        return KhachHangDAO.getInstance().update(data);
    }
}
