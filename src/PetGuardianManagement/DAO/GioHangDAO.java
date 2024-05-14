/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.DAO;

import Database.JDBCUtil;
import PetGuardianManagement.DTO.GioHangDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DucTran
 */
public class GioHangDAO {

    private static GioHangDAO instance;

    // Public static method to access the single instance
    public static GioHangDAO getInstance() {
        if (instance == null) {
            instance = new GioHangDAO();
        }
        return instance;
    }

    // Insert into GioHang table. Return 1 if insert successfully, else return 0
    public int insert(int iMaKH) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "INSERT INTO GioHang (MaKH) VALUES (?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, iMaKH);
            result = pst.executeUpdate();

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public GioHangDTO selectByMaKH(int id) {
        GioHangDTO result = null;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM GioHang WHERE MaKH=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int iMaGioHang = rs.getInt(1);
                int iMaKH = rs.getInt(2);

                result = new GioHangDTO(iMaGioHang, iMaKH);
            }

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public int delete(int iMaGioHang) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "DELETE FROM GioHang WHERE MaGioHang=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, iMaGioHang);
            result = pst.executeUpdate();

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return result;
    }
}
