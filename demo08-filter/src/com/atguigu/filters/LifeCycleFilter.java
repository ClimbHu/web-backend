package com.atguigu.filters;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * @author: ClimbHu
 * @date: 2023年12月11日 21:22
 */
public class LifeCycleFilter implements Filter {

    /*
    1 构造    构造器     项目启动    1
    2 初始化   init      构造完毕   1
    3 过滤    doFilter  每次请求   多次
    4 销毁    destroy   服务关闭    1
     */

    public LifeCycleFilter() {
        System.out.println("构造");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
        String dateTimePattern = filterConfig.getInitParameter("dateTimePattern");
        System.out.println("dateTimePattern = " + dateTimePattern);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤方法");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
