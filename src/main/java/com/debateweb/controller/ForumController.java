package com.debateweb.controller;

import com.debateweb.entity.Article;
import com.debateweb.entity.Comment;
import com.debateweb.entity.Plate;
import com.debateweb.service.ArticleService;
import com.debateweb.service.CommentService;
import com.debateweb.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 论坛主页
 *
 */
@Controller
@RequestMapping("forum")
public class ForumController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private PlateService plateService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/main")
    public String forum(Map<Object, Object> map) {
        //添加所有帖子信息
        List<Article> listArticle = articleService.queryAll();
        map.put("articles", listArticle);

        //添加所有板块信息
        List<Plate> listPlate = plateService.queryAll();
        map.put("plates", listPlate);

        //获取热门帖子
        List<Article> hotArticleList = articleService.queryHotArticles();
        map.put("hotArticleList", hotArticleList);

        return "front/forumPages/forum";
    }

    @RequestMapping("/uploadArticle")
    public String uploadArticle(Map<Object, Object> map) {
        //添加所有板块信息
        List<Plate> listPlate = plateService.queryAll();
        map.put("plates", listPlate);
        return "front/forumPages/article-upload";
    }

    @RequestMapping("/searchByKeyword")
    public String searchByKeyword(Map<Object, Object> map, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        //添加根据关键字得到的帖子
        List<Article> articles = articleService.queryByKeyword(keyword);
        map.put("articles", articles);

        //添加所有板块信息
        List<Plate> listPlate = plateService.queryAll();
        map.put("plates", listPlate);

        //获取热门帖子
        List<Article> hotArticleList = articleService.queryHotArticles();
        map.put("hotArticleList", hotArticleList);

        //添加原始关键字
        map.put("keyword", keyword);
        return "front/forumPages/forum";
    }

    @RequestMapping("/lookingArticle")
    public String lookingArticle(Map<String, Object> map, @RequestParam(name = "fid", required = true) Integer fid) {
        //根据帖子id获取帖子信息
        Article article = articleService.queryById(fid);
        this.articleService.click(article.getFid(), article.getHits());
        map.put("article", article);

        //添加帖子的id获取帖子评论
        List<Comment> comments = commentService.queryByArticle(fid);
        map.put("comments", comments);


        return "front/forumPages/article-looking";
    }

    @PostMapping("/reply")
    public String reply(@RequestParam Integer fid, @RequestParam Integer uid, @RequestParam String nickname, @RequestParam String pcontent) {
        //添加回帖信息
        this.commentService.reply(fid, uid, nickname, pcontent);

        //重定向到浏览帖子方法
        return "redirect:/forum/lookingArticle?fid=" + fid;

    }

}
