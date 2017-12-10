package by.it.meshchenko.project.java.filters;

import by.it.meshchenko.project.java.beans.*;
import by.it.meshchenko.project.java.controller.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
static int i = 0;
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
//    public static void main(String[] args){
//
//        String uri = "calhost:28080/meshchenko/do";
//        String query1 = "command=signin";
//        String query2 = "command=signin";
//        //String page1 = uri.substring(uri.lastIndexOf("/")+1, uri.length());
//
//        String url1 = uri + (query1 == null ? "" : "?" + query1);
//        String url2 = uri + (query2 == null ? "" : "?" + query2);
//        String page1 = url1.substring(url1.lastIndexOf("/")+1, url1.length());
//        page1 = page1.substring(0, (page1.indexOf("&") == -1 ? page1.length() : page1.indexOf("&")));
//        String page2 = url2.substring(url2.lastIndexOf("/")+1, url2.length());
//        page2 = page2.substring(0, (page1.indexOf("&") == -1 ? page1.length() : page1.indexOf("&")));
//        System.out.println(page1);
//        System.out.println(page2);
//    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException
    {
        // Если фильтр активный, то выполнить проверку
        if (filterConfig.getInitParameter("active").equalsIgnoreCase("true")) {
            HttpServletRequest req = (HttpServletRequest)request;
            // Раскладываем адрес на составляющие
            String url = req.getRequestURI() + (req.getQueryString() == null ? "" : "?" + req.getQueryString());
            String page = url.substring(url.lastIndexOf("/")+1, url.length());
            page = page.substring(0, (page.indexOf("&") == -1 ? page.length() : page.indexOf("&")));

            // Если запрос на файлы ресурса, то пропускаем
            if(Pages.RESURS.contains(
                    page.substring(page.lastIndexOf(".") + 1,page.length()))) {
                filterChain.doFilter(request, response);
                return;
            }

            boolean pageAuthent = Pages.AUTHENTICATION.contains(page);
            boolean pageNotAuthent = Pages.NOTAUTHENTICATION.contains(page);
            // Сеанс пользователя
            User user = Utils.getUserFromSession(req);

            if (user == null && pageNotAuthent) {
                filterChain.doFilter(request, response);
                return;
            }
            else if (user != null && pageAuthent) {
                filterChain.doFilter(request, response);
                return;
            }
            else if(user == null && pageAuthent){
                ServletContext ctx = filterConfig.getServletContext();
                RequestDispatcher dispatcher = ctx.getRequestDispatcher("/" + Pages.cmdsignin);
                dispatcher.forward(request, response);
                return;
            }
            else if(user != null && pageNotAuthent) {
                ServletContext ctx = filterConfig.getServletContext();
                RequestDispatcher dispatcher = ctx.getRequestDispatcher("/" + Pages.cmdlease);
                dispatcher.forward(request, response);
                return;
            }
            else if(user != null) {
                ServletContext ctx = filterConfig.getServletContext();
                RequestDispatcher dispatcher = ctx.getRequestDispatcher("/" + Pages.cmdlease);
                dispatcher.forward(request, response);
                return;
            }
            else {
                ServletContext ctx = filterConfig.getServletContext();
                RequestDispatcher dispatcher = ctx.getRequestDispatcher(Pages.index);
                dispatcher.forward(request, response);
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
