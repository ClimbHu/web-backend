package com.atguigu.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.*;

/**
 * 会话域监听器
 * @author: ClimbHu
 * @date: 2023年12月11日 23:23
 */
@WebListener
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // 任何一个session域对象的创建都会触发该方法的执行
        HttpSession session = se.getSession();
        System.out.println(session.hashCode() + " session域初始化了");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // 任何一个session域对象的销毁都会触发该方法的执行
        HttpSession session = se.getSession();
        System.out.println(session.hashCode() + " session域销毁了");
    }


    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        // 任何一个session域对象中添加了数据都会触发该方法的执行
        HttpSession session = se.getSession();
        String key = se.getName();
        Object value = se.getValue();
        System.out.println(session.hashCode() + " session域添加了 " + key + " = " + value);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        // 任何一个session域对象中移除了数据都会触发该方法的执行
        HttpSession session = se.getSession();
        String key = se.getName();
        Object value = se.getValue();
        System.out.println(session.hashCode() + " session域移除了 " + key + " = " + value);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        // 任何一个session域对象中修改了了数据都会触发该方法的执行
        HttpSession session = se.getSession();
        String key = se.getName();
        Object value = se.getValue(); // 旧值
        // 新值
        Object newValue = session.getAttribute(key);
        System.out.println(session.hashCode() + " session域修改了 " + key + " = " + value + " 为：" + newValue);
    }
}
