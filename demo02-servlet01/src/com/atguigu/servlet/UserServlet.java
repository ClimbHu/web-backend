package com.atguigu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author: ClimbHu
 * @date: 2023年12月08日 12:31
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求中的参数
        String username = req.getParameter("username");
        // 设置Content-type 响应头
        // resp.setHeader("Content-Type","text/html");
        resp.setContentType("text/html");
        if ("atguigu".equals(username)) {
            //通过响应对象响应信息
            resp.getWriter().write("<h1>NO</h1>");
        } else {
            resp.getWriter().write("<h1>YES</h1>");
        }
    }
}
