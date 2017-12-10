package by.it.shelkovich.project.java.servlets;

import by.it.shelkovich.project.java.dao.entities.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PermissionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request  = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;


        if(request.getParameter("command")!= null && ( request.getParameter("command").equals("profile") || request.getParameter("command").equals("publish"))) {
            User user = (User) request.getSession().getAttribute("user");
            if (user == null) response.sendRedirect(request.getContextPath() + "?command=login");
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
