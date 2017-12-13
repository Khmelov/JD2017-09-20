package by.it.halai.jd03_03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbReset {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("DROP TABLE IF EXISTS `halai`.`ads` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `halai`.`users` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `halai`.`roles` ;");
            statement.executeUpdate("DROP SCHEMA IF EXISTS `halai` ;");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
