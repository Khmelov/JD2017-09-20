package by.it.meshchenko.project.java.controller.Admin;

import by.it.meshchenko.project.java.beans.Address;
import by.it.meshchenko.project.java.beans.Street;
import by.it.meshchenko.project.java.beans.User;
import by.it.meshchenko.project.java.beans.View.Admin.AdmAddressesView;
import by.it.meshchenko.project.java.beans.View.Admin.AdmStreetsView;
import by.it.meshchenko.project.java.bll.Admin.ConstructorAdmAddressesView;
import by.it.meshchenko.project.java.bll.Admin.ConstructorAdmStreetsView;
import by.it.meshchenko.project.java.controller.*;
import by.it.meshchenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdAdmAddresses extends AbstractAction {

    private String _jsp = Pages.adm_addresses;
    private String _cmd = Pages.cmdadmaddresses;

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
                Address tempForm = new Address();
                try {
                    tempForm.setId(MyRequest.getInt(req, "id"));
                    tempForm.setBuildingNumberStr(MyRequest.getParam(req, "buildingNumberStr", Patterns.TEXT));
                    tempForm.setStreetId(MyRequest.getInt(req, "streetId"));
                    if (req.getParameter("create") != null)
                        dao.address.create(tempForm);
                    if (req.getParameter("update") != null)
                        dao.address.update(tempForm);
                    if (req.getParameter("delete") != null)
                        dao.address.delete(tempForm);
                } catch (Exception e) {
                    session.setAttribute(Messages.ERROR, e.getMessage());
                }
                return Actions.ADMADDRESSES.command;
            }
            // GET
            else if (MyRequest.isGet(req)) {
                AdmAddressesView tempView = ConstructorAdmAddressesView.creator(dao);
                req.setAttribute("admAddressesView", tempView);
            }
        }
        else {
            session.setAttribute(Messages.ERROR, "Not active session ");
            return Actions.SIGNIN.command;
        }
        return null;
    }
}
