package by.it.halai.project.java.dao;

import by.it.halai.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class AbstractDAO {
    /**
     * return id or -1 (fail)
     */
    int executeCreate(String sql) throws SQLException {
        int result = -1;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                keys.next();
                result = keys.getInt(1);
            }
        }
        return result;
    }

    boolean executeUpdate(String sql) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            return 1 == statement.executeUpdate(sql);
        }
    }


}
