package com.atguigu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: ClimbHu
 * @date: 2023年12月08日 21:42
 */
@WebServlet("/servlet6")
public class Servlet6 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应行相关的API HTTP/1.1 200/404/405/500/...
        // resp.setStatus(405);
        resp.setStatus(200);

        String info = "<h1>Hello</h1>";
        // 设置响应头
        resp.setHeader("aaa", "valueA");
        // resp.setHeader("Content-Type","text/html");
        // resp.setHeader("Content-Length","1024");
        resp.setContentType("text/html");
        resp.setContentLength(info.getBytes().length);

        // 设置响应体
        // 获得一个向响应体中输入文本字符输出流
        PrintWriter writer = resp.getWriter();
        writer.println(info);

        // 获得一个向响应体中输入二进制信息的字节输出流，后面测试
        // ServletOutputStream outputStream = resp.getOutputStream();
    }
}
