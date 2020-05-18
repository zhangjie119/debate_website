package com.debateweb.controller;

import com.debateweb.entity.Event;
import com.debateweb.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Event)表控制层
 *
 * @author makejava
 * @since 2020-05-10 22:37:30
 */
@Controller
@RequestMapping("event")
public class EventController {
    /**
     * 服务对象
     */
    @Resource
    private EventService eventService;

    //查询所有规则
    @RequestMapping("findAll")
    public String findAll(Map<String, Object> map) {
        List<Event> eventList = eventService.queryAll();
        map.put("eventList", eventList);

        return "back/eventPages/event-list";
    }

    //添加规则
    @RequestMapping("add")
    public String add(@RequestParam String eventName,
                      @RequestParam String eventInfo,
                      @RequestParam String eventFormat) {

        //添加新的规则
        this.eventService.insert(new Event(null,eventName, eventInfo, eventFormat));
        return "SorF/eventAdd-success";
    }

    //修改规则页面
    @RequestMapping("revise")
    public String revise(Map<String, Object> map,
                         @RequestParam(name = "eid", required = true) Integer eid) {

        map.put("event", this.eventService.queryById(eid));
        return "back/eventPages/event-revise";
    }

    //对规则进行修改
    @RequestMapping("update")
    public String update(@RequestParam Integer eid,
                         @RequestParam String eventName,
                         @RequestParam String eventInfo,
                         @RequestParam String eventFormat) {

        this.eventService.update(new Event(eid,eventName, eventInfo, eventFormat));
        return "SorF/ruleUpdate-success";
    }

    //删除某条规则
    @RequestMapping("delete")
    public String delete(Map<String,Object> map,
                        @RequestParam(name = "eid", required = true) Integer eid) {
        this.eventService.deleteById(eid);

        return findAll(map);
    }
}