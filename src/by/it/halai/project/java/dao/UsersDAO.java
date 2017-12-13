package by.it.halai.project.java.dao;

import by.it.halai.project.java.beans.User;
import by.it.halai.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends AbstractDAO implements InterfaceDAO<User> {

    @Override
    public boolean create(User user) throws SQLException {
        String createUserSQL = String.format(
                "insert into users(Login,Password,Email,FK_roles) values('%s','%s','%s',%d);",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFK_roles());
        int id = executeCreate(createUserSQL);
        if (id > 0) user.setID(id);
        return (id > 0);
    }

    @Override
    public boolean update(User user) throws SQLException {
        String updateUserSQL = String.format(
                "UPDATE users SET Login = '%s', Password = '%s', Email = '%s', FK_roles=%d WHERE users.ID = %d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFK_roles(), user.getID());
        return executeUpdate(updateUserSQL);
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM users WHERE users.ID = %d", user.getID());
        return executeUpdate(deleteUserSQL);
    }

    @Override
    public User read(User user) throws SQLException {
        return getAll("where ID=" + user.getID()).get(0);
    }

    @Override
    public User read(int id) throws SQLException {
        List<User> user = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (user.size() > 0) {
            return user.get(0);
        } else
            return null;
    }


    @Override
    public List<User> getAll() throws SQLException {
        return getAll("");
    }


    @Override
    public List<User> getAll(String WhereAndOrder) throws SQLException {
        List<User> users = new ArrayList<>();
        String readUserSQL = "SELECT * FROM users " + WhereAndOrder;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readUserSQL);
            while (resultSet.next()) {
                User tmpUser = new User(
                        resultSet.getInt("ID"),
                        resultSet.getString("Login"),
                        resultSet.getString("Password"),
                        resultSet.getString("Email"),
                        resultSet.getInt("FK_roles"));
                users.add(tmpUser);
            }
        }
        return users;
    }
}
