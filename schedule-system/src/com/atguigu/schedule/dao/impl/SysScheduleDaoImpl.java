package com.atguigu.schedule.dao.impl;

import com.atguigu.schedule.dao.BaseDao;
import com.atguigu.schedule.dao.SysScheduleDao;
import com.atguigu.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * SysScheduleDao 实现类
 *
 * @author: ClimbHu
 * @date: 2023年12月10日 0:31
 */
public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {

    @Override
    public int addSchedule(SysSchedule schedule) {
        String sql = "insert into sys_schedule value(DEFAULT,?,?,?)";
        return baseUpdate(sql, schedule.getUid(), schedule.getTitle(), schedule.getCompleted());
    }

    @Override
    public List<SysSchedule> finAll() {
        String sql = "select sid,uid,title,completed from sys_schedule";
        return baseQuery(SysSchedule.class, sql);
    }

    @Override
    public List<SysSchedule> findItemListByUid(int uid) {
        String sql = "select sid,uid,title,completed from sys_schedule where uid = ?";
        List<SysSchedule> itemList = baseQuery(SysSchedule.class, sql, uid);
        return itemList;
    }

    @Override
    public Integer addDefault(int uid) {
        String sql = "insert into sys_schedule value(DEFAULT,?,'请输入日程',0)";
        return baseUpdate(sql, uid);
    }

    @Override
    public Integer updateSchedule(SysSchedule sysSchedule) {
        String sql = "update sys_schedule set title = ?,completed = ? where sid = ?";
        return baseUpdate(sql, sysSchedule.getTitle(), sysSchedule.getCompleted(), sysSchedule.getSid());
    }

    @Override
    public Integer removeSchedule(int sid) {
        String sql = "delete from sys_schedule where sid = ?";
        return baseUpdate(sql, sid);
    }
}
