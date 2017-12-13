package by.it.halai.project.java.connection;

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
            //dbPathWay.load(ConnectionCreator.class.getResourceAsStream("ConfDB.ini"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed())
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:2016/halai?useUnicode=true&characterEncoding=UTF-8",
                    "root",
                    ""
            );
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        Connection cn = getConnection();
        if (!cn.isClosed())
            System.out.println("ok");

    }

}
