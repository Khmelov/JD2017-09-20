package by.it.shelkovich.project.java.actions;

import by.it.shelkovich.project.java.Hash;
import by.it.shelkovich.project.java.dao.DAO;
import by.it.shelkovich.project.java.dao.entities.User;
import by.it.shelkovich.project.java.servlets.RequestUtils;
import by.it.shelkovich.project.java.servlets.ValidatePatterns;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdProfile extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest request) {
        if (RequestUtils.isPost(request)) {
            DAO dao = DAO.getInstance();
            try {
                User sessionUser = (User)request.getSession().getAttribute("user");
                User user = new User();
                user.setId(sessionUser.getId());

                if (request.getParameter("delete") != null){
                    dao.userDAO.delete(sessionUser.getId());
                    request.getSession().setAttribute("user", null);
                    return Actions.MAIN.command;
                }

                if (request.getParameter("update") != null) {
                    user.setRole_id(sessionUser.getRole_id());
                    user.setUsername(RequestUtils.validate(request.getParameter("username"), ValidatePatterns.USERNAME));

                    String password = request.getParameter("password");
                    if (password == null) user.setPassHash(sessionUser.getPassHash());
                    else user.setPassHash(Hash.md5(password));

                    user.setEmail(RequestUtils.validate(request.getParameter("email"), ValidatePatterns.EMAIL));

                    String checkbox = request.getParameter("showPersonalData");
                    if ("1".equals(checkbox)) user.setShowPersonalData(true);
                    else user.setShowPersonalData(false);

                    user.setDescription(RequestUtils.validate(request.getParameter("description"), ValidatePatterns.DESCRIPTION));
                    user.setName(RequestUtils.validate(request.getParameter("name"), ValidatePatterns.NAME));
                    user.setSurname(RequestUtils.validate(request.getParameter("surname"), ValidatePatterns.SURNAME));


                    dao.userDAO.update(user);
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return Actions.ERROR.command;
            }
        } else {
            return null;
        }
    }
}
