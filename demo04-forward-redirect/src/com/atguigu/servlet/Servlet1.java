package com.atguigu.servlet;

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
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {

    /**
     1 重定向是HttpServletResponse对象实现的
     2 响应重定向是在服务端的提示下，客户端的行为
     3 客户端的地址栏是变化的
     4 客户端至少发送了两次请求 客户端产生了多次请求
     5 请求产生了多少次 后端就会有多少个request对象 此时请求中的request参数不能继续自动传递
     6 目标资源可以是视图资源
     7 目标资源不可以是WEB-INf下的资源
     8 目标资源可以是外部资源
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接受用户请求
        System.out.println("servlet1 执行了");
        // 响应重定向    设置响应状态码为302，同时设置location响应头
        resp.sendRedirect("servlet2");
    }
}
