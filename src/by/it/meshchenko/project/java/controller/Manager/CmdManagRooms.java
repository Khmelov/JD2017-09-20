package by.it.meshchenko.project.java.controller.Manager;

import by.it.meshchenko.project.java.beans.*;
import by.it.meshchenko.project.java.beans.View.Admin.AdmShoppingCentersView;
import by.it.meshchenko.project.java.beans.View.Manager.ManagRoomView;
import by.it.meshchenko.project.java.bll.Admin.ConstructorAdmShoppingCentersView;
import by.it.meshchenko.project.java.bll.ConstructorShoppingCentersFull;
import by.it.meshchenko.project.java.bll.Manager.ConstructorManagRoomsView;
import by.it.meshchenko.project.java.controller.*;
import by.it.meshchenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

public class CmdManagRooms extends AbstractAction {

    private String _jsp = Pages.manag_rooms;
    private String _cmd = Pages.cmdmanagrooms;

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
                LeaseRoom tempLeaseRoom = new LeaseRoom();
                try {
                    tempForm.setId(MyRequest.getInt(req, "id"));
                    tempForm.setName(MyRequest.getParam(req, "name", Patterns.TEXT));
                    tempForm.setSquare(MyRequest.getFloat(req, "square"));
                    tempForm.setShoppingCenterId(MyRequest.getInt(req, "shoppingCenterId"));
                    tempLeaseRoom.setId(MyRequest.getInt(req, "leaseId"));
                    tempLeaseRoom.setPrice(MyRequest.getFloat(req, "price"));
                    tempLeaseRoom.setUserId(user.getId());
                    tempLeaseRoom.setRoomId(tempForm.getId());

                    if (req.getParameter("update") != null) {
                        dao.room.update(tempForm);
                        dao.leaseRoom.update(tempLeaseRoom);
                    }
                    if (req.getParameter("delete") != null) {
                        dao.leaseRoom.delete(tempLeaseRoom);
                        dao.room.delete(tempForm);
                    }
                    if (req.getParameter("btnstartLease") != null) {
                        tempLeaseRoom.setDateStartLease(new Date(new java.util.Date().getTime()));
                        dao.leaseRoom.update(tempLeaseRoom);
                    }
                    if (req.getParameter("btnstopLease") != null
                            && dao.leaseRoom.read(tempLeaseRoom.getId()).getDateStartLease() != null) {
                        tempLeaseRoom.setDateStopLease(new Date(new java.util.Date().getTime()));
                        dao.leaseRoom.update(tempLeaseRoom);
                    }
                } catch (Exception e) {
                    session.setAttribute(Messages.ERROR, e.getMessage());
                }
                return Actions.MANAGROOMS.command;
            }
            // GET
            else if (MyRequest.isGet(req)) {
                List<ShoppingCenterFull> tempView1 = ConstructorShoppingCentersFull.creator(dao);
                List<ManagRoomView> tempView2 = ConstructorManagRoomsView.creator(dao, user);
                req.setAttribute("ListShoppingCenterFull", tempView1);
                req.setAttribute("ListManagRoomView", tempView2);
            }
        }
        else {
            session.setAttribute(Messages.ERROR, "Not active session ");
            return Actions.SIGNIN.command;
        }
        return null;
    }

}
