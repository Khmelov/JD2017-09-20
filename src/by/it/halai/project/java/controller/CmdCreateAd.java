package by.it.halai.project.java.controller;

import by.it.halai.project.java.beans.Ad;
import by.it.halai.project.java.beans.User;
import by.it.halai.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

class CmdCreateAd extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest req) {

        User user = Utils.getUserFromSession(req);
        if (user == null) return Actions.LOGIN.command;
        if (FormValidator.isPost(req)) {
            Ad ad = new Ad();
            try {
                ad.setName(FormValidator.getString(req, "Name", Patterns.ANY));
                ad.setGenre(FormValidator.getString(req, "Genre", Patterns.ANY));
                ad.setNumber_Of_Players(FormValidator.getInt(req, "Number_Of_Players"));
                ad.setPrice(FormValidator.getDouble(req, "Price"));
                ad.setDescription(FormValidator.getString(req, "Description", Patterns.ANY));
                ad.setFK_Users(user.getID());
                DAO dao = DAO.getInstance();
                dao.ad.create(ad);
                return Actions.INDEX.command;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
