package by.it.meshchenko.project.java.controller;

import by.it.meshchenko.project.java.beans.User;
import by.it.meshchenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdRegister extends AbstractAction {

    private String _jsp = Pages.register;
    private String _cmd = Pages.cmdregister;

    @Override
    public String jsp(){
        return _jsp;
    }
    @Override
    public String cmd(){
        return _cmd;
    }

    @Override
    public ICommand execute(HttpServletRequest req, HttpServletResponse resp) {

        if (MyRequest.isPost(req)){
            User user = new User();
            try {
                DAO dao = DAO.getInstance();
                user.setName(MyRequest.getParam(req, "name", Patterns.UserNAME));
                user.setPhoneNumber(MyRequest.getParam(req, "phone", Patterns.UserPHONE));
                user.setEmail(MyRequest.getParam(req, "email", Patterns.UserEMAIL));
                user.setPassword(MyRequest.getParam(req, "password", Patterns.UserPASSWORD));
                user.setRoleId(dao.role.getAll("WHERE Role = 'user';").get(0).getId());

                List<User> temp = dao.user.getAll("WHERE Email = '" + user.getEmail()+ "';");
                // user is exist
                if(temp.size() == 0) {
                    if(dao.user.create(user)) {
                        HttpSession session=req.getSession();
                        session.setAttribute("user",user);
                        return Actions.LEASE.command;
                    }
                }
                else if (temp.size() == 1){
                    req.setAttribute(Messages.MESSAGE, "Account is already exists ");
                }
            } catch (Exception e) {
                req.getServletContext().log(e.getMessage());
                System.out.println(e.getMessage());
                req.setAttribute(Messages.ERROR, e.getMessage());
            }
        }
        if (MyRequest.isGet(req)){
        }
        return null;
    }
}
