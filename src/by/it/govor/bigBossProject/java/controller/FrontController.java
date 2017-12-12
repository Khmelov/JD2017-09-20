package by.it.govor.bigBossProject.java.controller;


import by.it.govor.bigBossProject.java.dao.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class FrontController extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            getServletContext().setAttribute("role", DAO.getInstance().role.getRead(""));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICommand cmd = new ActionFactory().getCommand(req);
        ICommand nextAction = cmd.execute(req);
        if (nextAction == null) {
            RequestDispatcher disp = req.getRequestDispatcher(cmd.getJsp());
            disp.forward(req, resp);
        } else
            resp.sendRedirect("do?command=" + nextAction);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICommand cmd = new ActionFactory().getCommand(req);
        ICommand nextAction = cmd.execute(req);
        if (nextAction == null) {
            RequestDispatcher disp = req.getRequestDispatcher(cmd.getJsp());
            disp.forward(req, resp);
        } else
            resp.sendRedirect("do?command=" + nextAction);
    }
}
