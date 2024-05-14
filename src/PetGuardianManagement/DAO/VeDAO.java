/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.DAO;

import Database.JDBCUtil;
import PetGuardianManagement.DTO.VeDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DucTran
 */
public class VeDAO {

    private static VeDAO instance;

    // Public static method to access the single instance
    public static VeDAO getInstance() {
        if (instance == null) {
            instance = new VeDAO();
        }
        return instance;
    }

    public int insert(VeDTO data) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "INSERT INTO c_Ve (MaLoaiVe, MaKH, NgayKichHoat, NgayHetHan, TrangThai) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, data.getIMaLoaiVe());
            pst.setInt(2, data.getIMaKH());
            if (data.getdateNgayKichHoat() != null) {
                pst.setDate(3, new Date(data.getdateNgayKichHoat().getTime()));
            } else {
                pst.setDate(3, null);
            }
            if (data.getDateNgayHetHan() != null) {
                pst.setDate(4, new Date(data.getDateNgayHetHan().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, data.getStrTrangThai());

            result = pst.executeUpdate();

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public ArrayList<VeDTO> selectAll() {
        ArrayList<VeDTO> result = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM c_Ve";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                result.add(new VeDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getString(6)));
            }

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return result;
    }

    public int update(VeDTO data) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "UPDATE c_Ve SET NgayKichHoat=?, NgayHetHan=?, TrangThai=? WHERE MaVe=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setDate(1, new Date(data.getdateNgayKichHoat().getTime()));
            pst.setDate(2, new Date(data.getDateNgayHetHan().getTime()));
            pst.setString(3, data.getStrTrangThai());
            pst.setInt(4, data.getIMaVe());

            result = pst.executeUpdate();

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public int delete(int iMaVe) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "DELETE FROM c_Ve WHERE MaVe=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, iMaVe);

            result = pst.executeUpdate();

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return result;
    }
}
