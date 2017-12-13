package by.it.halai.project.java.controller;

import by.it.halai.project.java.beans.User;
import by.it.halai.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdEditUsers extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest req) {
        try {
            DAO dao = DAO.getInstance();
            if (FormValidator.isPost(req)) {
                User user = new User();
                try {
                    user.setID(FormValidator.getInt(req, "ID"));
                    user.setLogin(FormValidator.getString(req, "Login", Patterns.LOGIN));
                    user.setEmail(FormValidator.getString(req, "Email", Patterns.EMAIL));
                    user.setPassword(FormValidator.getString(req, "Password", Patterns.PASSWORD));
                    user.setFK_roles(FormValidator.getInt(req, "FK_roles"));
                    if (req.getParameter("Update") != null)
                        dao.user.update(user);
                    if (req.getParameter("Delete") != null)
                        dao.user.delete(user);
                } catch (Exception e) {
                    req.setAttribute(Messages.ERROR, e.getMessage());
                }
            }
            req.setAttribute("users", DAO.getInstance().user.getAll());
        } catch (SQLException e) {
            req.setAttribute(Messages.ERROR, e.toString());
        }

        return null;
    }

}
