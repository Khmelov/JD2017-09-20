package by.it.govor.bigBossProject.java.controller;


import by.it.govor.bigBossProject.java.dao.DAO;
import by.it.govor.bigBossProject.java.table.Ad;
import by.it.govor.bigBossProject.java.table.Address;
import by.it.govor.bigBossProject.java.table.Role;
import by.it.govor.bigBossProject.java.table.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdEditUsers extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest req) {
        try {
            DAO dao=DAO.getInstance();
            if (FormValidator.isPost(req)) {
                User user = new User();
                try {
                    user.setLogin(FormValidator.getString(req, "login", Patterns.LOGIN));
                    user.setPassword(FormValidator.getString(req, "password", Patterns.PASSWORD));
                    user.setName(FormValidator.getString(req, "name", Patterns.NAME));
                    user.setNick(FormValidator.getString(req, "nick", Patterns.NICK));
                    user.setTelephone(FormValidator.getInt(req, "Telephone"));
                    user.setRole_ID(FormValidator.getInt(req, "role_ID"));
                    if (req.getParameter("Update") != null)
                        dao.user.update(user);
                    if (req.getParameter("Delete") != null){

                    Ad ad= new Ad();
                    List<Ad> ads = dao.ad.getRead("");
                    for (Ad a:ads) {
                        if (a.getUser_ID()==user.getId()){
                        dao.ad.delete(a);
                    }
                    }
                        Address address = new Address();
                        List<Address> addresses = dao.address.getRead("");
                        for (Address a:addresses) {
                            if (a.getUser_ID()==user.getId()){
                                dao.address.delete(a);
                            }
                        }
                    dao.user.delete(user);
                    }

                } catch (Exception e) {
                    req.setAttribute(Messages.ERROR, e.getMessage());
                }
            }
            req.setAttribute("user", DAO.getInstance().user.getRead(""));
        } catch (SQLException e) {
            req.setAttribute(Messages.ERROR, e.toString());
        }

        return null;
    }

}
