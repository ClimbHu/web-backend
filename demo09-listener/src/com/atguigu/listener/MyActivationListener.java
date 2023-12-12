package com.atguigu.listener;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionActivationListener;
import jakarta.servlet.http.HttpSessionEvent;

/**
 * 会话域-钝化活化监听器
 * @author: ClimbHu
 * @date: 2023年12月11日 23:59
 */
public class MyActivationListener implements HttpSessionActivationListener {

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        // session对象即将进行钝化之前执行
        HttpSession session = se.getSession();
        System.out.println("session with JSESSIONID "+ session.getId()+" will passivate");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        // session活化完毕执行
        HttpSession session = se.getSession();
        System.out.println("session with JSESSIONID "+ session.getId()+" did activate");
    }
}
