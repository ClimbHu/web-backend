package com.atguigu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * @author: ClimbHu
 * @date: 2023年12月08日 18:06
 */
@WebServlet("/servlet4")
public class Servlet4 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 行相关  GET/POST uri http/1.1
        System.out.println("req.getMethod() = " + req.getMethod());
        // 请求协议
        System.out.println("req.getScheme() = " + req.getScheme());
        // 请求协议及版本号
        System.out.println("req.getProtocol() = " + req.getProtocol());
        // 请求URI    项目内的资源路径
        System.out.println("req.getRequestURI() = " + req.getRequestURI());
        // 请求URL   项目内资源的完整路径
        System.out.println("req.getRequestURL() = " + req.getRequestURL());
        /*
        URI     统一资源标识符  /demo03/a.html                interface URI{}             资源定位的要求和规范  动物类
        URL     统一资源定位符  http://ip:port/demo03/a.html  class URL implements URI{}  一个具体的资源了解    哺乳动物类
         */
        // 本应用容器的端口号
        System.out.println("req.getLocalPort() = " + req.getLocalPort());
        // 客户端发请求时使用的端口号
        System.out.println("req.getServerPort() = " + req.getServerPort());
        // 客户端软件运行的端口号
        System.out.println("req.getRemotePort() = " + req.getRemotePort());

        // 头相关
        // 根据头名称获取请求头
        String accept = req.getHeader("Accept");
        System.out.println("accept = " + accept);
        // 获取所有的请求头名字
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String hName = headerNames.nextElement();
            System.out.println(hName + " = " + req.getHeader(hName));
        }
        // 获取content-type请求头
        String contentType = req.getContentType();
        System.out.println("contentType = " + contentType);
    }
}
