package com.atguigu.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 三大域演示
 *      请求域
 *      会话域
 *      应用域
 *
 * @author: ClimbHu
 * @date: 2023年12月11日 18:59
 */
@WebServlet("/servletA")
public class ServletA extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 向请求域中存入数据
        req.setAttribute("request", "requestMessage");
        // 向会话域中存入数据
        req.getSession().setAttribute("session", "sessionMessage");
        // 向应用域中存入数据
        ServletContext application = req.getServletContext();
        application.setAttribute("application", "applicationMessage");

        // 获得请求域中的数据
        String request = (String) req.getAttribute("request");
        System.out.println("request = " + request);
    }
}
