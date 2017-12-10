package by.it.ali.project.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {
    static final String URL_DB = "jdbc:mysql://127.0.0.1:2016/?useUnicode=true&characterEncoding=UTF-8";
    static final String USER_DB = "root";
    static final String PASSWORD_DB = "";
    public static void main(String[] args) {

        try (
                Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
                Statement statement=connection.createStatement();)
        {
            String dropTable = "DROP DATABASE ali";
            statement.executeUpdate(dropTable);
            System.out.println("Database deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
