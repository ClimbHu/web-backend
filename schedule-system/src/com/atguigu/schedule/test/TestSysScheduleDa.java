package com.atguigu.schedule.test;

import com.atguigu.schedule.dao.SysScheduleDao;
import com.atguigu.schedule.dao.impl.SysScheduleDaoImpl;
import com.atguigu.schedule.pojo.SysSchedule;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author: ClimbHu
 * @date: 2023年12月10日 1:16
 */
public class TestSysScheduleDa {

    private static SysScheduleDao sysScheduleDao;

    @BeforeClass
    public void initSysScheduleDao() {
        sysScheduleDao = new SysScheduleDaoImpl();
    }

    @Test
    public void testAdd() {
        SysSchedule sysSchedule = new SysSchedule();
        sysSchedule.setSid(null);
        sysSchedule.setUid(2);
        sysSchedule.setTitle("学习数据库");
        sysSchedule.setCompleted(1);

        int rows = sysScheduleDao.addSchedule(sysSchedule);
        System.out.println("rows = " + rows);
    }

    @Test
    public void testFindAll() {
        List<SysSchedule> scheduleList = sysScheduleDao.finAll();
        scheduleList.forEach(System.out::println);
    }

}
