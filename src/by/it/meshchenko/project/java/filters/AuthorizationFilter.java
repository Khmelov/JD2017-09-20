package by.it.meshchenko.project.java.filters;

import by.it.meshchenko.project.java.beans.User;
import by.it.meshchenko.project.java.controller.Messages;
import by.it.meshchenko.project.java.controller.Pages;
import by.it.meshchenko.project.java.controller.Utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    private FilterConfig filterConfig;

    /**
     * Метод инициализации фильтра
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig fConfig) throws ServletException
    {
        filterConfig = fConfig;
    }
    /**
     * Метод фильтрации
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException
    {
        //После фильтра аунтификации проверяем если user=null - пропускаем фильтр
        HttpServletRequest req = (HttpServletRequest)request;
        User user = Utils.getUserFromSession(req);
        if(user == null) {
            filterChain.doFilter(request, response);
            return;
        }
        // Если фильтр активный, то выполнить проверку
        if (filterConfig.getInitParameter("active").equalsIgnoreCase("true")) {

            // Раскладываем адрес на составляющие
            String url = req.getRequestURI() + (req.getQueryString() == null ? "" : "?" + req.getQueryString());
            String page = url.substring(url.lastIndexOf("/")+1, url.length());


            int role = user.getRoleId() == null ? -1 : user.getRoleId();
            boolean pageAuthorizAdmin = Pages.AUTHORIZATIONAdmin.contains(page);
            boolean pageAuthorizManager = Pages.AUTHORIZATIONManager.contains(page);
            //boolean pageAuthorizUser = Pages.AUTHORIZATIONUser.contains(page);
            if (pageAuthorizAdmin) {
                if(role == 1){
                    filterChain.doFilter(request, response);
                    return;
                }
                else {
                    ServletContext ctx = filterConfig.getServletContext();
                    RequestDispatcher dispatcher = ctx.getRequestDispatcher(Pages.home);
                    dispatcher.forward(request, response);
                }
            }
            else if(pageAuthorizManager){
                if(role == 2){
                    filterChain.doFilter(request, response);
                    return;
                }
                else {
                    ServletContext ctx = filterConfig.getServletContext();
                    RequestDispatcher dispatcher = ctx.getRequestDispatcher(Pages.home);
                    dispatcher.forward(request, response);
                }
            }
            else {
                filterChain.doFilter(request, response);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    /**
     * Метод освобождения ресурсов
     * @see Filter#destroy()
     */
    @Override
    public void destroy()
    {
        filterConfig = null;
    }
}
