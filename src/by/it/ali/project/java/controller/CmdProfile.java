package by.it.ali.project.java.controller;
import by.it.ali.project.java.dao.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdProfile extends AbstractAction{
    @Override
    public ICommand execute(HttpServletRequest req) {
        if (FormValidator.isPost(req)){
            req.getSession().invalidate();
            return Actions.LOGIN.command;
        }

        User user=Utils.getUserFromSession(req);
        if (user==null) return Actions.LOGIN.command;

        try {
            DAO dao=DAO.getDAO();
            List<Tickets> ads=dao.ticket.getAll("where FK_Users="+user.getId());
            req.setAttribute("ads",ads);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
