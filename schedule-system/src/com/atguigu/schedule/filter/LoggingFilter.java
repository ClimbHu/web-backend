package com.atguigu.schedule.filter;

import com.atguigu.schedule.pojo.SysUser;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author: ClimbHu
 * @date: 2023年12月12日 0:15
 */
// @WebFilter(urlPatterns = {"/showSchedule.html", "/schedule/*"})
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 父转子
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获得session域对象
        HttpSession session = request.getSession();
        // 从session域中获得登录的用户对象
        SysUser sysUser = (SysUser) session.getAttribute("sysUser");

        // 判断用户对象是否为空
        if (null != sysUser) {
            // 已登录,放行
            filterChain.doFilter(request, response);
        } else {
            // 没登录 到login.html 页面
            response.sendRedirect("/login.html");
        }
    }
}
