/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.BUS;

import PetGuardianManagement.DAO.NguoiDungDAO;

/**
 *
 * @author theha
 */
public class ChangePasswordBUS {
    private static ChangePasswordBUS instance;
    public static ChangePasswordBUS getInstance() {
        if (instance == null) {
            instance = new ChangePasswordBUS();
        }
        return instance;
    }
    public int updatePassword (String emailString, String passwordString){
        int res = 0;
        try {
            res = NguoiDungDAO.getInstance().updatePassword(emailString, passwordString);
        } catch (Exception e) {
        }
        return res;
    }
    
}
