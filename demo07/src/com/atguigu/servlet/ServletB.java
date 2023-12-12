package com.atguigu.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author: ClimbHu
 * @date: 2023年12月11日 18:59
 */
@WebServlet("/servletB")
public class ServletB extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获得请求域中的数据
        String request = (String) req.getAttribute("request");
        System.out.println("request = " + request);
        // 获得会话域中的数据
        String session = (String) req.getSession().getAttribute("session");
        System.out.println("session = " + session);
        // 获得应用域中的数据
        ServletContext application = req.getServletContext();
        Object applicationMessage = application.getAttribute("application");
        System.out.println("applicationMessage = " + applicationMessage);
    }
}
