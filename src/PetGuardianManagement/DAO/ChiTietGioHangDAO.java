/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.DAO;

import Database.JDBCUtil;
import PetGuardianManagement.DTO.ChiTietGioHangDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DucTran
 */
public class ChiTietGioHangDAO {

    private static ChiTietGioHangDAO instance;

    // Public static method to access the single instance
    public static ChiTietGioHangDAO getInstance() {
        if (instance == null) {
            instance = new ChiTietGioHangDAO();
        }
        return instance;
    }

    // Insert into ChiTietGioHang table. Return 1 if insert successfully, else return 0
    public int insert(int iMaGioHang, int iMaLoaiVe, long lSoLuongMua) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "INSERT INTO ChiTietGioHang (MaGioHang, MaLoaiVe, SoLuongMua) VALUES (?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, iMaGioHang);
            pst.setInt(2, iMaLoaiVe);
            pst.setLong(3, lSoLuongMua);
            result = pst.executeUpdate();

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public ChiTietGioHangDTO selectById(int maGioHang, int maLoaiVe) {
        ChiTietGioHangDTO result = null;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM ChiTietGioHang WHERE MaGioHang=? AND MaLoaiVe=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, maGioHang);
            pst.setInt(2, maLoaiVe);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int iMaGioHang = rs.getInt(1);
                int iMaLoaiVe = rs.getInt(2);
                int iSoLuongMua = rs.getInt(3);

                result = new ChiTietGioHangDTO(iMaGioHang, iMaLoaiVe, iSoLuongMua);
            }

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public ArrayList<ChiTietGioHangDTO> selectByMaGioHang(int maGioHang) {
        ArrayList<ChiTietGioHangDTO> result = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM ChiTietGioHang WHERE MaGioHang=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, maGioHang);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int iMaGioHang = rs.getInt(1);
                int iMaLoaiVe = rs.getInt(2);
                int iSoLuongMua = rs.getInt(3);

                result.add(new ChiTietGioHangDTO(iMaGioHang, iMaLoaiVe, iSoLuongMua));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public int update(ChiTietGioHangDTO data) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "UPDATE ChiTietGioHang SET SoLuongMua=? WHERE MaGioHang=? AND MaLoaiVe=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, data.getISoLuongMua());
            pst.setInt(2, data.getIMaGioHang());
            pst.setInt(3, data.getIMaLoaiVe());
            result = pst.executeUpdate();

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return result;
    }
}
