package by.it.akhmelev.jd03_03.training.dao;

import by.it.akhmelev.jd03_03.training.beans.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO implements InterfaceDAO<User> {

    UserDAO() {}

    @Override
    public boolean create(User user) throws SQLException {
        String createUserSQL = String.format(
                "insert into users(Login,Password,Email,FK_roles) values('%s','%s','%s',%d);",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_Role()
        );
        int id = super.executeCreate(createUserSQL);
        if (id > 0) {
            user.setId(id);
            return true;
        } else
            return false;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String updateUserSQL = String.format(
                "UPDATE users SET Login = '%s', Password = '%s', Email = '%s', FK_roles=%d WHERE users.ID = %d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_Role(), user.getId()
        );
        return super.executeUpdate(updateUserSQL);
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM users WHERE users.ID = %d", user.getId());
        return super.executeUpdate(deleteUserSQL);
    }

    @Override
    public User read(int id) throws SQLException {
        User userResult = null;
        String readUserSQL = String.format("SELECT * FROM users where ID=%d", id);
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readUserSQL);
            if (resultSet.next()) {
                userResult = new User(
                        resultSet.getInt("ID"),
                        resultSet.getString("Login"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getInt("FK_roles"));
            }
        }
        return userResult;
    }

    @Override
    public List<User> getAll(String where) throws SQLException {
        List<User> userList = new ArrayList<>();
        String readUserSQL = String.format("SELECT * FROM users %s", where);
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readUserSQL);
            while (resultSet.next()) {
                userList.add(new User(
                        resultSet.getInt("ID"),
                        resultSet.getString("Login"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getInt("FK_roles"))
                );
            }
        }
        return userList;
    }

    @Override
    public List<User> getAll() throws SQLException {
        return getAll("");
    }

}
