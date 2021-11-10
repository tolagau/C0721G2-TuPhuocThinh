package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {

    private static String jdbcURL = "jdbc:mysql://localhost:3306/thimodule?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "12345678";
    private static Connection connection;

    public ConnectionSQL() {
    }

    public static Connection getConnection() {

        connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public static void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}