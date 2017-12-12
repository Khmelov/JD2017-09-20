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
                ad.setProcessor(FormValidator.getString(req,"processor",Patterns.PROCESSOR));
                ad.setVideo_card(FormValidator.getString(req,"video_card",Patterns.VIDEO));
                ad.setMotherboard(FormValidator.getString(req,"motherboard", Patterns.MATHERBOARD));
                ad.setRam(FormValidator.getString(req,"ram",Patterns.RAM));
                ad.setPower_supply(FormValidator.getString(req,"power_supply",Patterns.POWER));
                ad.setHDD(FormValidator.getString(req,"HDD",Patterns.HDD));
                ad.setUser_ID(user.getId());
                DAO dao= DAO.getInstance();
                dao.ad.create(ad);
                return Actions.LOGOUT.command;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
