package com.atguigu.schedule.service;

import com.atguigu.schedule.pojo.SysUser;

/**
 * 该表格定义了以sys_user表格为核心的业务处理功能
 * @author: ClimbHu
 * @date: 2023年12月10日 0:44
 */
public interface SysUserService {
    /**
     * 注册用户的方法
     * @param sysUser 要注册的用户名和明文密码以SysUser对象的形式接受
     * @return 1-注册成功   0-注册失败
     */
    int regist(SysUser sysUser);

    /**
     * 根据用户名查询完善的用户信息方法
     * @param username 要查询的用户名
     * @return 找到了返回SysUser对象，找不到返回null
     */
    SysUser findByUsername(String username);
}
