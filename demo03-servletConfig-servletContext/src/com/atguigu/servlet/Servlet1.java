package com.atguigu.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * @author: ClimbHu
 * @date: 2023年12月08日 17:17
 */
@WebServlet(
        value = "/servlet1",
        initParams = {
                @WebInitParam(name = "keya", value = "value1A"),
                @WebInitParam(name = "keyb", value = "value1B")})
public class Servlet1 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------------------ServletConfig获取参数-----------------------------");
        // 获取初始配置信息
        ServletConfig servletConfig = this.getServletConfig();
        // 根据参数获取参数值
        String keya = servletConfig.getInitParameter("keya");
        System.out.println("keya = " + keya);

        // 获取所有的初始化参数的名字
        // hasMoreElements  判断有没有下一个参数，如果有返回true，没有返回false
        // nextElement      1 取出下一个元素 2 向下移动游标
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String element = initParameterNames.nextElement();
            System.out.println("element = " + servletConfig.getInitParameter(element));
        }
        System.out.println("-----------------------ServletContext获取参数-----------------------------");
        ServletContext servletContext1 = req.getServletContext();
        ServletContext servletContext2 = getServletContext();
        ServletContext servletContext3 = getServletConfig().getServletContext();
        System.out.println(servletContext1 == servletContext2);
        System.out.println(servletContext3 == servletContext2);

        String encoding = servletContext1.getInitParameter("encoding");
        System.out.println("encoding = " + encoding);

        Enumeration<String> initParameterNames1 = servletContext1.getInitParameterNames();
        while (initParameterNames1.hasMoreElements()) {
            String element = initParameterNames1.nextElement();
            System.out.println("element = " + servletContext1.getInitParameter(element));
        }
    }
}
