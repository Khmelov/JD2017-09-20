package by.it.meshchenko.project.java.controller.Admin;

import by.it.meshchenko.project.java.beans.User;
import by.it.meshchenko.project.java.beans.View.Admin.AdmUsersView;
import by.it.meshchenko.project.java.bll.Admin.ConstructorAdmUsersView;
import by.it.meshchenko.project.java.controller.*;
import by.it.meshchenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdAdmUsers extends AbstractAction {

    private String _jsp = Pages.adm_users;
    private String _cmd = Pages.cmdadmusers;

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
        DAO dao = DAO.getInstance();
        if(user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            // POST
            if (MyRequest.isPost(req)){
                return Actions.ADMUSERS.command;
            }
            // GET
            else if (MyRequest.isGet(req)) {
                AdmUsersView tempView = ConstructorAdmUsersView.creator(dao);
                req.setAttribute("admUsersView", tempView);
            }
        }
        else {
            req.setAttribute(Messages.ERROR, "Not active session ");
            return Actions.SIGNIN.command;
        }
        return null;
    }
}
