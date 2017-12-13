package by.it.halai.project.java.controller;


import by.it.halai.project.java.beans.Ad;
import by.it.halai.project.java.beans.User;
import by.it.halai.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdProfile extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest req) {
        if (FormValidator.isPost(req)) {
            req.getSession().invalidate();
            return Actions.LOGIN.command;
        }

        User user = Utils.getUserFromSession(req);
        if (user == null) return Actions.LOGIN.command;

        try {
            DAO dao = DAO.getInstance();
            List<Ad> ads = dao.ad.getAll(" where FK_Users=" + user.getID());
            req.setAttribute("ads", ads);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
