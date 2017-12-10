package by.it.ali.project.java.dao;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Init_Ali {
    static final String URL_DB = "jdbc:mysql://127.0.0.1:2016/?useUnicode=true&characterEncoding=UTF-8";
    static final String USER_DB = "root";
    static final String PASSWORD_DB = "";

    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }



         try (Connection
            connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
            Statement statement=connection.createStatement())
         {
             statement.executeUpdate("DROP SCHEMA IF EXISTS `ali`;");
             statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `ali` DEFAULT CHARACTER SET utf8 ;");
             //генерация всех таблиц
             statement.executeUpdate(
                     "CREATE TABLE IF NOT EXISTS `ali`.`roles` (\n" +
                             "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                             "  `Role` VARCHAR(45) NOT NULL,\n" +
                             "  PRIMARY KEY (`ID`))\n" +
                             "ENGINE = InnoDB;"
             );
             statement.executeUpdate(
                     "CREATE TABLE IF NOT EXISTS `ali`.`users` (\n" +
                             "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                             "  `Login` VARCHAR(45) NULL,\n" +
                             "  `Password` VARCHAR(45) NULL,\n" +
                             "  `Email` VARCHAR(45) NULL,\n" +
                             "  `FKroles` INT NOT NULL,\n" +
                             "  PRIMARY KEY (`ID`),\n" +
                             "  INDEX `fk_users_roles_idx` (`FKroles` ASC),\n" +
                             "  CONSTRAINT `fk_users_roles`\n" +
                             "    FOREIGN KEY (`FKroles`)\n" +
                             "    REFERENCES `ali`.`roles` (`ID`)\n" +
                             "    ON DELETE RESTRICT \n" +
                             "    ON UPDATE RESTRICT )\n" +
                             "ENGINE = InnoDB;"
             );
             statement.executeUpdate(
                     "CREATE TABLE IF NOT EXISTS `ali`.`tickets` (\n" +
                             "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                             "  `Destination` VARCHAR(45) NOT NULL,\n" +
                             "  `Company` VARCHAR(45) NOT NULL,\n" +
                             "  `Date` DATE NOT NULL,\n" +
                             "  `Price` Double NOT NULL,\n" +
                             "  `FKusers` INT NOT NULL,\n" +
                             "  PRIMARY KEY (`ID`),\n" +
                             "  INDEX `fk_tickets_users1_idx` (`FKusers` ASC),\n" +
                             "  CONSTRAINT `fk_tickets_users1`\n" +
                             "    FOREIGN KEY (`FKusers`)\n" +
                             "    REFERENCES `ali`.`users` (`ID`)\n" +
                             "    ON DELETE CASCADE\n" +
                             "    ON UPDATE CASCADE)\n" +
                             "ENGINE = InnoDB;"
             );
             //вставка тестовых записей
             statement.executeUpdate("insert into `ali`.`roles`(ID,Role)"+"values(DEFAULT,'Administrator');"
             );
             statement.executeUpdate("insert into `ali`.`roles`(ID,Role)"+"values(DEFAULT,'User');"
             );
             statement.executeUpdate("insert into `ali`.`roles`(ID,Role)"+"values(DEFAULT,'Guest');"
             );



             statement.executeUpdate("insert into `ali`.`users`(Login,Password,Email,FKroles)"+"values('Admin','Admin','AdminD@gmail.com','1');"
             );
             statement.executeUpdate("insert into `ali`.`users`(Login,Password,Email,FKroles)"+"values('Sarah','Moonie','SarahMoon@gmail.com','1');"
             );
             statement.executeUpdate("insert into `ali`.`users`(Login,Password,Email,FKroles)"+"values('Donald','biggie','DonaldD@gmail.com','2');"
             );
             statement.executeUpdate("insert into `ali`.`users`(FKroles)"+"values('3');"
             );
             statement.executeUpdate("insert into `ali`.`users`(FKroles)"+"values('3');"
             );
             statement.executeUpdate("insert into `ali`.`tickets`(Destination,Company,Date,Price,Fkusers)"+"values('Moscow','Belavia','17.08.29','140','2');"
             );
             statement.executeUpdate("insert into `ali`.`tickets`(Destination,Company,Date,Price,Fkusers)"+"values('London','Lufthansa','17.12.25','180','2');"
             );
             statement.executeUpdate("insert into `ali`.`tickets`(Destination,Company,Date,Price,Fkusers)"+"values('Paris','S7Airlines','17.10.11','190','2');"
             );
             statement.executeUpdate("insert into `ali`.`tickets`(Destination,Company,Date,Price,Fkusers)"+"values('Saint-Petersburg','Belavia','17.04.23','100','3');"
             );

             System.out.println("DB Ali. Init complete.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ;


    }

}
