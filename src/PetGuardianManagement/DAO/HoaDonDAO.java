/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.DAO;

import Database.JDBCUtil;
import PetGuardianManagement.DTO.HoaDonDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ductt
 */
public class HoaDonDAO {

    private static HoaDonDAO instance;

    // Public static method to access the single instance
    public static HoaDonDAO getInstance() {
        if (instance == null) {
            instance = new HoaDonDAO();
        }
        return instance;
    }

    // Return MaHD newly inserted if successfully, else return 0
    public int insert(HoaDonDTO data) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "INSERT INTO HoaDon (MaKH, NgayHD, TongGiaTien) VALUES (?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql, new String[]{"MaHD"});
            pst.setInt(1, data.getIMaKH());
            pst.setDate(2, new Date(data.getDateNgayHD().getTime()));
            pst.setLong(3, data.getLTongGiaTien());

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
}
