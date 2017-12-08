package by.it.ali.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import by.it.ali.project.java.dao.*;

class CmdSignup extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest req) {

        if (FormValidator.isPost(req)) {
            User user = new User();
            try {
                user.setLogin(FormValidator.getString(req, "login", Patterns.LOGIN));
                user.setEmail(FormValidator.getString(req, "email", Patterns.EMAIL));
                user.setPassword(FormValidator.getString(req, "password", Patterns.PASSWORD));
                user.setFk_Roles(2);
                DAO dao = DAO.getDAO();
                if (dao.user.getAll("where Login='"+user.getLogin()+"'").size()>0)
                {
                    req.setAttribute(Messages.ERROR, "Такой пользователь уже есть");
                    return null;
                }
                dao.user.create(user);
                req.setAttribute(Messages.MESSAGE, "finish");
                return Actions.LOGIN.command;

            } catch (Exception e) {
                req.getServletContext().log(e.getMessage());
                System.out.println(e.getMessage());
                req.setAttribute(Messages.ERROR, e.getMessage());
            }
        }
        return null;
    }
}
