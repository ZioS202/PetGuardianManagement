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
public class SignInBUS {
    
    private static SignInBUS instance;
    public static SignInBUS getInstance() {
        if (instance == null) {
            instance = new SignInBUS();
        }
        return instance;
    }
    
    public boolean authenticateUser (String email, String password){
        NguoiDungDTO user = NguoiDungDAO.getInstance().selectUser(email, password);
        return user != null;
    }

    public NguoiDungDTO getUser (String email, String password) {
        NguoiDungDTO user = NguoiDungDAO.getInstance().selectUser(email, password);
        return user;
    }
}
