package by.it.halai.jd03_02.crud;

import by.it.halai.jd03_02.ConnectionCreator;
import by.it.halai.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class RolesCRUD {

    public Role create(Role role) throws SQLException {
        role.setID(0);

        String createRolesSQL = String.format(
                "insert into roles(role) values('%s');", role.getRole()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement() //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (1 == statement.executeUpdate(createRolesSQL, RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    role.setID(id);
                }
            }
        }
        return role;
    }

    public Role read(int id) throws SQLException {
        Role roleResult = null;
        String readRoleSQL = "SELECT * FROM roles where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readRoleSQL);
            if (resultSet.next()) {
                roleResult = new Role(
                        resultSet.getInt("ID"),
                        resultSet.getString("role"));
            }
        }
        return roleResult;
    }

    public Role update(Role role) throws SQLException {
        Role roleResult = null;
        String updateRoleSQL = String.format(
                "UPDATE roles SET role = '%s' WHERE roles.ID = %d",
                role.getRole(), role.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateRoleSQL) == 1)
                roleResult = role;
        }
        return roleResult;
    }

    public boolean delete(Role role) throws SQLException {
        String deleteRoleSQL = String.format("DELETE FROM roles WHERE roles.ID = %d", role.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteRoleSQL) == 1);
        }
    }


}
