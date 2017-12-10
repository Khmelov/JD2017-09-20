package by.it.govor.bigBossProject.java.controller;


import by.it.govor.bigBossProject.java.dao.DAO;
import by.it.govor.bigBossProject.java.table.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdEditUsers extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest req) {
        try {
            DAO dao=DAO.getInstanceUser();
            if (FormValidator.isPost(req)) {
                User user = new User();
                try {
                    user.setLogin(FormValidator.getString(req, "login", Patterns.LOGIN));
                    user.setPassword(FormValidator.getString(req, "password", Patterns.PASSWORD));
                    user.setName(FormValidator.getString(req, "name", Patterns.NAME));
                    user.setNick(FormValidator.getString(req, "nick", Patterns.NICK));
                    user.setTelephone(FormValidator.getInt(req, "Telephone"));
                    user.setRole_ID(FormValidator.getInt(req, "fk_Roles"));
                    if (req.getParameter("Update") != null)
                        dao.user.update(user);
                    if (req.getParameter("Delete") != null)
                        dao.user.delete(user);
                } catch (Exception e) {
                    req.setAttribute(Messages.ERROR, e.getMessage());
                }
            }
            req.setAttribute("user", DAO.getInstanceUser().user.getRead("*"));
        } catch (SQLException e) {
            req.setAttribute(Messages.ERROR, e.toString());
        }

        return null;
    }

}
