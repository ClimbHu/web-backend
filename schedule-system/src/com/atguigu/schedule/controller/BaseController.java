package com.atguigu.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断此次请求时 增？删？改？查？
        String requestURI = req.getRequestURI(); // schedule/add
        String[] split = requestURI.split("/");
        String methodName = split[split.length - 1];
        // 使用反射 通过方法名获取下面的方法
        Class clazz = this.getClass();
        try {
            Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 暴力破解，破解方法的访问修饰符的限制，防止需调用的方法不是public   设置方法可以访问
            method.setAccessible(true);
            // 通过反射执行代码
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 反射优化以下代码
        // if (methodName.equals("add") ) {
        //     add(req,resp);
        // } else if (methodName.equals("find") ) {
        //     find(req,resp);
        // } else if (methodName.equals("update") ) {
        //     update(req,resp);
        // } else if (methodName.equals("remove") ) {
        //     remove(req,resp);
        // }
    }
}