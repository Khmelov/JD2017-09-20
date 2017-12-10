package by.it.meshchenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class MyRequest {

    public static String getParam(HttpServletRequest req, String name, String pattern) throws ParseException {
        String value = req.getParameter(name);
        if (value.matches(pattern))
            return value;
        throw new ParseException("incorrect value " + value, 0);
    }

    public static boolean isPost(HttpServletRequest req) {
        return req
                .getMethod()
                .toUpperCase()
                .equals("POST");
    }

    public static boolean isGet(HttpServletRequest req) {
        return req
                .getMethod()
                .toUpperCase()
                .equals("GET");
    }
}
