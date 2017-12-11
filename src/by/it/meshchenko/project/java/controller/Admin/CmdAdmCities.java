package by.it.meshchenko.project.java.controller.Admin;

import by.it.meshchenko.project.java.beans.City;
import by.it.meshchenko.project.java.beans.User;
import by.it.meshchenko.project.java.beans.View.Admin.AdmCitiesView;
import by.it.meshchenko.project.java.bll.Admin.ConstructorAdmCitiesView;
import by.it.meshchenko.project.java.controller.*;
import by.it.meshchenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdAdmCities extends AbstractAction {

    private String _jsp = Pages.adm_cities;
    private String _cmd = Pages.cmdadmcities;

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
            DAO dao = DAO.getInstance();
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            // POST
            if (MyRequest.isPost(req)){
                City tempForm = new City();
                try {
                    tempForm.setId(MyRequest.getInt(req, "id"));
                    tempForm.setName(MyRequest.getParam(req, "name", Patterns.TEXT));
                    tempForm.setCountryId(MyRequest.getInt(req, "countryId"));
                    if (req.getParameter("create") != null)
                        dao.city.create(tempForm);
                    if (req.getParameter("update") != null)
                        dao.city.update(tempForm);
                    if (req.getParameter("delete") != null)
                        dao.city.delete(tempForm);
                } catch (Exception e) {
                    session.setAttribute(Messages.ERROR, e.getMessage());
                }
                return Actions.ADMCITIES.command;
            }
            // GET
            else if (MyRequest.isGet(req)) {
                AdmCitiesView tempView = ConstructorAdmCitiesView.creator(dao);
                req.setAttribute("admCitiesView", tempView);
            }
        }
        else {
            req.setAttribute(Messages.ERROR, "Not active session ");
            return Actions.SIGNIN.command;
        }
        return null;
    }
}
