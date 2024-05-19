/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.DAO;

import Database.JDBCUtil;
import PetGuardianManagement.DTO.ThuCungDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dungn
 */
public class ThuCungDAO {
     private static ThuCungDAO instance;

    // Public static method to access the single instance
    public static ThuCungDAO getInstance() {
        if (instance == null) {
            instance = new ThuCungDAO();
        }
        return instance;
    }

    // Return MaThuCung newly inserted if successfully, else return 0
    public int insert(ThuCungDTO data) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "INSERT INTO ThuCung (MaThuCung, TenThuCung, MaKHSoHuu, GiongLoai, CanNang) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql, new String[]{"ThuCung"});
            pst.setInt(1, data.getIMaThuCung());
            pst.setString(2, data.getStrTenThuCung());
            pst.setInt(3, data.getIMaKHSoHuu());
            pst.setString(4, data.getStrGiongLoai());
            pst.setFloat(5, data.getFCanNang());
            
            
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

    public ArrayList<ThuCungDTO> selectAll() {
        ArrayList<ThuCungDTO> result = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM ThuCung";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                 result.add(new ThuCungDTO(rs.getInt(1), rs.getFloat(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
            }

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return result;
    }

    public ArrayList<ThuCungDTO> selectByMaKH(int iMaKH) {
        ArrayList<ThuCungDTO> result = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM ThuCung WHERE MaKHSoHuu=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, iMaKH);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                result.add(new ThuCungDTO(rs.getInt("MaKH"), rs.getFloat("CanNang"), rs.getInt("MaKHSoHuu"), rs.getString("TenThuCung"), rs.getString("GiongLoai")));
            }

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return result;
    }

    public int update(ThuCungDTO data) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "UPDATE ThuCung SET TenThuCung=?, GiongLoai=?, CanNang=?, MaKHSoHuu=? WHERE MaThuCung=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, data.getStrTenThuCung());
            pst.setString(2, data.getStrGiongLoai());
            pst.setFloat(3, data.getFCanNang());
            pst.setInt(4, data.getIMaKHSoHuu());
            pst.setInt(5, data.getIMaThuCung());

            result = pst.executeUpdate();

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public int delete(int iMaThuCung) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "DELETE FROM ThuCung WHERE MaThuCung=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, iMaThuCung);

            result = pst.executeUpdate();

            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return result;
    }
    
    public ThuCungDTO selectbyID(int iMaThuCung){
        ThuCungDTO result= new ThuCungDTO();
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM ThuCung WHERE MaThuCung=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, iMaThuCung);
            ResultSet rs = pst.executeQuery();
            result = new ThuCungDTO(rs.getInt("MaKH"), rs.getFloat("CanNang"), rs.getInt("MaKHSoHuu"), rs.getString("TenThuCung"), rs.getString("GiongLoai"));
            JDBCUtil.closeConnection(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return result;
    }
}
