package com.debateweb.controller;

import com.debateweb.entity.Article;
import com.debateweb.entity.Plate;
import com.debateweb.service.ArticleService;
import com.debateweb.service.PlateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 板块表(Plate)表控制层
 *
 * @author makejava
 * @since 2020-04-04 16:25:50
 */
@Controller
@RequestMapping("plate")
public class PlateController {
    /**
     * 服务对象
     */
    @Resource
    private PlateService plateService;

    @Resource
    private ArticleService articleService;

    @RequestMapping("findAll")
    public String findAll(Map<String, Object> map, @RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "5") int size) {
        map.put("pageInfo", this.plateInfo(page,size));
        return "back/plate-list";
    }

    //为新建帖子页面获取板块信息
    @RequestMapping("article-add")
    public String uploadArticle(Map<Object, Object> map) {
        //添加所有板块信息
        List<Plate> listPlate = plateService.queryAll();
        map.put("plates", listPlate);
        return "back/article-add";
    }

    @RequestMapping("delete")
    public String delete(Map<Object, Object> map, @RequestParam(name = "bid" , required = true) int bid) {
        String bname = plateService.queryById(bid).getBname();
        this.articleService.updatePlate(bname);
        this.plateService.deleteById(bid);
        map.put("pageInfo", this.plateInfo(1,8));
        return "back/plate-list";
    }

    //获取板块分页信息
    public PageInfo plateInfo(int page, int size) {
        //添加所有板块信息
        List<Plate> plates = plateService.queryAll(page, size);
        //返回一个分页bean
        return new PageInfo(plates);
    }
}