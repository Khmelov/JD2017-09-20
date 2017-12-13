package by.it.halai.project.java.controller;

import by.it.halai.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

class Utils {

    static User getUserFromSession(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) return null;
        Object o = session.getAttribute("user");
        if (o == null) return null;
        return (User) o;
    }

}
