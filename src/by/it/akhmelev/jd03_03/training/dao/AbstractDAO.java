package by.it.akhmelev.jd03_03.training.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

abstract class AbstractDAO {

    int executeCreate(String sql) throws SQLException {
        int result = -1;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet resultSet = statement.getGeneratedKeys();
                resultSet.next();
                result = resultSet.getInt(1);
            }
        }
        return result;
    }


    boolean executeUpdate(String sql) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (1==statement.executeUpdate(sql));
        }
    }


}
