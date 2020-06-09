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

    /**
     * 查询所有规则
     *
     * @return 规则列表
     */
    @RequestMapping("/findAll")
    public String findAll(Map<String, Object> map) {
        List<Rule> ruleList = ruleService.queryAll();
        map.put("ruleList", ruleList);

        return "back/rulePages/rule-list";
    }

    /**
     * 添加规则
     *
     * @param linkName 环节名
     * @param linkRule 环节规则
     * @return 成功页面
     */
    @RequestMapping("/add")
    public String add(@RequestParam String linkName,
                      @RequestParam String linkRule) {

        //添加新的规则
        this.ruleService.insert(new Rule(linkName, linkRule));
        return "SorF/ruleAdd-success";
    }

    /**
     * 跳转至修改规则页面
     *
     * @param rid 规则id
     * @return
     */
    @RequestMapping("/revise")
    public String revise(Map<String, Object> map,
                         @RequestParam(name = "rid", required = true) Integer rid) {

        map.put("rule", this.ruleService.queryById(rid));
        return "back/rulePages/rule-revise";
    }

    /**
     * 对规则进行修改
     *
     * @param rid       规则id
     * @param linkName  环节名
     * @param linkRule  环节规则
     * @return 成功与否页面
     */
    @RequestMapping("/update")
    public String update(@RequestParam Integer rid,
                         @RequestParam String linkName,
                         @RequestParam String linkRule) {

        this.ruleService.update(new Rule(rid, linkName, linkRule));
        return "SorF/ruleUpdate-success";
    }

    /**
     * 删除某条规则
     *
     * @param rid 规则id
     * @return
     */
    @RequestMapping("/delete")
    public String delete(Map<String,Object> map,
                         @RequestParam(name = "rid", required = true) Integer rid) {
        this.ruleService.deleteById(rid);

        return "redirect:/rule/findAll";
    }
}