/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.BUS;

import PetGuardianManagement.DAO.ChiTietRaVaoDAO;
import PetGuardianManagement.DTO.ChiTietRaVaoDTO;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author dungn
 */
public class VisitorManagementBUS {
    private static VisitorManagementBUS instance;
    
    
    // Public static method to access the single instance
    public static VisitorManagementBUS getInstance() {
        if (instance == null) {
            instance = new VisitorManagementBUS();
        }
        return instance;
    }
    
    public ArrayList<ChiTietRaVaoDTO> searchByID(int iMaKH, int iMaThuCung){
        ArrayList<ChiTietRaVaoDTO> listData = ChiTietRaVaoDAO.getInstance().selectAll();
        ArrayList<ChiTietRaVaoDTO> ketQua = new ArrayList<>();
        
        for (int i = 0; i < listData.size(); i++) {
            ChiTietRaVaoDTO temp = listData.get(i);
            if(temp.getIMaKH() == iMaKH && temp.getIMaThuCung() == iMaThuCung){
                ketQua.add(temp);
            }
        }
        
        return ketQua;
        
    }
    
    public void save(String dateThoiGianVao, String dateThoiGianRa, int iMaKH, int iMaThuCung) throws SQLException{
        try {
            String format = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date tgVao = sdf.parse(dateThoiGianVao);
            Date tgRa = sdf.parse(dateThoiGianRa);
            ChiTietRaVaoDAO.getInstance().insert( tgVao,tgRa, iMaKH, iMaThuCung);
        } catch (ParseException ex) {
            Logger.getLogger(VisitorManagementBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteData(int iMaKH, int iMaThuCung) throws SQLException{          
        try {   
            ChiTietRaVaoDAO.getInstance().delete( iMaKH, iMaThuCung);
        } catch (Exception ex) {
            Logger.getLogger(VisitorManagementBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateNew(String dateThoiGianVao, String dateThoiGianRa, int iMaKH, int iMaThuCung){
        try {
            String format = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date tgVao = sdf.parse(dateThoiGianVao);
            Date tgRa = sdf.parse(dateThoiGianRa);
            ChiTietRaVaoDTO temp = new ChiTietRaVaoDTO();
            temp.setDateThoiGianRa(tgRa);
            temp.setDateThoiGianVao(tgVao);
            temp.setIMaKH(iMaKH);
            temp.setIMaThuCung(iMaThuCung);
            ChiTietRaVaoDAO.getInstance().update(temp);
        } catch (ParseException ex) {
            Logger.getLogger(VisitorManagementBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
