/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.BUS;

import PetGuardianManagement.DAO.KhachHangDAO;
import PetGuardianManagement.DAO.NguoiDungDAO;
import PetGuardianManagement.DTO.KhachHangDTO;
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
        newUser.setIMaND(NguoiDungDAO.getInstance().selectMaxMaND()+1);
        newUser.setStrEmail(email);
        newUser.setStrMatKhau(password);
        newUser.setStrHoTen(fullname);
        
        KhachHangDTO newKH = new KhachHangDTO();
        newKH.setIMaKH(newUser.getIMaND());
        newKH.setLongSoDu(0);
        return NguoiDungDAO.getInstance().insert(newUser) & KhachHangDAO.getInstance().insert(newKH);
    }
    
    public boolean CheckExistUser (String email){
        NguoiDungDTO user = NguoiDungDAO.getInstance().selectUserFromEmail(email);
        return user != null;
    } 
}
