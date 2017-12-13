package by.it.halai.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class ActionFactory {
    ICommand getCommand(HttpServletRequest req) {
        String strCommand = req.getParameter("command");
        if (strCommand == null) strCommand = "index";
        try {
            Actions tmp = Actions.valueOf(strCommand.toUpperCase());
            return tmp.command;
        } catch (IllegalArgumentException e) {
            return Actions.ERROR.command;
        }
    }
}
