package com.debateweb.controller;

import com.debateweb.entity.Event;
import com.debateweb.entity.Rule;
import com.debateweb.service.EventService;
import com.debateweb.service.RuleService;
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
    private RuleService ruleService;

    @RequestMapping("findAll")
    public String findAll(Map<String, Object> map) {
        List<Rule> ruleList = ruleService.queryAll();
        List<Event> eventList = eventService.queryAll();

        map.put("eventList", eventList);
        map.put("ruleList", ruleList);
        return "front/ruleAndSkills";
    }
}