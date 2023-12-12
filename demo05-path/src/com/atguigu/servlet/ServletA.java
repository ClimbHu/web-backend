package com.atguigu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author: ClimbHu
 * @date: 2023年12月09日 17:19
 */
@WebServlet("/x/y/z/servletA")
public class ServletA extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 重定向到ServletB
        /*
        1 相对路径
            和前端的相对路径一致
        2 绝对路径
            http://localhost:8080/
            绝对路径中开头的斜线 / 会被转换为： http://localhost:8080/
         */
        // resp.sendRedirect("/d05/servletB");
        // ServletContext servletContext = req.getServletContext();
        // String contextPath = servletContext.getContextPath();
        // 项目上下文 contextPath = “/d05”
        // System.out.println("contextPath = " + contextPath);
        // resp.sendRedirect(contextPath + "/servletB");

        // 请求转发到ServletB
        /*
        1 相对路径
            和前端的相对路径一致
        2 绝对路径
            请求转发的绝对路径不需要添加项目上下文
            请求转发的 / 代表的路径是 http://localhost:8080/d05/   已包含项目上下文
         */
        // req.getRequestDispatcher("../../../servletB").forward(req, resp);
        req.getRequestDispatcher("/servletB").forward(req, resp);
    }
}
