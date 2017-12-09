package by.it.shelkovich.project.java.actions;

import by.it.shelkovich.project.java.dao.DataBase;

import javax.servlet.http.HttpServletRequest;

public class CmdResetDB extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest request) {
        DataBase.initDataBase(request.getServletContext().getResourceAsStream("/resources/shelkovich.sql"));
        return Actions.MAIN.command;
    }
}
