package by.it.meshchenko.project.java.controller;

import by.it.meshchenko.project.java.beans.User;
import by.it.meshchenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdSignIn  extends AbstractAction {

    private String _jsp = Pages.signin;
    private String _cmd = Pages.cmdsignin;

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
                user.setEmail(MyRequest.getParam(req, "email", Patterns.UserEMAIL));
                user.setPassword(MyRequest.getParam(req, "password", Patterns.UserPASSWORD));

                DAO dao = DAO.getInstance();
                List<User> temp = dao.user.getAll("WHERE Email = '" + user.getEmail()+ "';");
                // user is exist
                if(temp.size() == 1){
                    // password is right
                    if(temp.get(0).getPassword().compareTo(user.getPassword()) == 0){
                        user = temp.get(0);
                        HttpSession session=req.getSession();
                        session.setAttribute("user",user);
                        return Actions.LEASE.command;
                    }
                    else {
                        req.setAttribute(Messages.MESSAGE, "Incorrect password ");
                    }
                }
                else {
                    req.setAttribute(Messages.MESSAGE, "Account is not registered ");
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
