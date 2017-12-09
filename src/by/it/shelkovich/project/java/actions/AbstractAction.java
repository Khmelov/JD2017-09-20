package by.it.shelkovich.project.java.actions;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractAction implements ICommand {
    @Override
    public String getJSP() {
        return this.toString().toLowerCase()+".jsp";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName().replace("Cmd", "");
    }
}
