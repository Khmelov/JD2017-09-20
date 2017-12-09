package by.it.shelkovich.project.java.actions;

import javax.servlet.http.HttpServletRequest;

public interface ICommand {
    ICommand execute(HttpServletRequest request);
    String getJSP();
}
