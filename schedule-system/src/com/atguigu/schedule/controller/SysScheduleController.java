package com.atguigu.schedule.controller;

import com.atguigu.schedule.common.Result;
import com.atguigu.schedule.pojo.SysSchedule;
import com.atguigu.schedule.service.SysScheduleService;
import com.atguigu.schedule.service.impl.SysScheduleServiceImpl;
import com.atguigu.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ClimbHu
 * @date: 2023年12月10日 0:47
 */
@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController {
    private SysScheduleService sysScheduleService = new SysScheduleServiceImpl();

    protected void addDefaultSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接受请求中的uid参数
        int uid = Integer.parseInt(req.getParameter("uid"));
        // 调用服务层方法，向数据库中增加一条空记录
        sysScheduleService.addDefault(uid);
        // 响应结果
        WebUtil.writeJson(resp, Result.ok(null));
    }

    protected void findAllSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接受请求中的uid参数
        int uid = Integer.parseInt(req.getParameter("uid"));
        // 查询用户的所有日程
        List<SysSchedule> itemList = sysScheduleService.findItemListByUid(uid);
        // 将用户的所有日程放入一个Result对象
        Map data = new HashMap<>();
        data.put("itemList", itemList);
        Result result = Result.ok(data);
        // 将Result对象转换为JSON响应给客户端
        WebUtil.writeJson(resp, result);
    }

    protected void updateSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接受请求中的JSON串，转换成一个SysSchedule对象
        SysSchedule sysSchedule = WebUtil.readJson(req, SysSchedule.class);
        // 调用服务层方法，更新数据库中的记录
        sysScheduleService.updateSchedule(sysSchedule);
        // 响应结果
        WebUtil.writeJson(resp, Result.ok(null));
    }

    protected void removeSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接受请求中的sid参数
        int sid = Integer.parseInt(req.getParameter("sid"));
        // 调用服务层方法，删除数据库中对应sid的记录
        sysScheduleService.removeSchedule(sid);
        // 响应结果
        WebUtil.writeJson(resp, Result.ok(null));
    }
}
