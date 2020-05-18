package com.debateweb.controller;

import com.debateweb.entity.Comment;
import com.debateweb.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 评论表(Comment)表控制层
 *
 * @author makejava
 * @since 2020-04-04 16:25:50
 */
@Controller
@RequestMapping("comment")
public class CommentController {
    /**
     * 服务对象
     */
    @Resource
    private CommentService commentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Comment selectOne(Integer id) {
        return this.commentService.queryById(id);
    }

    //查询所有回复
    @RequestMapping("findAll")
    public String findAll(Map<String, Object> map) {
        List<Comment> comments = commentService.queryAll();
        map.put("comments", comments);
        return "back/forumPages/comment-list";
    }

    //根据帖子id查询该帖子的回复
    @RequestMapping("queryByArticle")
    public String queryByArticle(HttpSession session,
                                 Map<String, Object> map,
                                 @RequestParam(name = "fid", required = true) Integer fid,
                                 @RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                 @RequestParam(name = "size", required = true, defaultValue = "7") int size) {

        map.put("pageInfo", this.commentInfo(fid,page,size));
        //加入主贴id以供翻页使用
        map.put("articleId", fid);
        return "back/forumPages/comment-list";
    }

    @RequestMapping("delete")
    public String delete(Map<String, Object> map,
                         @RequestParam(name = "pid", required = true) Integer pid,
                         @RequestParam(name = "fid", required = true) Integer fid,
                         @RequestParam(name = "page", required = true) int page,
                         @RequestParam(name = "size", required = true) int size) {

        //根据回帖id删除该条回复
        this.commentService.deleteById(pid);

        //把最新的数据加入map
        map.put("pageInfo", this.commentInfo(fid,page,size));
        //加入主贴id以供翻页使用
        map.put("articleId", fid);

        return "back/forumPages/comment-list";
    }

    //根据帖子id获取帖子列表并加入分页bin
    public PageInfo commentInfo(Integer fid, int page, int size) {
        return new PageInfo(commentService.queryByArticle(fid,page,size));
    }
}