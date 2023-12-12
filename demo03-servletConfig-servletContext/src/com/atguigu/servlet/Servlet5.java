package com.atguigu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @author: ClimbHu
 * @date: 2023年12月08日 20:33
 */
@WebServlet("/servlet5")
public class Servlet5 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("req.getMethod() = " + req.getMethod());
        // 根据请求参数名获取请求单个参数值
        String username = req.getParameter("username");
        System.out.println("username = " + username);
        String userPwd = req.getParameter("userPwd");
        System.out.println("userPwd = " + userPwd);
        // 根据请求参数名获取请求多个参数值数组
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println("hobby = " + hobby);
        }
        System.out.println("____________________");
        System.out.println(hobbies);
        System.out.println(Arrays.toString(hobbies));
        System.out.println("____________________");
        // 获取所有请求参数名
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String element = parameterNames.nextElement();
            // System.out.println(element + " = " + req.getParameter(element));
            String[] values = req.getParameterValues(element);
            if (values.length > 1) {
                System.out.println(element + " = " + Arrays.toString(values));
            } else {
                System.out.println(element + " = " + values[0]);
            }
        }
        // 获取所有请求参数的键值对集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        System.out.println("parameterMap = " + parameterMap);
        // for (String s : parameterMap.keySet()) {
        //     System.out.println(s + " = " + parameterMap.get(s)[0]);
        // }
        System.out.println("____________________");
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            String entryKey = entry.getKey();
            String[] value = entry.getValue();
            if (value.length > 1) {
                System.out.println(entryKey + " = " + Arrays.toString(value));
            } else {
                System.out.println(entryKey + " = " + value[0]);
            }
        }
        // 获得请求体长度的字节数
        int contentLength = req.getContentLength();
        System.out.println("contentLength = " + contentLength);

        /*
        以上API专门用于获取key=value形式的参数，无论这些参数是在url还是在请求体中

        获得请求体中的非键值对数据
            // 获取读取请求体的字符输入流
            BufferedReader reader = req.getReader();     JSON字符串

            // 获取读取请求体的字节输入流
            ServletInputStream inputStream = req.getInputStream();  文件
         */
    }
}
