package by.it.halai.project.java.controller;

import by.it.halai.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

class CmdIndex extends AbstractAction {

    @Override
    public ICommand execute(HttpServletRequest req) {
        try {
            int start = 0;
            int adStep = 10;
            if (req.getParameter("start") != null)
                try {
                    start = FormValidator.getInt(req, "start");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            DAO dao = DAO.getInstance();
            //тут лучше сделать другой SQL-вызов,
            //который сразу вернет число записей.
            //но потребуется расширение DAO
            int adCount = dao.ad.getAll("").size();
            req.setAttribute("adCount", adCount);
            req.setAttribute("adStep", adStep);
            req.setAttribute("ads", DAO.getInstance().ad.getAll(String.format(" LIMIT %s,10", start))
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
