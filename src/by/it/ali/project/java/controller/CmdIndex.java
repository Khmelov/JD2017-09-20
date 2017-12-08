package by.it.ali.project.java.controller;

import by.it.ali.project.java.dao.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdIndex extends AbstractAction{
    public static void main(String[] args) {
        try {
            System.out.println(DAO.getDAO().ticket.getAll(""));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public ICommand execute(HttpServletRequest req) {
        try {
            req.setAttribute("ads", DAO.getDAO().ticket.getAll(""));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
