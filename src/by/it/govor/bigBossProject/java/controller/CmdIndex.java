package by.it.govor.bigBossProject.java.controller;


import by.it.govor.bigBossProject.java.dao.DAO;
import by.it.govor.bigBossProject.java.table.Ad;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex extends AbstractAction {

    public static void main(String[] args) {
        try {
            System.out.println(
                    DAO.getInstance().ad.getRead("")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public ICommand execute(HttpServletRequest req) {
        try {

                req.setAttribute(
                        "ads",  DAO.getInstance().ad.getRead("")
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;

    }

}
