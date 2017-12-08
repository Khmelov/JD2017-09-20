package by.it.ali.project.java.controller;

//import by.it.ali.project.java.controller.*;
import by.it.ali.project.java.dao.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin extends AbstractAction{
    @Override
    public ICommand execute(HttpServletRequest req) {

        if (FormValidator.isPost(req)){
            User user=new User();
            try {
                user.setLogin(FormValidator.getString(req, "login", Patterns.LOGIN));
                user.setPassword(FormValidator.getString(req, "password", Patterns.PASSWORD));
                DAO dao= DAO.getDAO();
                List<User> users=dao.user.getAll(
                        String.format(" WHERE login='%s' AND password='%s'",
                                user.getLogin(),
                                user.getPassword())
                );
                if (users.size()==1){
                    user=users.get(0);
                    HttpSession session=req.getSession();
                    session.setAttribute("user",user);
                    return Actions.PROFILE.command;
                } else {
                    req.setAttribute(Messages.ERROR,"User: "+user.getLogin()+" not found");
                }
                /* TODO session */
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return null;
    }
}
