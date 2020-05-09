package com.debateweb.controller;

import com.debateweb.entity.Format;
import com.debateweb.service.FormatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Format)表控制层
 *
 * @author makejava
 * @since 2020-04-28 22:50:03
 */
@Controller
@RequestMapping("format")
public class FormatController {
    /**
     * 服务对象
     */
    @Resource
    private FormatService formatService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Format selectOne(Integer id) {
        return this.formatService.queryById(id);
    }

}