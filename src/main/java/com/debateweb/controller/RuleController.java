package com.debateweb.controller;

import com.debateweb.entity.Rule;
import com.debateweb.service.RuleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Rule)表控制层
 *
 * @author makejava
 * @since 2020-05-10 22:37:30
 */
@Controller
@RequestMapping("rule")
public class RuleController {
    /**
     * 服务对象
     */
    @Resource
    private RuleService ruleService;

    //查询所有规则
    @RequestMapping("findAll")
    public String findAll(Map<String, Object> map) {
        List<Rule> ruleList = ruleService.queryAll();
        map.put("ruleList", ruleList);

        return "back/rulePages/rule-list";
    }

    //添加规则
    @RequestMapping("add")
    public String add(@RequestParam String linkName,
                      @RequestParam String linkRule) {

        //添加新的规则
        this.ruleService.insert(new Rule(linkName, linkRule));
        return "SorF/ruleAdd-success";
    }

    //修改规则页面
    @RequestMapping("revise")
    public String revise(Map<String, Object> map,
                         @RequestParam(name = "rid", required = true) Integer rid) {

        map.put("rule", this.ruleService.queryById(rid));
        return "back/rulePages/rule-revise";
    }

    //对规则进行修改
    @RequestMapping("update")
    public String update(@RequestParam Integer rid,
                         @RequestParam String linkName,
                         @RequestParam String linkRule) {

        this.ruleService.update(new Rule(rid, linkName, linkRule));
        return "SorF/ruleUpdate-success";
    }

    //删除某条规则
    @RequestMapping("delete")
    public String delete(Map<String,Object> map,
                         @RequestParam(name = "rid", required = true) Integer rid) {
        this.ruleService.deleteById(rid);

        return findAll(map);
    }
}