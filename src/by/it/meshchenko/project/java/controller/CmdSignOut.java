package by.it.meshchenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdSignOut extends AbstractAction {

    private String _jsp = "";
    private String _cmd = Pages.cmdsignout;

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
        req.getSession().invalidate();
        return Actions.SIGNIN.command;
    }
}
