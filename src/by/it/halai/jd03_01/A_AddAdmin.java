package by.it.halai.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class A_AddAdmin {


    public static void run() {

        //второй способ загрузки драйвера
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {

            //вставляем пользователей
            statement.executeUpdate("INSERT INTO users(Login, Password, Email, FK_roles)" +
                    " VALUES ('admin','admin','admin@mail.ru','1');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
