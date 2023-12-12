package com.atguigu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
    1 顶级的Servlet接口
    public interface Servlet {
        // 初始haul方法，构造完毕后，由Tomcat自动调用完成初始化功能的方法
        void init(ServletConfig var1) throws ServletException;
        // 获得ServletConfig对象的方法
        ServletConfig getServletConfig();
        // 接受用户请求，处理响应信息的方法
        void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;
        // 返回servlet字符串形式描述信息的方法
        String getServletInfo();
        // servlet在回收前，由Tomcat调用的销毁方法，往往用于做资源释放的工作
        void destroy();
    }

    2 抽象的类  GenericServlet
    public abstract class GenericServlet implements Servlet{
        private transient ServletConfig config;

        public void destroy() {
            // 将抽象方法重写为普通方法，在方法颞部没有任何的实现代码
            // 平庸实现
        }
        // Tomcat在调用init方法时，会读取配置信息进入一个ServletConfig对象并将该对象传入init方法
        public void init(ServletConfig config) throws ServletException {
            // 将config对象存储为当前对象
            this.config = config;
            // 调用重载的五载init
            this.init();
        }
        // 重载的初始化方法，我们重写初始化方法时对应的方法
        public void init() throws ServletException {
        }
        // 返回ServletConfig的方法
        public ServletConfig getServletConfig() {
            return this.config;
        }
        // 再次抽象声明service方法
        public abstract void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;
    }

    3 HttpServlet 抽象类   侧重service方法的处理
    public abstract class HttpServlet extends GenericServlet {
        // 参数父传子    调用重载service方法
        public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
            HttpServletRequest request = (HttpServletRequest)req;
            HttpServletResponse response = (HttpServletResponse)res;
            // 调用重载的service
            this.service(request, response);
        }

        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // 获取请求的方式
            String method = req.getMethod(); // GET、POST、PUT、OPTIONS ...

            // 根据请求方式，调用对应的do....方法
            if (method.equals("GET")) {
                this.doGet(req, resp);
            } else if (method.equals("HEAD")) {
                this.doHead(req, resp);
            } else if (method.equals("POST")) {
                this.doPost(req, resp);
            } else if (method.equals("PUT")) {
                this.doPut(req, resp);
            } else if (method.equals("DELETE")) {
                this.doDelete(req, resp);
            } else if (method.equals("OPTIONS")) {
                this.doOptions(req, resp);
            } else if (method.equals("TRACE")) {
                this.doTrace(req, resp);
            } else {
                resp.sendError(501, errMsg);
            }
        }
        // 故意响应405
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String msg = lStrings.getString("http.method_get_not_supported");
            // 故意响应 405 请求方式不允许的信息
            resp.sendError(400, msg);
        }
        // 故意响应405
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String msg = lStrings.getString("http.method_post_not_supported");
            // 故意响应 405 请求方式不允许的信息
            resp.sendError(400, msg);
        }
    }

    4 自定义servlet
    public class Servlet1 extends HttpServlet {
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // 接受用户的请求信息
            // 处理
            // 做出响应
        }
    }
 */
@WebServlet(value = "/servletLifeCycle",loadOnStartup = 6)
public class ServletLifeCycle extends HttpServlet {

    public ServletLifeCycle() {
        System.out.println("构造器");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
    }

    // @Override
    // protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //     System.out.println("服务");
    // }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("get请求处理方法");
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post请求处理方法");
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
