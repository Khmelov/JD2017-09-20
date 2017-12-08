package by.it.ali.project.java.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends AbstractDAO implements InDAO<Role> {
    private static final String URL_DB = "jdbc:mysql://127.0.0.1:2016/ali";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";
    static {
        try { //регистрируем драйвер
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean create(Role role) throws SQLException {
        String createRoleSQL = String.format(
                "insert into roles(Role) values('%s');",
                role.getRole()
        );
        int id=executeUpdate(createRoleSQL);
        if (id>0) role.setId(id);
        return (id>0);
    }

    @Override
    public boolean update(Role role) throws SQLException {
        String updateRoleSQL = String.format(
                "UPDATE roles SET Role = '%s' WHERE roles.ID = %d",
                role.getRole(), role.getId()
        );
        return (0<(executeUpdate(updateRoleSQL)));
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        String deleteRoleSQL = String.format("DELETE FROM roles WHERE roles.ID = %d", role.getId());
        return (0<executeUpdate(deleteRoleSQL));
    }

    @Override
    public Role read(Role role) throws SQLException {
        return getAll("where id="+role.getId()).get(0);
    }

    @Override
    public List<Role> getAll(String WhereAndOreder) throws SQLException {
        List<Role> roles = new ArrayList<>();
        String readRoleSQL = "SELECT * FROM roles " + WhereAndOreder;
        try (
                Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readRoleSQL);
            while (resultSet.next()) {
                Role role = new Role(
                        resultSet.getInt("ID"),
                        resultSet.getString("Role"));
                roles.add(role);
            }
        }
        return roles;
    }
}
