package com.dubbo.provider.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",filterName = "TestFilter")
public class TestFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        long start = System.currentTimeMillis();
        chain.doFilter(req, resp);
        System.out.println("Execute cost="+(System.currentTimeMillis()-start));

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
