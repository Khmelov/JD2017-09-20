package by.it.ali.project.java.controller;

import by.it.ali.project.java.dao.*;

import javax.servlet.http.HttpServletRequest;

public class CmdBuyTickets extends AbstractAction {
        @Override
        public ICommand execute(HttpServletRequest req) {

            if (FormValidator.isPost(req)) {
                Tickets ticket = new Tickets();
                try {
                    ticket.setDestination(FormValidator.getString(req,"destination",Patterns.ANY));
                    ticket.setCompany(FormValidator.getString(req,"company",Patterns.ANY));
                    ticket.setDate(FormValidator.getString(req,"company",Patterns.DATE));
                    //ticket.setFKusers();

                    DAO dao = DAO.getDAO();
                    if (dao.ticket.getAll("where Login='"+ticket.getDestination()+"'").size()>0)
                    {
                        req.setAttribute(Messages.ERROR, "Такой пользователь уже есть");
                        return null;
                    }
                    dao.ticket.create(ticket);
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
