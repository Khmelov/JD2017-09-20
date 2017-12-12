package by.it.meshchenko.project.java.controller.Admin;

import by.it.meshchenko.project.java.beans.ShoppingCenter;
import by.it.meshchenko.project.java.beans.Street;
import by.it.meshchenko.project.java.beans.User;
import by.it.meshchenko.project.java.beans.View.Admin.AdmShoppingCentersView;
import by.it.meshchenko.project.java.beans.View.Admin.AdmStreetsView;
import by.it.meshchenko.project.java.bll.Admin.ConstructorAdmShoppingCentersView;
import by.it.meshchenko.project.java.bll.Admin.ConstructorAdmStreetsView;
import by.it.meshchenko.project.java.controller.*;
import by.it.meshchenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdAdmShoppingCenters extends AbstractAction {

    private String _jsp = Pages.adm_shoppingcenters;
    private String _cmd = Pages.cmdadmshoppingcenters;

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
        HttpSession session = req.getSession();
        User user = Utils.getUserFromSession(req);
        if(user != null) {
            DAO dao = DAO.getInstance();
            session.setAttribute("user", user);

            // POST
            if (MyRequest.isPost(req)){
                ShoppingCenter tempForm = new ShoppingCenter();
                try {
                    tempForm.setId(MyRequest.getInt(req, "id"));
                    tempForm.setName(MyRequest.getParam(req, "name", Patterns.TEXT));
                    tempForm.setAddressId(MyRequest.getInt(req, "addressId"));
                    tempForm.setLat(MyRequest.getFloat(req, "lat"));
                    tempForm.setLng(MyRequest.getFloat(req, "lng"));
                    tempForm.setDescription(MyRequest.getParam(req,"description" ,Patterns.TEXT));
                    if (req.getParameter("create") != null)
                        dao.shoppingCenter.create(tempForm);
                    if (req.getParameter("update") != null)
                        dao.shoppingCenter.update(tempForm);
                    if (req.getParameter("delete") != null)
                        dao.shoppingCenter.delete(tempForm);
                } catch (Exception e) {
                    session.setAttribute(Messages.ERROR, e.getMessage());
                }
                return Actions.ADMSHOPPINGCENTERS.command;
            }
            // GET
            else if (MyRequest.isGet(req)) {
                AdmShoppingCentersView tempView = ConstructorAdmShoppingCentersView.creator(dao);
                req.setAttribute("admShoppingCentersView", tempView);
            }
        }
        else {
            session.setAttribute(Messages.ERROR, "Not active session ");
            return Actions.SIGNIN.command;
        }
        return null;
    }
}
