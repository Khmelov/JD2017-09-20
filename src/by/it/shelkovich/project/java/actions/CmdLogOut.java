package by.it.shelkovich.project.java.actions;

import javax.servlet.http.HttpServletRequest;

public class CmdLogOut extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest request) {
        request.getSession().setAttribute("user", null);
        return Actions.MAIN.command;
    }
}
