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
@WebServlet("/servletC")
public class ServletC extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应体使用UTF-8编码
        resp.setCharacterEncoding("UTF-8");
        // 设置ContentType响应头，告诉客户端使用UTF-8解码
        resp.setContentType("text/html;charset=UTF-8");

        // 向客户端响应一些文字
        resp.getWriter().write("你好 Hello");

        /*
         Tomcat 10中，响应体默认的编码字符集使用的是UTF-8
            1 可以设置响应体的编码字符集和客户端的保持一致 不推荐 客户端解析的字符集是无法预测的
            2 可以告诉客户端使用指定的字符集进行解码  通过设置ContentType的响应头
         注意的是：  明确响应体的编码，然后再设置 ContentType
            指定服务端写入报文的编码格式，告诉客户端想吐的解码方式即可
         */
    }
}
