package by.it.halai.jd03_01;

import java.sql.*;

class B_ShowUsers {
    static void run() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }

        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            //получаем пользователей
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `users`");
            while (resultSet.next()) {
                String out = resultSet.getString("Email") + ", " + resultSet.getString("Login");
                System.out.println(out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
