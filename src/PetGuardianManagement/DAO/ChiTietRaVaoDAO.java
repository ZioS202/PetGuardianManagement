/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import Database.JDBCUtil;
import java.sql.SQLException;
import PetGuardianManagement.DTO.ChiTietRaVaoDTO;
import java.util.ArrayList;

public class ChiTietRaVaoDAO {
    private static ChiTietRaVaoDAO instance;
    
    public static ChiTietRaVaoDAO getInstance() {
        if (instance == null) {
            instance = new ChiTietRaVaoDAO();
        }
        return instance;
    }
    
    public int insert(Date dateThoiGianVao, Date dateThoiGianRa, int iMaKH, int iMaThuCung) throws SQLException {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO ChiTietRaVao (ThoiGianVao, ThoiGianRa, MaKH, MaThuCung) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
             if (dateThoiGianVao != null) {
                pst.setDate(1, new java.sql.Date(dateThoiGianVao.getTime()));
            } else {
                pst.setDate(1, null);
            }
            if (dateThoiGianRa != null) {
                pst.setDate(2, new java.sql.Date(dateThoiGianRa.getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setInt(3, iMaKH);
            pst.setInt(4, iMaThuCung);
            //Thuc thi cau lenh sql
            ketQua = pst.executeUpdate();
            //Xu ly
            //Ngat ket noi den voi co so du lieu
            JDBCUtil.closeConnection(con);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public int delete(int iMaKH, int iMaThuCung) throws Exception {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM ChiTietRaVao WHERE MaKH=? AND MaThuCung=?";
            PreparedStatement pst = con.prepareStatement(sql);           
            pst.setInt(1, iMaKH);
            pst.setInt(2, iMaThuCung);
            
            ketQua = pst.executeUpdate();
            
            JDBCUtil.closeConnection(con);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public int update(ChiTietRaVaoDTO data){
         int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE ChiTietRaVao SET ThoiGianVao=?, ThoiGianRa=? WHERE MaKH=? AND MaThuCung=?";
            PreparedStatement pst = con.prepareStatement(sql);
            if (data.getDateThoiGianVao() != null) {
                pst.setDate(1, new java.sql.Date(data.getDateThoiGianVao().getTime()));
            } else {
                pst.setDate(1, null);
            }
            if (data.getDateThoiGianRa() != null) {
                pst.setDate(2, new java.sql.Date(data.getDateThoiGianRa().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setInt(3, data.getIMaKH());
            pst.setInt(4, data.getIMaThuCung());
            
            ketQua = pst.executeUpdate();
            
            JDBCUtil.closeConnection(con);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<ChiTietRaVaoDTO> selectAll(){
        ArrayList<ChiTietRaVaoDTO> ketQua = new ArrayList<>();
         try{
            Connection con = JDBCUtil.getConnection();
            String sql ="SELECT * FROM ChiTietRaVao";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int iMaKH = rs.getInt("MaKH");
                int iMaThuCung = rs.getInt("MaThuCung");
                Date dThoiGianVao = rs.getDate("ThoiGianVao");
                Date dThoiGianRa = rs.getDate("ThoiGianRa");
                
                ChiTietRaVaoDTO kh = new ChiTietRaVaoDTO(dThoiGianVao, dThoiGianRa,iMaKH, iMaThuCung);
                ketQua.add(kh);
            }
         } catch (ClassNotFoundException | SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
         return ketQua;
    }
    
    
    
}

