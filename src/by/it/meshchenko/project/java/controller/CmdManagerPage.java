package by.it.meshchenko.project.java.controller;

import by.it.meshchenko.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdManagerPage extends AbstractAction {
    private String _jsp = Pages.managerpage;
    private String _cmd = Pages.cmdmanagerpage;

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
        User user = Utils.getUserFromSession(req);
        if(user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
        }
        else {
            req.setAttribute(Messages.ERROR, "Not active session ");
            return Actions.SIGNIN.command;
        }
        return null;
    }

}
