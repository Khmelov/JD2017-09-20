package by.it.halai.jd03_03.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator {
    private static volatile Connection connection = null;
    private static Properties dbPathWay = new Properties();

    static {
        try {
            //запуск драйвера
            Class.forName("com.mysql.jdbc.Driver");
            dbPathWay.load(ConnectionCreator.class.getResourceAsStream("ConfDB.ini"));
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed())
            connection = DriverManager.getConnection(
                    dbPathWay.getProperty("URL_DB"),
                    dbPathWay.getProperty("USER_DB"),
                    dbPathWay.getProperty("PASSWORD_DB")
            );
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        Connection cn = getConnection();
        if (!cn.isClosed())
            System.out.println("ok");

    }

}
