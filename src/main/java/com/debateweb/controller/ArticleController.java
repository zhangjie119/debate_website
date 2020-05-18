package com.debateweb.controller;

import com.debateweb.entity.Article;
import com.debateweb.entity.User;
import com.debateweb.service.ArticleService;
import com.debateweb.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 发帖表(Article)表控制层
 *
 * @author makejava
 * @since 2020-04-04 16:25:50
 */
@Controller
@RequestMapping("article")
public class ArticleController {
    /**
     * 服务对象
     */
    @Resource
    private ArticleService articleService;

    @Resource
    private CommentService commentService;

    /**
     * 查询发帖数量和信息
     */
    public void getArticle(Map<Object, Object> map) {
        List<Article> lisetArticle = articleService.queryAll();
        map.put("listArticle", lisetArticle);
    }

    @PostMapping("/upload")
    public String articleUpload(HttpServletRequest request, MultipartFile photo, @RequestParam String title, @RequestParam String plate, @RequestParam String fcontent) throws Exception {
        System.out.println("正在进行springMVC文件上传");
        HttpSession session = request.getSession();
        User uploader = (User) session.getAttribute("loginUser");
        String address = null;
        if (photo != null) {
            //使用fileupload组件完成文件上传
            //上传的位置
            String path = request.getSession().getServletContext().getRealPath("/img/article/");
            //判断该路径是否存在
            File file = new File(path);
            if (!file.exists()) {
                //创建该文件夹
                file.mkdirs();
            }
            //说明上传文件项
            //获取上传文件的名称
            String filename = photo.getOriginalFilename();
            //把文件名称设置唯一值
            String uuid = UUID.randomUUID().toString().replace("-", "");
            filename = uuid + "_" + filename;
            //完成文件上传
            photo.transferTo(new File(path,filename));
            address = "../../../img/article/" + filename;
        }
        if (articleService.upload(title, plate, fcontent, uploader.getId(), uploader.getNickname(), address)) {
            return "SorF/success";
        }
        return "SorF/fail";
    }

    @RequestMapping("findAll")
    public String findAll(Map<String, Object> map, @RequestParam(name = "page",required = true,defaultValue = "1") int page, @RequestParam(name = "size", required = true,defaultValue = "5") int size) {
        map.put("pageInfo", this.articleInfo(page,size));
        return "back/forumPages/article-list";
    }

    //审核帖子
    @RequestMapping("check")
    public String check(Map<String, Object> map, @RequestParam(name = "page",required = true,defaultValue = "1") int page) {
        List<Article> articles = articleService.queryUnApproval(page, 8);
        PageInfo pageInfo = new PageInfo(articles);
        map.put("pageInfo", pageInfo);
        return "back/forumPages/article-check";
    }

    //删除帖子
    @RequestMapping("delete")
    public String delete(Map<String, Object> map, @RequestParam(name = "fid",required = true) int fid) {
        //根据id删除帖子
        this.articleService.deleteById(fid);
        //根据帖子id删除回复
        this.commentService.deleteByFid(fid);
        map.put("pageInfo", this.articleInfo(1, 8));
        return "back/forumPages/article-list";
    }

    //审核通过帖子
    @RequestMapping("pass")
    public String pass(Map<String, Object> map, @RequestParam(name = "fid", required = true) int fid) {
        Article article = articleService.queryById(fid).get(0);
        article.setStatus(1);
        this.articleService.update(article);
        map.put("pageInfo", this.articleInfo(1, 5));
        return "back/forumPages/article-check";
    }

    //审核不通过帖子
    @RequestMapping("refuse")
    public String refuse(Map<String, Object> map, @RequestParam(name = "fid", required = true) int fid) {
        Article article = articleService.queryById(fid).get(0);
        article.setStatus(2);
        this.articleService.update(article);
        map.put("pageInfo", this.articleInfo(1, 5));
        return "back/forumPages/article-check";
    }

    public PageInfo articleInfo(int page, int size) {
        //获取帖子信息
        List<Article> articles = articleService.queryAll(page, size);
        //建立一个分页Bean
        PageInfo articleInfo = new PageInfo(articles);
        return articleInfo;
    }

}