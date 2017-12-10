package by.it.halai.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TaskB {

    public static void main(String[] args) {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {


            System.out.println("Пользователи и их роли:");
            ResultSet res = statement.executeQuery(
                    "SELECT Login, role FROM users LEFT JOIN roles ON users.FK_roles=roles.ID;");

            while (res.next()) {
                System.out.println(String.format("%-15s %-15s",
                        res.getString("login"), res.getString("role")));
            }

            res = statement.executeQuery("SELECT COUNT(*) as c FROM users;");
            if (res.next()) {
                System.out.println(String.format("\n%-15s %-15s", "Пользователей:", res.getInt("c")));
            }

            res = statement.executeQuery("SELECT COUNT(*) as c FROM roles;");
            if (res.next()) {
                System.out.println(String.format("%-15s %-15s", "Ролей:", res.getInt("c")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}