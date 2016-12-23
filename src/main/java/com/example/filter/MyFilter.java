package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by CPR199 on 2016-12-23.
 */
@WebFilter
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(">>>>>>>>>>>>>>>filter init<<<<<<<<<<<<<<<<<");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        //do something
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        System.out.println(">>>>>>>>>>>>>>>filter destroy<<<<<<<<<<<<<<<<<");
    }
}
