package com.debateweb.controller;

import com.debateweb.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2020-03-21 17:16:44
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    //查询所有管理员
    @RequestMapping("/findAll")
    public ModelAndView findAllAdmin(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "5") int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", this.userinfo(page,size));
        mv.setViewName("back/userPages/admin-list");
        return mv;
    }

    //注销（删除）管理员
    @RequestMapping("delete")
    public String delete(Map<String, Object> map,
                         @RequestParam(name = "uid", required = true) Integer uid,
                         @RequestParam(name = "page", required = true, defaultValue = "1") int page,
                         @RequestParam(name = "size", required = true, defaultValue = "7") int size) {
        this.userService.deleteById(uid);
        map.put("pageInfo", this.userinfo(page,size));

        return "back/userPages/admin-list";
    }


    //查询所有管理员并加分页bean
    public PageInfo userinfo(int page, int size) {
        //isAdmin默认为true
        return new PageInfo(userService.findAll(page, size, true));
    }
}