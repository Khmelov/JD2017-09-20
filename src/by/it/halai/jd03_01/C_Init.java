package by.it.halai.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {


    static void run() {
        String URL_DB = "jdbc:mysql://127.0.0.1:2016/?useUnicode=true&characterEncoding=UTF-8";
        String USER_DB = "root";
        String PASSWORD_DB = "";
        try {
            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            //пересоздание базы целиком
            statement.executeUpdate("DROP SCHEMA IF EXISTS `halai` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `halai` DEFAULT CHARACTER SET utf8 ;");
            //удаление всех таблиц (если работает удаление схемы то это лишнее)
            statement.executeUpdate("DROP TABLE IF EXISTS `halai`.`ads`;");
            statement.executeUpdate("DROP TABLE IF EXISTS `halai`.`users`;");
            statement.executeUpdate("DROP TABLE IF EXISTS `halai`.`roles`;");
            //генерация всех таблиц
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `halai`.`roles` (\n" +
                            "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `Role` VARCHAR(100) NULL,\n" +
                            "  PRIMARY KEY (`ID`))\n" +
                            "ENGINE = InnoDB;"
            );
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `halai`.`users` (\n" +
                            "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `Login` VARCHAR(100) NULL,\n" +
                            "  `Password` VARCHAR(100) NULL,\n" +
                            "  `Email` VARCHAR(100) NULL,\n" +
                            "  `FK_roles` INT NOT NULL,\n" +
                            "  PRIMARY KEY (`ID`),\n" +
                            "  INDEX `fk_users_FK_rolesx` (`FK_roles` ASC),\n" +
                            "  CONSTRAINT `fk_users_roles`\n" +
                            "    FOREIGN KEY (`FK_roles`)\n" +
                            "    REFERENCES `halai`.`roles` (`ID`)\n" +
                            "    ON DELETE RESTRICT \n" +
                            "    ON UPDATE RESTRICT )\n" +
                            "ENGINE = InnoDB;"
            );
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `halai`.`ads` (\n" +
                            "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `Name` VARCHAR(200) NULL,\n" +
                            "  `Genre` VARCHAR(200) NULL,\n" +
                            "  `Number_Of_Players` INT NULL,\n" +
                            "  `Price` DOUBLE NULL,\n" +
                            "  `Description` VARCHAR(5000) NULL,\n" +
                            "  `FK_Users` INT NOT NULL,\n" +
                            "  PRIMARY KEY (`ID`),\n" +
                            "  INDEX `fk_ads_users1_idx` (`FK_Users` ASC),\n" +
                            "  CONSTRAINT `fk_ads_users1`\n" +
                            "    FOREIGN KEY (`FK_Users`)\n" +
                            "    REFERENCES `halai`.`users` (`ID`)\n" +
                            "    ON DELETE CASCADE\n" +
                            "    ON UPDATE CASCADE)\n" +
                            "ENGINE = InnoDB;"
            );
            //вставка тестовых записей
            statement.executeUpdate("INSERT INTO `halai`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Administrator');");
            statement.executeUpdate("INSERT INTO `halai`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'User');");
            statement.executeUpdate("INSERT INTO `halai`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Guest');");
            statement.executeUpdate("INSERT INTO `halai`.`users` (`ID`, `Login`, `Password`, `Email`, `FK_roles`) VALUES (DEFAULT, 'admin','admin','admin@mail.ru','1');");
            statement.executeUpdate("INSERT INTO `halai`.`users` (`ID`, `Login`, `Password`, `Email`, `FK_roles`) VALUES (DEFAULT, 'user', 'user', 'user@mail.ru', '2');");
            statement.executeUpdate("INSERT INTO `halai`.`ads` (ID,Name,Genre,Number_Of_Players,Price,Description,FK_Users)" +
                    "VALUES (DEFAULT,'survivors','postapocalypse','1000','15','try to survive in radoactive wastelands','2');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
