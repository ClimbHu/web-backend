package com.atguigu.schedule.service;

import com.atguigu.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * 该表格定义了以sys_user表格为核心的业务处理功能
 */
public interface SysScheduleService {

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
