/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.DAO;

import Database.JDBCUtil;
import PetGuardianManagement.DTO.KhachHangDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dungn
 */
public class KhachHangDAO {

    private static KhachHangDAO instance;

    // Public static method to access the single instance
    public static KhachHangDAO getInstance() {
        if (instance == null) {
            instance = new KhachHangDAO();
        }
        return instance;
    }

    public int insert(KhachHangDTO data) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO KhachHang (MaKH, SoDu) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, data.getIMaKH());
            pst.setLong(2, data.getLongSoDu());
            //Thuc thi cau lenh sql
            ketQua = pst.executeUpdate();
            //Xu ly
            //Ngat ket noi den voi co so du lieu
            JDBCUtil.closeConnection(con);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return ketQua;
    }

    public int update(KhachHangDTO data) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            JDBCUtil.printInfo(con);
            String sql = "UPDATE KhachHang SET SoDu=? WHERE MaKH=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setLong(1, data.getLongSoDu());
            pst.setInt(2, data.getIMaKH());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return ketQua;
    }

    public int delete(int iMaKH) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM KhachHang WHERE MaKH=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, iMaKH);

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return ketQua;
    }

    public KhachHangDTO selectById(int iMaKH) {
        KhachHangDTO khachhang = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM KhachHang WHERE MaKH=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, iMaKH);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maKH = rs.getInt("MaKH");
                long soDu = rs.getLong("SoDu");
                khachhang = new KhachHangDTO(maKH, soDu);
            }
            JDBCUtil.closeConnection(con);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return khachhang;
    }

    public ArrayList<KhachHangDTO> selectAll() {
        ArrayList<KhachHangDTO> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM KhachHang";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int iMaKH = rs.getInt("MaKH");
                long lSoDu = rs.getLong("SoDu");

                KhachHangDTO kh = new KhachHangDTO(iMaKH, lSoDu);
                ketQua.add(kh);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return ketQua;
    }
}
