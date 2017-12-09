package by.it.shelkovich.project.java.servlets;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String code;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        code = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String reqEnc = servletRequest.getCharacterEncoding();
        if(code != null && !code.equalsIgnoreCase(reqEnc)){
            servletRequest.setCharacterEncoding(code);
        }

        String respEnc = servletResponse.getCharacterEncoding();
        if(code != null && !code.equalsIgnoreCase(respEnc)){
            servletResponse.setCharacterEncoding(code);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        code=null;
    }
}
