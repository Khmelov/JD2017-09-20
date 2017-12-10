package by.it.govor.bigBossProject.java.controller;



import by.it.govor.bigBossProject.java.dao.DAO;
import by.it.govor.bigBossProject.java.table.Ad;
import by.it.govor.bigBossProject.java.table.User;
import javax.servlet.http.HttpServletRequest;

class CmdCreateAd extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest req) {


        User user=Utils.getUserFromSession(req);
        if (user==null) return Actions.LOGIN.command;
        if (FormValidator.isPost(req)){
            Ad ad=new Ad();
            try {
                ad.setProcessor(FormValidator.getString(req,"Processor",Patterns.ANY));
                ad.setVideo_card(FormValidator.getString(req,"Video card",Patterns.ANY));
                ad.setMotherboard(FormValidator.getString(req,"Motherboard", Patterns.ANY));
                ad.setRam(FormValidator.getString(req,"Price",Patterns.ANY));
                ad.setPower_supply(FormValidator.getString(req,"Floor",Patterns.ANY));
                ad.setUser_ID(user.getId());
                DAO dao= DAO.getInstanceAd();
                dao.ad.create(ad);
                return Actions.CREATEAD.command;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
