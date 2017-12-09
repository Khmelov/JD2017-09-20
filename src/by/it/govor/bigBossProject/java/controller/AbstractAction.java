package by.it.govor.bigBossProject.java.controller;


import javax.servlet.http.HttpServletRequest;

abstract class AbstractAction implements ICommand {
    @Override
    public abstract ICommand execute(HttpServletRequest req);

    @Override
    public String getJsp() {
        return "/" + this.getClass().
                getSimpleName().
                replace("Cmd", "").
                toLowerCase() +
                ".jsp";
    }
}
