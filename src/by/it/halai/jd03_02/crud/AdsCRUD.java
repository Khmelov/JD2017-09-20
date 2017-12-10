package by.it.halai.jd03_02.crud;

import by.it.halai.jd03_02.beans.Ad;
import by.it.halai.jd03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class AdsCRUD {

    public Ad create(Ad ad) throws SQLException {
        ad.setID(0);
        //формирование строки createAdSQL по данным bean ad
        String createAdSQL = String.format(Locale.ENGLISH,
                "insert into ads(" +
                        "Name," +
                        "Genre," +
                        "Number_Of_Players," +
                        "price," +
                        "Description," +
                        "FK_Users" +
                        ") values('%s','%s',%d,%d,%f,%f,%d,%d);",
                ad.getName(),
                ad.getGenre(),
                ad.getNumber_Of_Players(),
                ad.getPrice(),
                ad.getDescription(),
                ad.getFK_Users());
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement() //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            System.out.println(createAdSQL);

            if (1 == statement.executeUpdate(createAdSQL, RETURN_GENERATED_KEYS)) {
                //если все добавлено то узнаем последний ID
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    //извлекаем из keys последний ID
                    int id = keys.getInt(1);
                    ad.setID(id);
                }
            }
        }
        return ad;
    }

    public Ad read(int id) throws SQLException {
        Ad adResult = null;
        String readAdSQL = "SELECT * FROM ads where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readAdSQL);
            if (resultSet.next()) {
                adResult = new Ad(
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Genre"),
                        resultSet.getInt("Number_Of_Players"),
                        resultSet.getFloat("Price"),
                        resultSet.getString("Description"),
                        resultSet.getInt("FK_Users")
                );
            }
        }
        return adResult;
    }

    public Ad update(Ad ad) throws SQLException {
        Ad adResult = null;
        String updateAdSQL = String.format(Locale.ENGLISH,
                "UPDATE ads " +
                        "SET Name = '%s'," +
                        " Genre = '%s'," +
                        " Number_Of_Players = %d," +
                        " Price = %f," +
                        " Description = %s," +
                        " FK_Users = %d" +
                        " WHERE ads.ID = %d",
                ad.getName(),
                ad.getGenre(),
                ad.getNumber_Of_Players(),
                ad.getPrice(),
                ad.getDescription(),
                ad.getFK_Users(),
                ad.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            System.out.println(updateAdSQL);
            if (statement.executeUpdate(updateAdSQL) == 1)
                adResult = ad;
        }
        return adResult;
    }

    public boolean delete(Ad ad) throws SQLException {
        String deleteAdSQL = String.format("DELETE FROM ads WHERE ads.ID = %d", ad.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteAdSQL) == 1);
        }
    }


}
