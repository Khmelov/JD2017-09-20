package by.it.halai.jd03_01;

import java.sql.*;

public class A_AddUsers {


    public static void run() {
        // загрузка драйвера
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }

        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {

            //вставляем пользователей
            statement.executeUpdate("INSERT INTO users(Login, Password, Email, FK_roles)" +
                    " VALUES ('user','user','user@mail.ru','2');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
