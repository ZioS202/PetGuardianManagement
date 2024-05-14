/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.DAO;

import Database.JDBCUtil;
import PetGuardianManagement.DTO.ChiTietHoaDonDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ductt
 */
public class ChiTietHoaDonDAO {

    private static ChiTietHoaDonDAO instance;

    // Public static method to access the single instance
    public static ChiTietHoaDonDAO getInstance() {
        if (instance == null) {
            instance = new ChiTietHoaDonDAO();
        }
        return instance;
    }

    public int insert(ChiTietHoaDonDTO data) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "INSERT INTO ChiTietHoaDon (MaHD, MaLoaiVe, SoLuongVe) VALUES (?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, data.getIMaHD());
            pst.setInt(2, data.getIMaLoaiVe());
            pst.setLong(3, data.getLSoLuongVe());

            result = pst.executeUpdate();

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return result;
    }
}
