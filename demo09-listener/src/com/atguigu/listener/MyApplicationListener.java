package com.atguigu.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

/**
 * 应用域监听器
 * @author: ClimbHu
 * @date: 2023年12月11日 22:58
 */
@WebListener
public class MyApplicationListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        System.out.println(application.hashCode() + " 应用域初始化了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        System.out.println(application.hashCode() + " 应用域销毁了");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        ServletContext application = scae.getServletContext();
        String key = scae.getName();
        Object value = scae.getValue();
        System.out.println(application.hashCode() + " 应用域增加了 " + key +" = "+ value);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        ServletContext application = scae.getServletContext();
        String key = scae.getName();
        Object value = scae.getValue();
        System.out.println(application.hashCode() + " 应用域移除了 " + key + value);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        ServletContext application = scae.getServletContext();
        String key = scae.getName();
        Object value = scae.getValue(); // 获取的是旧值
        // 获取新值
        Object newValue = application.getAttribute(key);
        System.out.println(application.hashCode() + " 应用域修改了 " + key + "：" + value + " 为：" + newValue);
    }
}
