package jdbc.jpa.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private static volatile Util instance;
    private Connection connection;

    private Util() {
        try {
            if (connection == null) {
                Properties props = getProperties();
                connection = DriverManager.getConnection(
                        props.getProperty("db.url"),
                        props.getProperty("db.username"),
                        props.getProperty("db.password")
                );
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Util getInstance() {
        if (instance == null) {
            synchronized (Util.class) {
                if (instance == null) {
                    instance = new Util();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                connection = null;
            }
        }
    }

    private static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream inputStream = Util.class.getClassLoader().getResourceAsStream("database.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}