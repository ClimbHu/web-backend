package com.atguigu.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

/**
 * 请求域监听器
 * @author: ClimbHu
 * @date: 2023年12月11日 23:31
 */
@WebListener
public class MyRequestListener implements ServletRequestListener, ServletRequestAttributeListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletRequest request = sre.getServletRequest();
        System.out.println(request.hashCode() + " 请求域初始化了");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletRequest request = sre.getServletRequest();
        System.out.println(request.hashCode() + " 请求域销毁了");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        ServletRequest request = srae.getServletRequest();
        String key = srae.getName();
        Object value = srae.getValue();
        System.out.println(request.hashCode() + " 请求域增加了 " + key + " = " + value);
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        ServletRequest request = srae.getServletRequest();
        String key = srae.getName();
        Object value = srae.getValue();
        System.out.println(request.hashCode() + " 请求域移除了 " + key + " = " + value);
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        ServletRequest request = srae.getServletRequest();
        String key = srae.getName();
        Object value = srae.getValue();
        // 新值
        Object newValue = request.getAttribute(key);
        System.out.println(request.hashCode() + " 请求域修改了 " + key + "：" + value + " 为：" + newValue);

    }
}
