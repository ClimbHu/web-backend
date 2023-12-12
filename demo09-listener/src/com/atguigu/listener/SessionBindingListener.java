package com.atguigu.listener;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

/**
 * session绑定监听器
 * @author: ClimbHu
 * @date: 2023年12月11日 23:50
 */
public class SessionBindingListener implements HttpSessionBindingListener {

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        // 当前监听器实例放入某个session中作为数据 绑定
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        // 当前监听器实例从某个session中作为移除 解绑定
    }
}
