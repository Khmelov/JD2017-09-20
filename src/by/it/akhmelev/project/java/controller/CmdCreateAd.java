package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.bean.Ad;
import by.it.akhmelev.project.java.bean.User;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdCreateAd extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest req) {

        User user=Utils.getUserFromSession(req);
        if (user==null) return Actions.LOGIN.command;
        if (FormValidator.isPost(req)){
            Ad ad=new Ad();
            try {
                ad.setAddress(FormValidator.getString(req,"Address",Patterns.ANY));
                ad.setDescription(FormValidator.getString(req,"Description",Patterns.ANY));
                ad.setArea(FormValidator.getDouble(req,"Area"));
                ad.setPrice(FormValidator.getDouble(req,"Price"));
                ad.setFloor(FormValidator.getInt(req,"Floor"));
                ad.setFloors(FormValidator.getInt(req,"Floors"));
                ad.setRoomCount(FormValidator.getInt(req,"RoomCount"));
                ad.setFK_Users(user.getId());

                req.getSession().setAttribute(Messages.MESSAGE,Utils.uploadFile(req,"Image"));

                DAO dao= DAO.getInstance();
                dao.ad.create(ad);
                return Actions.INDEX.command;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
