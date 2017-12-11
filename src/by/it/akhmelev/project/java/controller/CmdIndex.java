package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

class CmdIndex extends AbstractAction {

    public static void main(String[] args) {
        try {
            System.out.println(
                    DAO.getInstance().ad.getAll("")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ICommand execute(HttpServletRequest req) {
        try {
            int start = 0;
            if (req.getParameter("start")!=null)
            try {
                start = FormValidator.getInt(req, "start");
            } catch (ParseException e) {
            }
            req.setAttribute(
                    "ads",
                    DAO.getInstance().ad.getAll(String.format(" LIMIT %s,10",start))
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
