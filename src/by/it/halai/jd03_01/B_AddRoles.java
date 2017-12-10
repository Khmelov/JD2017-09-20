package by.it.halai.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class B_AddRoles {

    static void run() {

        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            int moderator = 0, user = 0;

            if (1 == statement.executeUpdate("insert into roles(`role`) values('Moderator');", Statement.RETURN_GENERATED_KEYS)) {
                ResultSet key = statement.getGeneratedKeys();
                if (key.next()) {
                    moderator = key.getInt(1);
                }
            }
            if (1 == statement.executeUpdate("insert into roles(`role`) values('User');", Statement.RETURN_GENERATED_KEYS)) {
                ResultSet key = statement.getGeneratedKeys();
                if (key.next()) {
                    user = key.getInt(1);
                }
            }
            statement.executeUpdate(String.format("insert into users(`Login`,`Password`,`Email`,`FK_roles`)" +
                    " values('moderator','moder','moderator@gmail.com',%d);", moderator));


            statement.executeUpdate("update users set `FK_roles` = " + user + " where Email = 'user@it.by';");
            statement.executeUpdate("update users set `FK_roles` = " + user + " where Email = 'user2@it.by';");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
