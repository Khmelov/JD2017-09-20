package by.it.meshchenko.project.java.dao;

import by.it.meshchenko.project.java.connection.*;
import by.it.meshchenko.project.java.beans.*;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class DB {
    public static void reset() throws SQLException {
        delete();
        init();
        addData();
    }

    private static void delete() {
        try {
            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {

            //пересоздание базы целиком
            statement.executeUpdate(String.format("DROP SCHEMA IF EXISTS `meshchenko` ;"));
            statement.executeUpdate(String.format("CREATE SCHEMA IF NOT EXISTS `meshchenko` DEFAULT CHARACTER SET utf8 ;"));

            //удаление всех таблиц (если работает удаление схемы то это лишнее)
            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`addr_countries` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`addr_countries` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`addr_cities` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`addr_streets` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`addr_addresses` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`crm_roles` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`crm_users` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`ls_shoppingcenters` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`ls_rooms` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`ls_leaserooms` ;");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void init() {
        try {
            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {

            //пересоздание базы целиком
            statement.executeUpdate(String.format("DROP SCHEMA IF EXISTS `meshchenko` ;"));
            statement.executeUpdate(String.format("CREATE SCHEMA IF NOT EXISTS `meshchenko` DEFAULT CHARACTER SET utf8 ;"));

//            //удаление всех таблиц (если работает удаление схемы то это лишнее)
//            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`addr_countries` ;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`addr_countries` ;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`addr_cities` ;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`addr_streets` ;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`addr_addresses` ;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`crm_roles` ;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`crm_users` ;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`ls_shoppingcenters` ;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`ls_rooms` ;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`ls_leaserooms` ;");

            //генерация всех таблиц
            statement.executeUpdate(
                    String.format("CREATE TABLE IF NOT EXISTS `meshchenko`.`addr_countries` (\n" +
                            "  `Id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                            "  `Name` VARCHAR(255) NOT NULL,\n" +
                            "  PRIMARY KEY (`Id`),\n" +
                            "  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC))\n" +
                            "ENGINE = InnoDB\n" +
                            "DEFAULT CHARACTER SET = utf8;")
            );
            statement.executeUpdate(
                    String.format("CREATE TABLE IF NOT EXISTS `meshchenko`.`addr_cities` (\n" +
                            "  `Id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                            "  `Name` VARCHAR(255) NOT NULL,\n" +
                            "  `CountryId` INT(11) NOT NULL,\n" +
                            "  PRIMARY KEY (`Id`),\n" +
                            "  UNIQUE INDEX `Name_CountryId_UNIQUE` (`Name` ASC, `CountryId` ASC),\n" +
                            "  INDEX `FK_Countries_Cities_idx` (`CountryId` ASC),\n" +
                            "  CONSTRAINT `FK_Countries_Cities`\n" +
                            "    FOREIGN KEY (`CountryId`)\n" +
                            "    REFERENCES `meshchenko`.`addr_countries` (`Id`))\n" +
                            "ENGINE = InnoDB\n" +
                            "DEFAULT CHARACTER SET = utf8;")
            );
            statement.executeUpdate(
                    String.format("CREATE TABLE IF NOT EXISTS `meshchenko`.`addr_streets` (\n" +
                            "  `Id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                            "  `Name` VARCHAR(255) NOT NULL,\n" +
                            "  `CityId` INT(11) NOT NULL,\n" +
                            "  PRIMARY KEY (`Id`),\n" +
                            "  UNIQUE INDEX `Name_CityId_UNIQUE` (`Name` ASC, `CityId` ASC),\n" +
                            "  INDEX `FK_Cities_Streets_idx` (`CityId` ASC),\n" +
                            "  CONSTRAINT `FK_Cities_Streets`\n" +
                            "    FOREIGN KEY (`CityId`)\n" +
                            "    REFERENCES `meshchenko`.`addr_cities` (`Id`))\n" +
                            "ENGINE = InnoDB\n" +
                            "DEFAULT CHARACTER SET = utf8;")
            );
            statement.executeUpdate(
                    String.format("CREATE TABLE IF NOT EXISTS `meshchenko`.`addr_addresses` (\n" +
                            "  `Id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                            "  `StreetId` INT(11) NOT NULL,\n" +
                            "  `BuildingNumberStr` VARCHAR(255) NOT NULL,\n" +
                            "  PRIMARY KEY (`Id`),\n" +
                            "  UNIQUE INDEX `BuildingNumberStr_StreetId_UNIQUE` (`BuildingNumberStr` ASC, `StreetId` ASC),\n" +
                            "  INDEX `FK_Streets_Addresses_idx` (`StreetId` ASC),\n" +
                            "  CONSTRAINT `FK_Streets_Addresses`\n" +
                            "    FOREIGN KEY (`StreetId`)\n" +
                            "    REFERENCES `meshchenko`.`addr_streets` (`Id`))\n" +
                            "ENGINE = InnoDB\n" +
                            "DEFAULT CHARACTER SET = utf8;")
            );
            statement.executeUpdate(
                    String.format("CREATE TABLE IF NOT EXISTS `meshchenko`.`crm_roles` (\n" +
                            "  `Id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                            "  `Role` VARCHAR(64) NOT NULL,\n" +
                            "  PRIMARY KEY (`Id`),\n" +
                            "  UNIQUE INDEX `Role_UNIQUE` (`Role` ASC))\n" +
                            "ENGINE = InnoDB\n" +
                            "DEFAULT CHARACTER SET = utf8;")
            );
            statement.executeUpdate(
                    String.format("CREATE TABLE IF NOT EXISTS `meshchenko`.`crm_users` (\n" +
                            "  `Id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                            "  `Name` VARCHAR(255) NOT NULL,\n" +
                            "  `Password` VARCHAR(1023) NOT NULL,\n" +
                            "  `PhoneNumber` VARCHAR(255) NULL DEFAULT NULL,\n" +
                            "  `Email` VARCHAR(255) NOT NULL,\n" +
                            "  `EmailConfirmed` TINYINT(1) NOT NULL DEFAULT 0,\n" +
                            "  `RoleId` INT(11) NULL DEFAULT NULL,\n" +
                            "  PRIMARY KEY (`Id`),\n" +
                            "  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC),\n" +
                            "  INDEX `RoleId` (`RoleId` ASC),\n" +
                            "  CONSTRAINT `FK_roles_users`\n" +
                            "    FOREIGN KEY (`RoleId`)\n" +
                            "    REFERENCES `meshchenko`.`crm_roles` (`Id`)\n" +
                            "    ON UPDATE NO ACTION)\n" +
                            "ENGINE = InnoDB\n" +
                            "DEFAULT CHARACTER SET = utf8;")
            );
            statement.executeUpdate(
                    String.format("CREATE TABLE IF NOT EXISTS `meshchenko`.`ls_shoppingcenters` (\n" +
                            "  `Id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                            "  `Name` VARCHAR(255) NOT NULL,\n" +
                            "  `AddressId` INT(11) NOT NULL,\n" +
                            "  `Lat` FLOAT NULL DEFAULT NULL,\n" +
                            "  `Lng` FLOAT NULL DEFAULT NULL,\n" +
                            "  `Description` LONGTEXT NULL DEFAULT NULL,\n" +
                            "  PRIMARY KEY (`Id`),\n" +
                            "  UNIQUE INDEX `Name_AddressId_UNIQUE` (`Name` ASC, `AddressId` ASC),\n" +
                            "  INDEX `FK_Addresses_ShoppingCenters_idx` (`AddressId` ASC),\n" +
                            "  CONSTRAINT `FK_Addresses_ShoppingCenters`\n" +
                            "    FOREIGN KEY (`AddressId`)\n" +
                            "    REFERENCES `meshchenko`.`addr_addresses` (`Id`)\n" +
                            "    ON DELETE NO ACTION\n" +
                            "    ON UPDATE NO ACTION)\n" +
                            "ENGINE = InnoDB\n" +
                            "DEFAULT CHARACTER SET = utf8;")
            );
            statement.executeUpdate(
                    String.format("CREATE TABLE IF NOT EXISTS `meshchenko`.`ls_rooms` (\n" +
                            "  `Id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                            "  `Name` VARCHAR(255) NOT NULL,\n" +
                            "  `Square` FLOAT NULL DEFAULT NULL,\n" +
                            "  `ShoppingCenterId` INT(11) NOT NULL,\n" +
                            "  PRIMARY KEY (`Id`),\n" +
                            "  UNIQUE INDEX `Name_ShoppingCenterId_UNIQUE` (`Name` ASC, `ShoppingCenterId` ASC),\n" +
                            "  INDEX `FK_ShoppingCenters_Rooms_idx` (`ShoppingCenterId` ASC),\n" +
                            "  CONSTRAINT `FK_ShoppingCenters_Rooms`\n" +
                            "    FOREIGN KEY (`ShoppingCenterId`)\n" +
                            "    REFERENCES `meshchenko`.`ls_shoppingcenters` (`Id`))\n" +
                            "ENGINE = InnoDB\n" +
                            "DEFAULT CHARACTER SET = utf8;")
            );
            statement.executeUpdate(
                    String.format("CREATE TABLE IF NOT EXISTS `meshchenko`.`ls_leaserooms` (\n" +
                            "  `Id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                            "  `Price` FLOAT NULL DEFAULT NULL,\n" +
                            "  `DateStartLease` DATETIME NULL DEFAULT NULL,\n" +
                            "  `DateStopLease` DATETIME NULL DEFAULT NULL,\n" +
                            "  `RoomId` INT(11) NOT NULL,\n" +
                            "  `UserId` INT(11) NOT NULL COMMENT 'owner of room',\n" +
                            "  PRIMARY KEY (`Id`),\n" +
                            "  INDEX `FK_Rooms_LeaseRooms_idx` (`RoomId` ASC),\n" +
                            "  INDEX `FK_Users_LeaseRooms_idx` (`UserId` ASC),\n" +
                            "  CONSTRAINT `FK_Rooms_LeaseRooms`\n" +
                            "    FOREIGN KEY (`RoomId`)\n" +
                            "    REFERENCES `meshchenko`.`ls_rooms` (`Id`)\n" +
                            "    ON DELETE CASCADE\n" +
                            "    ON UPDATE CASCADE,\n" +
                            "  CONSTRAINT `FK_Users_LeaseRooms`\n" +
                            "    FOREIGN KEY (`UserId`)\n" +
                            "    REFERENCES `meshchenko`.`crm_users` (`Id`))\n" +
                            "ENGINE = InnoDB\n" +
                            "DEFAULT CHARACTER SET = utf8;")
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void addData() throws SQLException{

        DAO dao = DAO.getInstance();

        // crm_roles - добавляем роли
        Role roleAdmin = new Role(0,"admin");
        Role roleManager = new Role(0,"manager");
        Role roleUser = new Role(0,"user");
        dao.role.create(roleAdmin);
        dao.role.create(roleManager);
        dao.role.create(roleUser);

        // crm_users - добавляем пользователей

        User user = new User(0,"Admin","123456789",null,
                "admin@admin.com",false, roleAdmin.getId());
        dao.user.create(user);

        User userManager = new User(0,"Manager","123456789","+375295303445",
                "manager@mail.com",false, roleManager.getId());
        dao.user.create(userManager);

        user = new User(0,"user1","123456789",null,
                "user1@gmail.com",false, roleUser.getId());
        dao.user.create(user);

        // addr_countries - добавляем страны

        Country country = new Country(0,"Belarus");
        dao.country.create(country);

        // addr_cities - добавляем города
        City city = new City(0,"Minsk",country.getId());
        dao.city.create(city);

        // addr_cities - добавляем улицы
        //Pobeditelei
        //Prititskogo
        Street street1 = new Street(0,"Pobeditelei",city.getId());
        dao.street.create(street1);
        Street street2 = new Street(0,"Prititskogo",city.getId());
        dao.street.create(street2);

        // addr_addresses - добавляем адреса
        //Pobeditelei 65
        //Prititskogo 29
        Address address1 = new Address(0, street1.getId(), "65");
        dao.address.create(address1);

        Address address2 = new Address(0, street2.getId(), "29");
        dao.address.create(address2);

        // ls_shoppingcenters - добавляем торговые центры
        // Zamok //53.9307475,27.5178348
        // Tivalli 53.908061, 27.484856
        ShoppingCenter shoppingCenter1 = new ShoppingCenter(0, "Zamok", address1.getId(),
                53.9307475f, 27.5178348f,
                "Торговый центр Замок – новый уровень шопинга и развлечений! К вашим услугам" +
                        " - магазины, кафе и рестораны, ледовый каток, кинотеатр, детский зал.");
        dao.shoppingCenter.create(shoppingCenter1);

        ShoppingCenter shoppingCenter2 = new ShoppingCenter(0, "Tivalli", address2.getId(),
                53.908061f, 27.484856f,
                "Современный Многофункциональный Торгово-Развлекательный Бизнес Комплекс. " +
                        "Представляет собой мощный проект, подчёркивающий современный этап развития" +
                        " Минска в качестве столицы европейского государства.");
        dao.shoppingCenter.create(shoppingCenter2);

        // ls_rooms - добавляем помещения
        Room room = new Room(0, "A24", 524.6f, shoppingCenter1.getId());
        dao.room.create(room);
        dao.leaseRoom.create(new LeaseRoom(0, 555f,
                new Date(new java.util.Date().getTime()),
                null,
                room.getId(),
                userManager.getId()));

        room = new Room(0, "B67", 324.4f, shoppingCenter1.getId());
        dao.room.create(room);
        dao.leaseRoom.create(new LeaseRoom(0, 450f,
                null,
                null,
                room.getId(),
                userManager.getId()));

        room = new Room(0, "C31", 724.4f, shoppingCenter2.getId());
        dao.room.create(room);
        dao.leaseRoom.create(new LeaseRoom(0, 1500f,
                null,
                null,
                room.getId(),
                userManager.getId()));

        room = new Room(0, "D15", 224.4f, shoppingCenter2.getId());
        dao.room.create(room);
        dao.leaseRoom.create(new LeaseRoom(0, 300f,
                null,
                null,
                room.getId(),
                userManager.getId()));

    }

    public static void main(String[] args) throws SQLException{
        delete();
        init();
       addData();
    }
}
