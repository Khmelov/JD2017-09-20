package by.it.meshchenko.project.java.controller;

import by.it.meshchenko.project.java.beans.View.LeaseView;
import by.it.meshchenko.project.java.beans.User;
import by.it.meshchenko.project.java.bll.ConstructorLeaseView;
import by.it.meshchenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLease extends AbstractAction {

    private String _jsp = Pages.home;
    private String _cmd = Pages.cmdlease;

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
                    List<LeaseView> lv = ConstructorLeaseView.creator(dao);
                    if (lv != null) req.setAttribute("leaseview", lv);
                    else req.setAttribute(Messages.MESSAGE, "Not data in database ");
                } catch (Exception e) {
                    req.getServletContext().log(e.getMessage());
                    System.out.println(e.getMessage());
                    req.setAttribute(Messages.ERROR, e.getMessage());
                }
            }
            else {
                req.setAttribute(Messages.ERROR, "Not active session ");
            }
        }
        return null;
    }

//    public static void main(String[] args){
//        DAO dao = DAO.getInstance();
//        List<ShoppingCenter> temp = dao.shoppingCenter
//                .getAll("");
//        for(ShoppingCenter sh : temp){
//
//
//            int count = dao.room.getAll("WHERE ShoppingCenterId="+ sh.getId()).size();
//            int idAddr = dao.address.read(sh.getAddressId()).getStreetId();
//            System.out.println(idAddr);
//            int idStreet = dao.street.read(idAddr).getId();
//            System.out.println(idAddr+ "-" + idStreet);
//            String city = dao.city.read(idStreet).getName();
//            System.out.println(idAddr+ "-" + idStreet  +"-" + city);
//        }
//    }
}
