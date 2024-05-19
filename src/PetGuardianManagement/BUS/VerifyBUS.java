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
public class VerifyBUS {
    private static VerifyBUS instance;
    public static VerifyBUS getInstance() {
        if (instance == null) {
            instance = new VerifyBUS();
        }
        return instance;
    }
    
    public boolean CheckExistUser (String email){
        NguoiDungDTO user = NguoiDungDAO.getInstance().selectUserFromEmail(email);
        return user != null;
    } 
}
