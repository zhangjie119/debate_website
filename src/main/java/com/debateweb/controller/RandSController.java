package com.debateweb.controller;

import com.debateweb.entity.Event;
import com.debateweb.service.EventService;
import com.debateweb.service.FormatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Event)表控制层
 *
 * @author makejava
 * @since 2020-04-28 22:48:56
 */
@Controller
@RequestMapping("RandS")
public class RandSController {
    /**
     * 服务对象
     */
    @Resource
    private EventService eventService;

    @Resource
    private FormatService formatService;

    @RequestMapping("findAll")
    public String findAll(Map<String, Object> map) {
        List<Event> events = eventService.queryAll();
        map.put("events", events);
        return "front/ruleAndSkills";
    }
}