package by.it.govor.bigBossProject.java.controller;


import by.it.govor.bigBossProject.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdIndex extends AbstractAction {


    @Override
    public ICommand execute(HttpServletRequest req) {
        try {
            req.setAttribute(
                    "ad",
                    DAO.getInstanceAd().ad.getRead("*")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
