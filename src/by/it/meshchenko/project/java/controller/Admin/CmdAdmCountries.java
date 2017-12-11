package by.it.meshchenko.project.java.controller.Admin;

import by.it.meshchenko.project.java.beans.Country;
import by.it.meshchenko.project.java.beans.User;
import by.it.meshchenko.project.java.controller.*;
import by.it.meshchenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdAdmCountries extends AbstractAction {

    private String _jsp = Pages.adm_countries;
    private String _cmd = Pages.cmdadmcountries;

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
                Country tempForm = new Country();
                try {
                    tempForm.setId(MyRequest.getInt(req, "id"));
                    tempForm.setName(MyRequest.getParam(req, "name", Patterns.TEXT));
                    if (req.getParameter("create") != null)
                        dao.country.create(tempForm);
                    if (req.getParameter("update") != null)
                        dao.country.update(tempForm);
                    if (req.getParameter("delete") != null)
                        dao.country.delete(tempForm);
                } catch (Exception e) {
                    req.setAttribute(Messages.ERROR, e.getMessage());
                }
                return Actions.ADMCOUNTRIES.command;
            }
            // GET
            else if (MyRequest.isGet(req)) {
                List<Country> tempView = dao.country.getAll("");
                req.setAttribute("admCountryView", tempView);
            }
        }
        else {
            req.setAttribute(Messages.ERROR, "Not active session ");
            return Actions.SIGNIN.command;
        }
        return null;
    }
}
