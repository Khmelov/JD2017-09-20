package by.it.meshchenko.project.java.controller.Admin;

import by.it.meshchenko.project.java.beans.Room;
import by.it.meshchenko.project.java.beans.User;
import by.it.meshchenko.project.java.beans.View.Admin.AdmRoomsView;
import by.it.meshchenko.project.java.bll.Admin.ConstructorAdmRoomsView;
import by.it.meshchenko.project.java.controller.*;
import by.it.meshchenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdAdmRooms extends AbstractAction {

    private String _jsp = Pages.adm_rooms;
    private String _cmd = Pages.cmdadmrooms;

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
                Room tempForm = new Room();
                try {
                    tempForm.setId(MyRequest.getInt(req, "id"));
                    if (req.getParameter("delete") != null)
                        dao.room.delete(tempForm);
                } catch (Exception e) {
                    session.setAttribute(Messages.ERROR, e.getMessage());
                }
                return Actions.ADMROOMS.command;
            }
            // GET
            else if (MyRequest.isGet(req)) {
                AdmRoomsView tempView = ConstructorAdmRoomsView.creator(dao);
                req.setAttribute("admRoomsView", tempView);
            }
        }
        else {
            session.setAttribute(Messages.ERROR, "Not active session ");
            return Actions.SIGNIN.command;
        }
        return null;
    }
}
