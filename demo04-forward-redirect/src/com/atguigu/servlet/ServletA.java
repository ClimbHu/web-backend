package com.atguigu.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author: ClimbHu
 * @date: 2023年12月08日 22:42
 */
@WebServlet("/servletA")
public class ServletA extends HttpServlet {

    /**
     1 请求转发是通过HttpServletRequest对象实现的
     2 请求转发是服务器内部行为，对客户端是屏蔽的
     3 客户端只产生了一次请求 服务端只产生了一对 Request 和 Response 对象
     4 客户端的地址栏是不变的
     5 请求的参数是可以继续传递的
     6 目标资源可是Servlet动态资源 也可以是html等静态资源
     7 目标资源可以是WEB-INF下受保护的资源，该方式也是WEB-INF下资源的唯一访问方式
     8 目标资源不可以是外部的资源
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletA 执行了");

        String money = req.getParameter("money");
        System.out.println("servletA - money = " + money);

        // 请求转发给ServletB
        // 获得请求转发器
        // RequestDispatcher reqRequestDispatcher = req.getRequestDispatcher("servletB");
        // RequestDispatcher reqRequestDispatcher = req.getRequestDispatcher("a.html");
        RequestDispatcher reqRequestDispatcher = req.getRequestDispatcher("logo.jpg");
        // RequestDispatcher reqRequestDispatcher = req.getRequestDispatcher("WEB-INF/b.html");
        // RequestDispatcher reqRequestDispatcher = req.getRequestDispatcher("http://www.atguigu.com");

        // 让请求转发器做出转发动作
        reqRequestDispatcher.forward(req, resp);
    }
}
