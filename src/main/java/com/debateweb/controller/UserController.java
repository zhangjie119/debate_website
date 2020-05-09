package com.debateweb.controller;

import com.debateweb.entity.User;
import com.debateweb.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-03-21 17:16:49
 */
@Controller
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 登录首页
     *
     * @param request
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        return "main";
    }

    /**
     * 查询所有用户数据
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAllUser")
    public ModelAndView findAllUser(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "5") int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<User> users = userService.findAll(page, size, false);
        PageInfo pageInfo = new PageInfo(users);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("back/user-list");
        return mv;
    }

    @RequestMapping("/findAllAdmin")
    public ModelAndView findAllAdmin(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "5") int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<User> admins = userService.findAll(page, size, true);
        PageInfo pageInfo = new PageInfo(admins);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("back/admin-list");
        return mv;
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpSession session, @RequestParam String username, @RequestParam String password) {

        if (userService.loginCheck(username, password)) {
            User user = userService.queryByUsername(username);
            session.setAttribute("loginUser", user);
            //修改数据的时候要重定向
            return "front/video-search";
        } else {
            //转发才能接收到request
            return "failer";
        }
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String nickname, @RequestParam String password1, @RequestParam String email) {
        if (this.userService.checkUsername(username)) {
            System.err.println("用户注册失败,该用户名已存在");
            return "failer";
        }
        if (this.userService.register(username, nickname, password1, email)) {
            return "register-success";
        }
        return "failer";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.setAttribute("loginUser", null);
        return "front/video-search";
    }

}