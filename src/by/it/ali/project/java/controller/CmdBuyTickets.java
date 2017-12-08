package by.it.ali.project.java.controller;

import by.it.ali.project.java.dao.*;

import javax.servlet.http.HttpServletRequest;

public class CmdBuyTickets extends AbstractAction {
        @Override
        public ICommand execute(HttpServletRequest req) {
            User user=Utils.getUserFromSession(req);
            if (user==null) return Actions.LOGIN.command;
            if (FormValidator.isPost(req)) {
                Tickets ticket = new Tickets();
                try {
                    ticket.setDestination(FormValidator.getString(req,"destination",Patterns.ANY));
                    ticket.setCompany(FormValidator.getString(req,"company",Patterns.ANY));
                    ticket.setDate(FormValidator.getString(req,"date",Patterns.DATE));
                    ticket.setPrice(FormValidator.getInt(req,"price"));
                    ticket.setFKusers(ticket.getId());
                    DAO dao = DAO.getDAO();
                    dao.ticket.create(ticket);
                    return Actions.INDEX.command;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
}
