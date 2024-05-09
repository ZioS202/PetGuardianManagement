/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.BUS;

import PetGuardianManagement.DTO.KhachHangDTO;
import PetGuardianManagement.DAO.KhachHangDAO;
import java.util.ArrayList;
import java.util.Iterator;
public class TopUpBUS {
    private static TopUpBUS instance;
    
    
    // Public static method to access the single instance
    public static TopUpBUS getInstance() {
        if (instance == null) {
            instance = new TopUpBUS();
        }
        return instance;
    }
    
    public void TopUpAcc(KhachHangDTO data, long money){
        ArrayList<KhachHangDTO> listKH =  KhachHangDAO.getInstance().selectAll();
       
        for (var ncc : listKH) {
            if(data.getIMaKH() == ncc.getIMaKH())
            {
                data.setLongSoDu(ncc.getLongSoDu());
                 break;
            }
        }
        long temp = data.getLongSoDu() + money;
        data.setLongSoDu(temp);
        KhachHangDAO.getInstance().update(data);
        }
    
}
