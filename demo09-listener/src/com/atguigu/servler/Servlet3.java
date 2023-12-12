package com.atguigu.servler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author: ClimbHu
 * @date: 2023年12月11日 22:53
 */
@WebServlet("/servlet3")
public class Servlet3 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 删除应用域中放入的数据
        // ServletContext application = req.getServletContext();
        // application.removeAttribute("keya");

        // 手动销毁session对象，或等待session对象过期自动销毁
        // HttpSession session = req.getSession();
        // session.invalidate();


        //  修改request域中的数据
        req.setAttribute("k1","value1");
        //  删除session域中的数据
        req.removeAttribute("k2");

    }
}
