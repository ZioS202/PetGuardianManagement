/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DucTran
 */
public class JDBCUtil {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;

        // Load and register the Oracle JDBC driver
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Establish connection
        String url = "jdbc:oracle:thin:@//localhost:1521/orclpdb";
        String username = "PGM";
        String password = "pgm";
        connection = DriverManager.getConnection(url, username, password);

        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void printInfo(Connection connection) {
        try {
            if (connection != null) {
                DatabaseMetaData mtdt = connection.getMetaData();
//                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
