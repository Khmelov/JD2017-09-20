package by.it.shelkovich.project.java.actions;

import by.it.shelkovich.project.java.Hash;
import by.it.shelkovich.project.java.dao.DAO;
import by.it.shelkovich.project.java.dao.entities.User;
import by.it.shelkovich.project.java.servlets.RequestUtils;
import by.it.shelkovich.project.java.servlets.ValidatePatterns;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdRegister extends AbstractAction{
    @Override
    public ICommand execute(HttpServletRequest request) {
        if (RequestUtils.isPost(request)) {
            DAO dao = DAO.getInstance();
            try {
                User user = new User();
                user.setUsername(RequestUtils.validate(request.getParameter("username"), ValidatePatterns.USERNAME));
                user.setPassHash(Hash.md5(request.getParameter("password")));
                user.setEmail("");


                List<User> users = dao.userDAO.read(user);
                if(users.size()==0) return Actions.ERROR.command;
                HttpSession session = request.getSession();
                session.setAttribute("user", users.get(0));
                return Actions.MAIN.command;
            } catch (Exception e) {
                e.printStackTrace();
                return Actions.ERROR.command;
            }
        } else {
            return null;
        }
    }
}
