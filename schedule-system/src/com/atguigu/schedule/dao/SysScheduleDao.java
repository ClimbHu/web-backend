package com.atguigu.schedule.dao;

import com.atguigu.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * SysScheduleDao
 *
 * @author: ClimbHu
 * @date: 2023年12月10日 0:11
 */
public interface SysScheduleDao {
    /**
     * 用于向数据库中增加一条日程记录
     *
     * @param schedule 日程数据以SysSchedule实体类对象形式入参
     * @return 返回影响行数 0表示增加失败 1表示增加成功
     */
    int addSchedule(SysSchedule schedule);

    /**
     * 查询所有用户的日程
     *
     * @return 将所有日程放入一个List<SysSchedule>集合中返回
     */
    List<SysSchedule> finAll();

    /**
     * 获得当前用户的所有日程记录
     *
     * @param uid
     * @return
     */
    List<SysSchedule> findItemListByUid(int uid);

    /**
     * 向数据库中增加一条空记录
     *
     * @param uid
     * @return
     */
    Integer addDefault(int uid);

    /**
     * 根据sid更新数据库中的消息
     *
     * @param sysSchedule
     * @return
     */
    Integer updateSchedule(SysSchedule sysSchedule);

    /**
     * 删除数据库中对应sid的记录
     *
     * @param sid
     * @return
     */
    Integer removeSchedule(int sid);
}
