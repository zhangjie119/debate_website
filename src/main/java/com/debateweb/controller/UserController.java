package com.debateweb.controller;

import com.debateweb.entity.User;
import com.debateweb.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

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
        return "front/main";
    }

    /**
     * 查询所有用户数据
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
    public ModelAndView findAllUser(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "5") int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", this.userinfo(page,size));
        mv.setViewName("back/userPages/user-list");
        return mv;
    }

    @GetMapping("login")
    public String login(HttpServletRequest request, Map<String, Object> map) {
        //获取登录前的当前页
        String preUrl = request.getHeader("referer");
        map.put("preUrl", preUrl);

        return "login";
    }

    @PostMapping("/login")
    public String login(HttpSession session, @RequestParam String username, @RequestParam String password, @RequestParam String preUrl) {
        if (userService.loginCheck(username, password)) {
            User user = userService.queryByUsername(username);
            session.setAttribute("loginUser", user);
            //修改数据的时候要重定向
            if ("".equals(preUrl)) {
                return "front/videoPages/video-search";
            } else {
                return "redirect:" + preUrl;
            }
        } else {
            //转发才能接收到request
            return "SorF/failer";
        }
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String nickname, @RequestParam String password1, @RequestParam String email) {
        if (this.userService.checkUsername(username)) {
            System.err.println("用户注册失败,该用户名已存在");
            return "SorF/failer";
        }
        if (this.userService.register(username, nickname, password1, email)) {
            return "SorF/register-success";
        }
        return "SorF/failer";
    }

    //注销当前登录帐号
    @RequestMapping("logout")
    public String logout(HttpSession session, HttpServletResponse response) {
        session.setAttribute("loginUser", null);
        return "redirect:/pages/front/videoPages/video-search.jsp";
    }

    //后台详细信息
    @RequestMapping("information")
    public String information(Map<String, Object> map,
                              @RequestParam(name = "uid") Integer uid) {
        User user = userService.queryById(uid);
        map.put("user", user);
        return "back/userPages/user-information";
    }

    //切换到修改页面
    @RequestMapping("revise")
    public String revise(Map<String, Object> map,
                         @RequestParam Integer uid) {
        User user = userService.queryById(uid);
        map.put("user", user);

        return "back/userPages/user-revise";
    }

    //修改用户并跳转到该用户的用户详情页面
    @RequestMapping("update")
    public String update(Map<String, Object> map,
                         @RequestParam Integer uid,
                         @RequestParam String nickname,
                         @RequestParam String sex,
                         @RequestParam String phonenum,
                         @RequestParam String email,
                         @RequestParam String birthday,
                         @RequestParam String address,
                         @RequestParam String notes) {

        //实例化一个用户，并添加上述属性
        User user = new User(uid,nickname,sex,phonenum,email,birthday,notes,address);
        //更新该用户
        this.userService.update(user);
        //重新获取该用户并加入map
        map.put("user", this.userService.queryById(uid));
        return "back/userPages/user-information";
    }

    //注销（删除）用户
    @RequestMapping("delete")
    public String delete(Map<String, Object> map,
                         @RequestParam(name = "uid", required = true) Integer uid,
                         @RequestParam(name = "page", required = true, defaultValue = "1") int page,
                         @RequestParam(name = "size", required = true, defaultValue = "7") int size) {
        this.userService.deleteById(uid);
        map.put("pageInfo", this.userinfo(page,size));

        return "back/userPages/user-list";
    }

    //查询所有用户并加分页bean
    public PageInfo userinfo(int page, int size) {
        //isAdmin默认为false
        return new PageInfo(userService.findAll(page, size, false));
    }
}