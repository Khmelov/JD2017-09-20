package by.it.halai.project.java.controller;

import by.it.halai.project.java.dao.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "FrontController",
        urlPatterns = {
                "/do", ""
        })
public class FrontController extends HttpServlet {

    public static void main(String[] args) throws SQLException {
        System.out.println(DAO.getInstance().role.getAll(""));
    }

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            getServletContext().setAttribute("roles", DAO.getInstance().role.getAll(""));
        } catch (Exception e) {
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
