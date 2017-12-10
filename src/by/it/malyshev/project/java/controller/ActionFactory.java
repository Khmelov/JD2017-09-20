package by.it.malyshev.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class ActionFactory {

    ICommand getCommand(HttpServletRequest req) {

        String strCommand = req.getParameter("command").toUpperCase();

        try {
            return Actions.valueOf(strCommand).command;

        } catch (IllegalArgumentException e) {

            return Actions.ERROR.command;
        }
    }
}
