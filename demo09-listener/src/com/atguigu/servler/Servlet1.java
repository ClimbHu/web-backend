package com.atguigu.servler;

import com.atguigu.listener.MyActivationListener;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author: ClimbHu
 * @date: 2023年12月11日 22:53
 */
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 向应用域放入数据
        ServletContext application = req.getServletContext();
        application.setAttribute("keya", "valueA");

        // 创建session对象
        // HttpSession session = req.getSession();
        // 手动销毁session对象，或等待session对象过期自动销毁
        // session.invalidate();

        // 向request中增加数据
        // req.setAttribute("k1", "v1");
        // req.setAttribute("k2", "v2");
        // 请求转发
        // req.getRequestDispatcher("servlet3").forward(req, resp);

        // session绑定，解绑定
        // HttpSession session = req.getSession();
        // SessionBindingListener sbl = new SessionBindingListener();
        // // 绑定
        // session.setAttribute("sbl", sbl);
        // // 解绑定
        // session.removeAttribute("sbl");

        // session钝化
        HttpSession session = req.getSession();
        // 添加数据
        session.setAttribute("k1", "v1");
        // 添加钝化活化监听器
        session.setAttribute("activationListener", new MyActivationListener());
    }
}
