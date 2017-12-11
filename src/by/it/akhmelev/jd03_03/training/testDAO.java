package by.it.akhmelev.jd03_03.training;

import by.it.akhmelev.jd03_03.training.beans.User;
import by.it.akhmelev.jd03_03.training.dao.DAO;

import java.sql.SQLException;

public class testDAO {
    private static DAO dao;

    private static void log(String prefix) throws SQLException {
        System.out.println(prefix+dao.user.getAll());
    }

    public static void main(String[] args) throws SQLException {
        dao= DAO.getInstance();
        User user=new User(0,"Login","Login","Login", 2);
        log("1.");

        dao.user.create(user);
        log("2.");

        user.setLogin("jhghjasdg");
        dao.user.update(user);
        log("3.");

        dao.user.delete(user);
        log("4.");

    }
}
