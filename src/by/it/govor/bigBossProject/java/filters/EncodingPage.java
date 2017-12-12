package by.it.govor.bigBossProject.java.filters;

import javax.servlet.*;
import java.io.IOException;


public class EncodingPage implements Filter {
    private String code;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        code = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
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
