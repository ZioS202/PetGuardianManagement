import Database.JDBCUtil;
import PetGuardianManagement.DTO.ThuCungDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThuCungDAO {
    public List<ThuCungDTO> getThuCungByKhachHangId(int khachHangId) throws ClassNotFoundException {
        List<ThuCungDTO> thuCungList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtil.getConnection();
            String sql = "SELECT * FROM ThuCung WHERE iMaKHSoHuu = ? ORDER BY iMaThuCung";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, khachHangId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ThuCungDTO thuCung = new ThuCungDTO();
                thuCung.setIMaThuCung(resultSet.getInt("iMaThuCung"));
                thuCung.setStrTenThuCung(resultSet.getString("strTenThuCung"));
                thuCung.setStrGiongLoai(resultSet.getString("strGiongLoai"));
                thuCung.setFCanNang(resultSet.getFloat("fCanNang"));
                thuCung.setIMaKHSoHuu(resultSet.getInt("iMaKHSoHuu"));
                thuCungList.add(thuCung);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return thuCungList;
    }
}