package by.it.ali.project.java.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketsDAO extends AbstractDAO implements InDAO<Tickets> {
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
    public List<Tickets> getAll(String WhereAndOreder) throws SQLException {
        List<Tickets> tickets = new ArrayList<>();
        String readTicketsSQL = "SELECT * FROM tickets " + WhereAndOreder;
        try (
                Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readTicketsSQL);
            while (resultSet.next()) {
                Tickets ticket = new Tickets(
                        resultSet.getInt("ID"),
                        resultSet.getString("Destination"),
                        resultSet.getString("Company"),
                        resultSet.getString("Date"),
                        resultSet.getInt("Price"),
                        resultSet.getInt("FKusers"));
                tickets.add(ticket);
            }
        }
        return tickets;
    }
    @Override
    public boolean create(Tickets tickets) throws SQLException {
        String createTicketsSQL = String.format(
                "insert into tickets(Destination,Company,Date,Price,FKusers) values('%s','%s','%s',%d,%d);",
                tickets.getDestination(), tickets.getCompany(), tickets.getDate(), tickets.getPrice() ,tickets.getFKusers()
        );
        int id=executeUpdate(createTicketsSQL);
        if (id>0) tickets.setId(id);
        return (id>0);
    }

    @Override
    public boolean update(Tickets tickets) throws SQLException {
        String updateTicketsSQL = String.format(
                "UPDATE tickets SET Destination = '%s', Company = '%s', Date = '%s', Price=%d, FKusers=%d WHERE tickets.ID = %d",
                tickets.getDestination(), tickets.getCompany(), tickets.getDate(), tickets.getPrice() ,tickets.getFKusers(), tickets.getId()
        );
        return (0<(executeUpdate(updateTicketsSQL)));
    }

    @Override
    public boolean delete(Tickets tickets) throws SQLException {
        String deleteTicketsSQL = String.format("DELETE FROM tickets WHERE tickets.ID = %d", tickets.getId());
        return (0<executeUpdate(deleteTicketsSQL));
    }

    @Override
    public Tickets read(Tickets tickets) throws SQLException {
        return getAll("where id="+tickets.getId()).get(0);
    }



}
