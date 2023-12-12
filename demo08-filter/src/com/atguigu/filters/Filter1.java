package com.atguigu.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @author: ClimbHu
 * @date: 2023年12月11日 21:43
 */
@WebFilter("/*")
public class Filter1 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter1 before doFilter invoked");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter1 after doFilter invoked");
    }
}
