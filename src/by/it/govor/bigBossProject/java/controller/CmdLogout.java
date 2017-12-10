package by.it.govor.bigBossProject.java.controller;


import by.it.govor.bigBossProject.java.dao.DAO;
import by.it.govor.bigBossProject.java.table.Ad;
import by.it.govor.bigBossProject.java.table.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdLogout extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest req) {
        if (FormValidator.isPost(req)){
            req.getSession().invalidate();
            return Actions.LOGIN.command;
        }

        User user= Utils.getUserFromSession(req);
        if (user==null) return Actions.LOGIN.command;

        try {
            DAO dao=DAO.getInstanceAd();
            List<Ad> ads=dao.ad.getRead(" where FK_Users="+user.getId());
            req.setAttribute("ads",ads);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
