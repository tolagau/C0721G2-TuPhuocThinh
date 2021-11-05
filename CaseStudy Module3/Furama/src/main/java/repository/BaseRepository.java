package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {


    private static String jdbcURL = "jdbc:mysql://localhost:3306/furama?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "12345678";
    public static Connection connection;

    public BaseRepository() {

    }

    public Connection getConnection() {
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