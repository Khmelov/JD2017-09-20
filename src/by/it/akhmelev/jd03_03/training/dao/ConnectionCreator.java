package by.it.akhmelev.jd03_03.training.dao;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionCreator {
    static private Connection connection;
    static Properties db=new Properties();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            db.load(ConnectionCreator.class.getResourceAsStream("connection.ini"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ConnectionCreator() {
    }

    static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (CN.class) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(
                            db.getProperty("URL"),
                            db.getProperty("USER"),
                            db.getProperty("PASSWORD")
                    );
                }
            }
        }
        return connection;
    }
}
