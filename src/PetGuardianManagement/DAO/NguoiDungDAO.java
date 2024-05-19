/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.DAO;

import Database.JDBCUtil;
import PetGuardianManagement.DTO.NguoiDungDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author theha
 */
public class NguoiDungDAO {
    private static NguoiDungDAO instance;

    // Public static method to access the single instance
    public static NguoiDungDAO getInstance() {
        if (instance == null) {
            instance = new NguoiDungDAO();
        }
        return instance;
    }
    // Insert into NguoiDung table. Return 1 if insert successfully, else return 0
    public int insert(NguoiDungDTO user) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "INSERT INTO NguoiDung (Email, MatKhau, HoTen, VaiTro) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql, new String[]{"MaND"});
            pst.setString(1, user.getStrEmail());
            pst.setString(2, user.getStrMatKhau());
            pst.setString(3, user.getStrHoTen());
            pst.setString(4, "Khach Hang");
            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = pst.getGeneratedKeys()) {
                    if (rs.next()) {
                        result = rs.getInt(1);
                    }
                }
            }
            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return result;
    }
    public NguoiDungDTO selectUser(String strEmail, String strPassword) {
        NguoiDungDTO result = null;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM NguoiDung WHERE Email=? AND MatKhau=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, strEmail);
            pst.setString(2, strPassword);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaND = rs.getInt(1);
                String Email = rs.getString(2);
                String MatKhau = rs.getString(3);
                String HoTen = rs.getString(4);
                String GioiTinh = rs.getString(5);
                Date NgSinh = rs.getDate(6);
                String Diachi = rs.getString(7);
                String QueQuan = rs.getString(8);
                String SoDT = rs.getString(9);
                String VaiTro = rs.getString(10);
                result = new NguoiDungDTO(MaND, Email, MatKhau, HoTen, SoDT, GioiTinh, Diachi, QueQuan, VaiTro, NgSinh);
            }

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return result;
    }
    public NguoiDungDTO selectUserFromEmail(String strEmail) {
        NguoiDungDTO result = null;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM NguoiDung WHERE Email=? ";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, strEmail);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaND = rs.getInt(1);
                String Email = rs.getString(2);
                String MatKhau = rs.getString(3);
                String HoTen = rs.getString(4);
                String GioiTinh = rs.getString(5);
                Date NgSinh = rs.getDate(6);
                String Diachi = rs.getString(7);
                String QueQuan = rs.getString(8);
                String SoDT = rs.getString(9);
                String VaiTro = rs.getString(10);
                result = new NguoiDungDTO(MaND, Email, MatKhau, HoTen, SoDT, GioiTinh, Diachi, QueQuan, VaiTro, NgSinh);
            }

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public int updatePassword (String strEmail, String strPassword) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "UPDATE NguoiDung SET MatKhau=? WHERE Email=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, strPassword);
            pst.setString(2, strEmail);
            result = pst.executeUpdate();

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return result;
    }
    public int updateInformationUser (String name, String address, String country, String phoneNumber, String gender, String strEmail) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "UPDATE NguoiDung SET HoTen=?, DiaChi=?, QueQuan=?, SDT=?,GioiTinh=? WHERE Email=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setString(3, country);
            pst.setString(4, phoneNumber);
            pst.setString(5, gender);
            pst.setString(6, strEmail);
            result = pst.executeUpdate();

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return result;
    }
     public ArrayList<NguoiDungDTO> selectAll() {
        ArrayList<NguoiDungDTO> result = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM c_Ve";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int MaND = rs.getInt(1);
                String Email = rs.getString(2);
                String MatKhau = rs.getString(3);
                String HoTen = rs.getString(4);
                String GioiTinh = rs.getString(5);
                Date NgSinh = rs.getDate(6);
                String Diachi = rs.getString(7);
                String QueQuan = rs.getString(8);
                String SoDT = rs.getString(9);
                String VaiTro = rs.getString(10);
                NguoiDungDTO ND = new NguoiDungDTO(MaND, Email, MatKhau, HoTen, SoDT, GioiTinh, Diachi, QueQuan, VaiTro, NgSinh);
                result.add(ND);
            }

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return result;
    }
}
