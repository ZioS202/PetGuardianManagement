/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.DAO;

import Database.JDBCUtil;
import PetGuardianManagement.DTO.LoaiVeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DucTran
 */
public class LoaiVeDAO {

    private static LoaiVeDAO instance;

    // Public static method to access the single instance
    public static LoaiVeDAO getInstance() {
        if (instance == null) {
            instance = new LoaiVeDAO();
        }
        return instance;
    }

    public int insert(LoaiVeDTO data) {
        int result = 0;
        return result;
    }

    public ArrayList<LoaiVeDTO> selectAll() {
        ArrayList<LoaiVeDTO> result = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM LoaiVe";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int iMaLoaiVe = rs.getInt(1);
                String strTenLoaiVe = rs.getString(2);
                long longGiaVe = rs.getLong(3);

                result.add(new LoaiVeDTO(iMaLoaiVe, strTenLoaiVe, longGiaVe));
            }

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return result;
    }

    public LoaiVeDTO selectByMaLoaiVe(int maLoaiVe) {
        LoaiVeDTO result = null;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM LoaiVe WHERE MaLoaiVe=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, maLoaiVe);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int iMaLoaiVe = rs.getInt(1);
                String strTenLoaiVe = rs.getString(2);
                long longGiaVe = rs.getLong(3);

                result = new LoaiVeDTO(iMaLoaiVe, strTenLoaiVe, longGiaVe);
            }

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public int update(LoaiVeDTO data) {
        int result = 0;
        return result;
    }

    public int delete(LoaiVeDTO data) {
        int result = 0;
        return result;
    }
}
