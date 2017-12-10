package by.it.halai.jd03_01;

import java.sql.*;

class A_AddData {


    static void run() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }

        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {

            //вставляем объявления
            statement.executeUpdate("INSERT INTO ads(ID,Name,Genre,Number_Of_Players,Price,Description,FK_Users)" +
                    "VALUES ('1','survivors','postapocalypse','1000','15','try to survive in radoactive wastelands','2');");
            statement.executeUpdate("INSERT INTO ads(ID,Name,Genre,Number_Of_Players,Price,Description,FK_Users)" +
                    "VALUES ('2','Pirate Bay','alternative history','1000','25','alternative history of pirates of the Caribbean Sea','2');");
            statement.executeUpdate("INSERT INTO ads(ID,Name,Genre,Number_Of_Players,Price,Description,FK_Users)" +
                    "VALUES ('3','Fairy tales of the Schwarzwald','game based on Warhammer','1500','15','more blood for the god of blood! Or...For the emperor','2');");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
