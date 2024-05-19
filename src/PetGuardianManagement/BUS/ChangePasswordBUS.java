/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.BUS;

import PetGuardianManagement.DAO.NguoiDungDAO;
import PetGuardianManagement.DTO.NguoiDungDTO;

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
    public int updateInformationUser (String name, String address, String country, String phoneNumber, String gender, String strEmail){
        int res = 0;
        try {
            res = NguoiDungDAO.getInstance().updateInformationUser(name, address, country, phoneNumber, gender, strEmail);
        } catch (Exception e) {
        }
        return res;
    }
    public boolean checkPassword (String emailString, String passwordString){
        NguoiDungDTO user = NguoiDungDAO.getInstance().selectUser(emailString, passwordString);
        return user != null;
    }
    
}
