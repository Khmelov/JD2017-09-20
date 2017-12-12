package by.it.meshchenko.project.java.controller.Admin;

import by.it.meshchenko.project.java.beans.City;
import by.it.meshchenko.project.java.beans.Street;
import by.it.meshchenko.project.java.beans.User;
import by.it.meshchenko.project.java.beans.View.Admin.AdmCitiesView;
import by.it.meshchenko.project.java.beans.View.Admin.AdmStreetsView;
import by.it.meshchenko.project.java.bll.Admin.ConstructorAdmCitiesView;
import by.it.meshchenko.project.java.bll.Admin.ConstructorAdmStreetsView;
import by.it.meshchenko.project.java.controller.*;
import by.it.meshchenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdAdmStreets extends AbstractAction {

    private String _jsp = Pages.adm_streets;
    private String _cmd = Pages.cmdadmstreets;

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
                Street tempForm = new Street();
                try {
                    tempForm.setId(MyRequest.getInt(req, "id"));
                    tempForm.setName(MyRequest.getParam(req, "name", Patterns.TEXT));
                    tempForm.setCityId(MyRequest.getInt(req, "cityId"));
                    if (req.getParameter("create") != null)
                        dao.street.create(tempForm);
                    if (req.getParameter("update") != null)
                        dao.street.update(tempForm);
                    if (req.getParameter("delete") != null)
                        dao.street.delete(tempForm);
                } catch (Exception e) {
                    session.setAttribute(Messages.ERROR, e.getMessage());
                }
                return Actions.ADMSTREETS.command;
            }
            // GET
            else if (MyRequest.isGet(req)) {
                AdmStreetsView tempView = ConstructorAdmStreetsView.creator(dao);
                req.setAttribute("admStreetsView", tempView);
            }
        }
        else {
            session.setAttribute(Messages.ERROR, "Not active session ");
            return Actions.SIGNIN.command;
        }
        return null;
    }
}
