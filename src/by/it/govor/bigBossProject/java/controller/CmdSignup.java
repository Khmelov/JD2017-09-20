package by.it.govor.bigBossProject.java.controller;


import by.it.govor.bigBossProject.java.dao.DAO;
import by.it.govor.bigBossProject.java.table.Address;
import by.it.govor.bigBossProject.java.table.User;

import javax.servlet.http.HttpServletRequest;

class CmdSignup extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest req) {
    if (FormValidator.isPost(req)) {
        User user = new User();
        Address address = new Address();
        try {
            user.setLogin(FormValidator.getString(req, "login", Patterns.LOGIN));
            user.setPassword(FormValidator.getString(req, "password", Patterns.PASSWORD));
            user.setName(FormValidator.getString(req, "name", Patterns.NAME));
            user.setNick(FormValidator.getString(req, "nick", Patterns.NICK));
            user.setTelephone(FormValidator.getInt(req, "Telephone"));
            user.setRole_ID(1);
            address.setUser_ID(user.getId());
            DAO dao = DAO.getInstance();
            if (dao.user.getRead("where Login='"+user.getLogin()+"'").size()>0)
            {
                req.setAttribute(Messages.ERROR, "This user already exists");
                return null;
            }
            dao.user.create(user);
            address.setCountry(FormValidator.getString(req,"country",Patterns.COUNTRY));
            address.setCity(FormValidator.getString(req,"city",Patterns.CITY));
            address.setUser_ID(user.getId());
            dao.address.create(address);

            req.setAttribute(Messages.MESSAGE, "finish");
            return Actions.LOGIN.command;





        } catch (Exception e) {
            req.getServletContext().log(e.getMessage());
            System.out.println(e.getMessage());
            req.setAttribute(Messages.ERROR, e.getMessage());
        }
    }

        return null;
}
    }


