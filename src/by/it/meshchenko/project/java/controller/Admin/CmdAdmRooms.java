package by.it.meshchenko.project.java.controller.Admin;

import by.it.meshchenko.project.java.controller.AbstractAction;
import by.it.meshchenko.project.java.controller.ICommand;
import by.it.meshchenko.project.java.controller.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdAdmRooms extends AbstractAction {

    private String _jsp = Pages.adminpage;
    private String _cmd = Pages.cmdadminpage;

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
