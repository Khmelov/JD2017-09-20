package by.it.halai.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB)) {
            if (!connection.isClosed())
                System.out.println("Соединение установлено");
            else
                System.out.println("Соежинение закрыто");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
