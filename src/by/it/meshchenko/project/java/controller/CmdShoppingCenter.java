package by.it.meshchenko.project.java.controller;

import by.it.meshchenko.project.java.beans.*;
import by.it.meshchenko.project.java.beans.View.ShoppingCenterView;
import by.it.meshchenko.project.java.bll.ConstructorShoppingCenterView;
import by.it.meshchenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdShoppingCenter extends AbstractAction {

    private String _jsp = Pages.shoppingcenter;
    private String _cmd = Pages.cmdshoppingcenter;

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
            return Actions.LEASE.command;
        }

        if (MyRequest.isGet(req)){
            User user = Utils.getUserFromSession(req);
            if(user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);

                try {
                    DAO dao = DAO.getInstance();
                    int id = Integer.valueOf(req.getParameter("id").toUpperCase());
                    if (id > 0) {
                        ShoppingCenterView shv = ConstructorShoppingCenterView.creator(dao, id);
                        req.setAttribute("shoppingCenterView", shv);
                    } else {
                        req.setAttribute(Messages.ERROR, "Not data in database ");
                    }
                } catch (Exception e) {
                    req.getServletContext().log(e.getMessage());
                    System.out.println(e.getMessage());
                    req.setAttribute(Messages.ERROR, e.getMessage());
                }
            }
            else {
                req.setAttribute(Messages.ERROR, "Not active session ");
                return Actions.SIGNIN.command;
            }
        }
        return null;
    }

}
