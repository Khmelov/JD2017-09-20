package by.it.govor.bigBossProject.java.controller;

import javax.servlet.http.HttpServletRequest;

interface ICommand {

    ICommand execute(HttpServletRequest req);
    String getJsp();

}
