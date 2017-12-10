package by.it.ali.project.java.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

//@WebFilter(
//        urlPatterns = "/*",
//        initParams = {
//                @WebInitParam(name = "encoding", value = "UTF-8")
//        }
//)
public class EncodingPage implements Filter {
    private String code;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        code = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter EncodingPage started");
        String currentEncoding = req.getCharacterEncoding();
        if (code != null && !code.equalsIgnoreCase(currentEncoding)) {
            req.setCharacterEncoding(code);
        }
        currentEncoding = resp.getCharacterEncoding();
        if (code != null && !code.equalsIgnoreCase(currentEncoding)) {
            resp.setCharacterEncoding(code);
        }
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        code = null;
    }
}
