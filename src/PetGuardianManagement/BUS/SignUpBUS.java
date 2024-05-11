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
public class SignUpBUS {
    private static SignUpBUS instance;
    public static SignUpBUS getInstance() {
        if (instance == null) {
            instance = new SignUpBUS();
        }
        return instance;
    }
    
    public int createUser (String email, String password, String fullname){
        NguoiDungDTO newUser = new NguoiDungDTO();
        newUser.setIMaND(NguoiDungDAO.getInstance().selectMaxMaND());
        newUser.setStrEmail(email);
        newUser.setStrMatKhau(password);
        newUser.setStrHoTen(fullname);
        return NguoiDungDAO.getInstance().insert(newUser);
    }
    
    public boolean CheckExistUser (String email, String password){
        NguoiDungDTO user = NguoiDungDAO.getInstance().selectUser(email, password);
        return user != null;
    } 
}
