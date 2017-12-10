package by.it.meshchenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        return null;
    }

}
