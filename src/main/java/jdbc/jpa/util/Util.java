package jdbc.jpa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {

    private static Util instance;
    private static Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/sakila";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Util() {
        try {
            // Загрузка драйвера JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Установка соединения с базой данных
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }
}