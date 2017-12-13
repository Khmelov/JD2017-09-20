package by.it.halai.jd03_03.dao;

import by.it.halai.jd03_03.beans.Role;
import by.it.halai.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RolesDAO extends AbstractDAO implements InterfaceDAO<Role> {

    @Override
    public boolean create(Role role) throws SQLException {
        String createRoleSQL = String.format(
                "insert into roles(role) values('%s');", role.getRole()
        );
        int id = executeCreate(createRoleSQL);
        if (id > 0) role.setID(id);
        return (id > 0);
    }

    @Override
    public boolean update(Role role) throws SQLException {
        String updateRoleSQL = String.format(
                "UPDATE roles SET role = '%s' WHERE roles.ID = %d",
                role.getRole(), role.getID()
        );
        return executeUpdate(updateRoleSQL);
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        String deleteRoleSQL = String.format("DELETE FROM roles WHERE roles.ID = %d", role.getID());
        return executeUpdate(deleteRoleSQL);
    }

    @Override
    public Role read(Role role) throws SQLException {
        return getAll("where ID=" + role.getID()).get(0);
    }

    @Override
    public Role read(int id) throws SQLException {
        List<Role> role = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (role.size() > 0) {
            return role.get(0);
        } else
            return null;
    }

    @Override
    public List<Role> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Role> getAll(String WhereAndOrder) throws SQLException {
        List<Role> roles = new ArrayList<>();
        String readRoleSQL = "SELECT * FROM roles " + WhereAndOrder;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readRoleSQL);
            while (resultSet.next()) {
                Role tmpRole = new Role(
                        resultSet.getInt("ID"),
                        resultSet.getString("Role"));
                roles.add(tmpRole);
            }
        }
        return roles;
    }
}