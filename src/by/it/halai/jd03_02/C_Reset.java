package by.it.halai.jd03_02;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {

    static void removeAll() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("DROP SCHEMA IF EXISTS `halai` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `halai` DEFAULT CHARACTER SET utf8 ;");

            //удаление всех таблиц
            statement.executeUpdate("DROP TABLE IF EXISTS `halai`.`roles` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `halai`.`users` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `halai`.`ads` ;");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
