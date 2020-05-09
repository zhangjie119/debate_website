package com.debateweb.controller;

import com.debateweb.entity.Event;
import com.debateweb.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Event)表控制层
 *
 * @author makejava
 * @since 2020-04-28 22:48:56
 */
@Controller
@RequestMapping("event")
public class EventController {
    /**
     * 服务对象
     */
    @Resource
    private EventService eventService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Event selectOne(Integer id) {
        return this.eventService.queryById(id);
    }

}