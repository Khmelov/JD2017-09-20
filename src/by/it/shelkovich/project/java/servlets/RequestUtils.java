package by.it.shelkovich.project.java.servlets;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {
    static public boolean isPost(HttpServletRequest req){
        return req.getMethod().equalsIgnoreCase("POST");
    }

    static public String validate(String param, String pattern) throws SecurityException{
        if(param.matches(pattern)){
            return param;
        }else throw new SecurityException("Incorrect value: " + param);
    }
}
