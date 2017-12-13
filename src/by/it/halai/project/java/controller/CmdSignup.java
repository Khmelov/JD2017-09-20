package by.it.halai.project.java.controller;

import by.it.halai.project.java.beans.User;
import by.it.halai.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;


class CmdSignup extends AbstractAction {


    @Override
    public ICommand execute(HttpServletRequest req) {

        if (FormValidator.isPost(req)) {
            User user = new User();
            try {
                user.setLogin(FormValidator.getString(req, "Login", Patterns.LOGIN));
                user.setEmail(FormValidator.getString(req, "Email", Patterns.EMAIL));
                user.setPassword(FormValidator.getString(req, "Password", Patterns.PASSWORD));
                user.setFK_roles(2);
                DAO dao = DAO.getInstance();
                if (dao.user.getAll("where Login='" + user.getLogin() + "'").size() > 0) {
                    req.setAttribute(Messages.ERROR, "Такой пользователь уже есть");
                    return null;
                }
                dao.user.create(user);
                req.setAttribute(Messages.MESSAGE, "finish");
                return Actions.LOGIN.command;

            } catch (Exception e) {

                System.out.println(e.getMessage());
                req.setAttribute(Messages.ERROR, e.getMessage());
            }
        }

        return null;
    }

}
