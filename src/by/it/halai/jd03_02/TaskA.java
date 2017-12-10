package by.it.halai.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskA {

    public static void main(String[] args) throws SQLException {

        Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement();

        System.out.println("Administrator's ID = " + getId("Administrator", statement));
        System.out.println("User's ID = " + getId("User", statement));
        System.out.println("Guest's ID = " + getId("Guest", statement));
        System.out.println("Moderator's ID = " + getId("Moderator", statement));

    }

    private static int getId(String role, Statement statement) throws SQLException {
        ResultSet res = statement.executeQuery(
                String.format("SELECT Id FROM roles WHERE Role = '%s';", role));
        int id = 0;
        if (res.next()) {
            id = res.getInt(1);
        }
        return id;
    }

}