package com.atguigu.schedule.controller;

import com.atguigu.schedule.common.Result;
import com.atguigu.schedule.common.ResultCodeEnum;
import com.atguigu.schedule.util.WebUtil;
import com.atguigu.schedule.pojo.SysUser;
import com.atguigu.schedule.service.SysUserService;
import com.atguigu.schedule.service.impl.SysUserServiceImpl;
import com.atguigu.schedule.util.MD5Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author: ClimbHu
 * @date: 2023年12月10日 0:47
 */
@WebServlet("/user/*")
public class SysUserController extends BaseController {

    private SysUserService userService = new SysUserServiceImpl();

    /**
     * 注册时，接受要注册的用户名，校验用户名是否被占用的业务接口
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        // 调用服务层业务处理方法，查询该用户名是否有对应的用户
        SysUser sysUser = userService.findByUsername(username);
        // 如果没有 可用
        Result<Object> result = Result.build(null, ResultCodeEnum.SUCCESS);
        if (null != sysUser) {
            // 如果有 响应已占用
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        // result对象转换为JSON
        WebUtil.writeJson(resp, result);
    }

    /**
     * 接受用户登录请求，完成登录的业务接口
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接受客户端提交的参数
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        // 调用服务层方法，根据用户名查询用户信息
        SysUser loginUser = userService.findByUsername(username);
        if (loginUser == null) {
            // 跳转到用户名有误提示页
            resp.sendRedirect("/loginUsernameError.html");
        } else if (!MD5Util.encrypt(userPwd).equals(loginUser.getUserPwd())) {
            // 判断密码是否一致
            // 跳转到密码有误提示页
            resp.sendRedirect("/loginUserPwdError.html");
        } else {
            // 将登录成功之后，将登录的用户信息放入session
            HttpSession session = req.getSession();
            session.setAttribute("sysUser", loginUser);
            // 跳转到首页
            resp.sendRedirect("/showSchedule.html");
        }
    }

    /**
     * 接受用户注册请求的业务处理方法(业务接口 不是Java中的interface)
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接受客户端提交的参数
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        // 调用服务层方法，完成注册功能
        // 将参数放入一个对象中，在调用regist方法时传入
        SysUser sysUser = new SysUser(null, username, userPwd);
        int rows = userService.regist(sysUser);
        // 根据注册结果（成功、失败）做页面跳转
        if (rows > 0) {
            resp.sendRedirect("/registSuccess.html");
        } else {
            resp.sendRedirect("/registFail.html");
        }
    }
}
