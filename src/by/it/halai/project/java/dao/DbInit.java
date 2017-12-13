package by.it.halai.project.java.dao;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbInit {

    static final String URL_DB = "jdbc:mysql://127.0.0.1:2016/?useUnicode=true&characterEncoding=UTF-8";
    static final String USER_DB = "root";
    static final String PASSWORD_DB = "";

    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection =
                     DriverManager.getConnection
                             (URL_DB, USER_DB, PASSWORD_DB);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("DROP SCHEMA IF EXISTS `halai` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `halai` DEFAULT CHARACTER SET utf8 ;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `halai`.`roles` ( " +
                    "`ID` INT NOT NULL AUTO_INCREMENT, " +
                    "`Role` VARCHAR(100) NOT NULL, " +
                    "PRIMARY KEY (`ID`)) " +
                    "ENGINE = InnoDB; ");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `halai`.`users`( " +
                    "`ID`INT NOT NULL AUTO_INCREMENT, " +
                    "`Login`VARCHAR(100) NULL, " +
                    "`Password`VARCHAR(100) NULL, " +
                    "`Email`VARCHAR(100) NULL, " +
                    "`FK_roles`INT NOT NULL DEFAULT 3, " +
                    "PRIMARY KEY(`ID`), " +
                    "INDEX `fk_users_role_idx`(`FK_roles`ASC), " +
                    "CONSTRAINT `fk_users_role` " +
                    "FOREIGN KEY (`FK_roles`) " +
                    "REFERENCES `halai`.`roles`(`ID`) " +
                    "ON DELETE RESTRICT " +
                    "ON UPDATE RESTRICT) " +
                    "ENGINE = InnoDB; ");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `halai`.`ads` (\n" +
                    "`ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "`Name` VARCHAR(200) NULL,\n" +
                    "`Genre` VARCHAR(200) NULL,\n" +
                    "`Number_Of_Players` INT NULL,\n" +
                    "`Price` DOUBLE NULL,\n" +
                    "`Description` VARCHAR(5000) NULL,\n" +
                    "`FK_Users` INT NOT NULL,\n" +
                    "PRIMARY KEY (`ID`),\n" +
                    "INDEX `fk_ads_users1_idx` (`FK_Users` ASC),\n" +
                    "CONSTRAINT `fk_ads_users1`\n" +
                    "FOREIGN KEY (`FK_Users`)\n" +
                    "REFERENCES `halai`.`users` (`ID`)\n" +
                    "ON DELETE CASCADE\n" +
                    "ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("INSERT INTO `halai`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Administrator');");
            statement.executeUpdate("INSERT INTO `halai`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'User');");
            statement.executeUpdate("INSERT INTO `halai`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Guest');");
            statement.executeUpdate("INSERT INTO `halai`.`users` (`ID`, `Login`, `Password`, `Email`, `FK_roles`) VALUES (DEFAULT, 'admin','admin','admin@mail.ru','1');");
            statement.executeUpdate("INSERT INTO `halai`.`users` (`ID`, `Login`, `Password`, `Email`, `FK_roles`) VALUES (DEFAULT, 'user', 'user', 'user@mail.ru', '2');");
            statement.executeUpdate("INSERT INTO `halai`.`ads` (ID,Name,Genre,Number_Of_Players,Price,Description,FK_Users)" +
                    "VALUES (DEFAULT,'survivors','postapocalypse','1000','15','try to survive in radoactive wastelands','2');");

            System.out.println("DB halai. Init complete.");
        } catch (Exception e) {
            System.err.println("DB halai. Init fail.\n\n" + e.getMessage());
        }
    }


}
