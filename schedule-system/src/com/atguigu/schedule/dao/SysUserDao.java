package com.atguigu.schedule.dao;

import com.atguigu.schedule.pojo.SysUser;

/**
 * SysUserDao
 * @author: ClimbHu
 * @date: 2023年12月10日 0:11
 */
public interface SysUserDao {

    /**
     * 向数据库增加一条SysUser用户记录方法
     * @param sysUser 要增加的记录的username和user_pwd字段以SysUser实体类的形式接受
     * @return 1-增加成功 0-增加失败
     */
    int addSysUser(SysUser sysUser);

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    SysUser findByUsername(String username);
}
