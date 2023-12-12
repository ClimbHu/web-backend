package com.atguigu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author: ClimbHu
 * @date: 2023年12月11日 17:12
 */
@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取session
        HttpSession session = req.getSession();
        System.out.println("session.getId() = " + session.getId());
        System.out.println("session.isNew() = " + session.isNew());
        // 读取session对象中存储的用户名
        String username = (String) session.getAttribute("username");
        System.out.println("username = " + username);
    }
}
