package by.it.halai.jd03_03.dao;

import by.it.halai.jd03_03.beans.Ad;
import by.it.halai.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdsDAO extends AbstractDAO implements InterfaceDAO<Ad> {

    @Override
    public boolean create(Ad ad) throws SQLException {
        String createAdSQL = String.format(
                "insert into ads(Name,Genre,Number_Of_Players,price,Description,FK_Users) values('%s','%s',%d,%f,'%s',%d,);",
                ad.getName(), ad.getGenre(), ad.getNumber_Of_Players(), ad.getPrice(), ad.getDescription(), ad.getFK_Users());
        int id = executeCreate(createAdSQL);
        if (id > 0) ad.setID(id);
        return (id > 0);
    }

    @Override
    public boolean update(Ad ad) throws SQLException {
        String updateAdSQL = String.format(
                "UPDATE ads SET Name = '%s', Genre = '%s', Number_Of_Players=%d, price=%f, Description = '%s', FK_Users=%d WHERE ads.ID = %d",
                ad.getName(), ad.getGenre(), ad.getNumber_Of_Players(), ad.getPrice(), ad.getDescription(), ad.getFK_Users(), ad.getID());
        return executeUpdate(updateAdSQL);
    }

    @Override
    public boolean delete(Ad ad) throws SQLException {
        String deleteAdSQL = String.format("DELETE FROM ads WHERE ads.ID = %d", ad.getID());
        return executeUpdate(deleteAdSQL);
    }

    @Override
    public Ad read(Ad ad) throws SQLException {
        return getAll("where ID=" + ad.getID()).get(0);
    }

    @Override
    public Ad read(int id) throws SQLException {
        List<Ad> ads = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (ads.size() > 0) {
            return ads.get(0);
        } else
            return null;
    }


    @Override
    public List<Ad> getAll() throws SQLException {
        return getAll("");
    }


    @Override
    public List<Ad> getAll(String WhereAndOrder) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        String readAdSQL = "SELECT * FROM ads " + WhereAndOrder;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readAdSQL);
            while (resultSet.next()) {
                Ad tmpAd = new Ad(
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Genre"),
                        resultSet.getInt("Number_Of_Players"),
                        resultSet.getDouble("price"),
                        resultSet.getString("Description"),
                        resultSet.getInt("FK_roles"));
                ads.add(tmpAd);
            }
        }
        return ads;
    }
}
