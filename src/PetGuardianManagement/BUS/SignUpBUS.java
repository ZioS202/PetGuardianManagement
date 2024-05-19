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
        newUser.setStrEmail(email);
        newUser.setStrMatKhau(password);
        newUser.setStrHoTen(fullname);
        int idND = NguoiDungDAO.getInstance().insert(newUser);
        if (idND>0){
            KhachHangDTO newKH = new KhachHangDTO();
            newKH.setIMaKH(idND);
            newKH.setLongSoDu(0);
            if (KhachHangDAO.getInstance().insert(newKH) > 0){
                return 1;
            }
        }
        return 0;
    }
    
    public boolean CheckExistUser (String email){
        NguoiDungDTO user = NguoiDungDAO.getInstance().selectUserFromEmail(email);
        return user != null;
    } 
}
