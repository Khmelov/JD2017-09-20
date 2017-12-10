package by.it.meshchenko.project.java.controller;


import by.it.meshchenko.project.java.beans.User;
import by.it.meshchenko.project.java.dao.DB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CmdResetDB extends AbstractAction {

    private String _jsp = Pages.resetdb;
    private String _cmd = Pages.cmdresetdb;

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
            User user = Utils.getUserFromSession(req);
            try {
                DB.reset();
                req.setAttribute(Messages.MESSAGE, "db reset");
                if(user.getPassword().compareTo("admin@admin.com") == 0) {
                    return Actions.LEASE.command;
                }
                else {
                    return Actions.INDEX.command;
                }
            } catch (Exception e) {
                req.getServletContext().log(e.getMessage());
                System.out.println(e.getMessage());
                req.setAttribute(Messages.ERROR, e.getMessage());
            }
        }
        if (MyRequest.isGet(req)){
            //_jsp = "/resetdb.jsp";
        }
        return null;
    }
}
