package com.debateweb.controller;

import com.debateweb.entity.Rule;
import com.debateweb.service.RuleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Rule)表控制层
 *
 * @author makejava
 * @since 2020-05-10 22:37:30
 */
@RestController
@RequestMapping("rule")
public class RuleController {
    /**
     * 服务对象
     */
    @Resource
    private RuleService ruleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Rule selectOne(Integer id) {
        return this.ruleService.queryById(id);
    }

}