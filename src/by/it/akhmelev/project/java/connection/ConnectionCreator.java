package by.it.akhmelev.project.java.connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator {
    private static volatile Connection connection = null;
    private static Properties dbSetting=new Properties();

    static {
        try { //регистрируем драйвер
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed())
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:2016/akhmelev?useUnicode=true&characterEncoding=UTF-8",
                    "root",
                    ""
            );
        return connection;
    }

    public static Connection getConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/my_sql_akhmelev");
            return ds.getConnection();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection cn=getConnection();
        if (!cn.isClosed())
            System.out.println("ok");

    }

}
