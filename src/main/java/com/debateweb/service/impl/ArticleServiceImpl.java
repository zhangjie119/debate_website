package com.debateweb.service.impl;

import com.debateweb.entity.Article;
import com.debateweb.dao.ArticleDao;
import com.debateweb.service.ArticleService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 发帖表(Article)表服务实现类
 *
 * @author makejava
 * @since 2020-04-04 16:25:50
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleDao articleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param fid 主键
     * @return 实例对象
     */
    @Override
    public Article queryById(Integer fid) {
        return this.articleDao.queryById(fid);
    }

    /**
     * 通过用户ID查询多条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    @Override
    public List<Article> queryByUid(Integer uid) {
        return this.articleDao.queryByUid(uid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Article> queryAllByLimit(int offset, int limit) {
        return this.articleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    @Override
    public Article insert(Article article) {
        this.articleDao.insert(article);
        return article;
    }

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    @Override
    public Article update(Article article) {
        this.articleDao.update(article);
        //return this.queryById(article.getFid());
        return article;
    }

    /**
     * 通过主键删除数据
     *
     * @param fid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer fid) {
        return this.articleDao.deleteById(fid) > 0;
    }

    @Override
    public List<Article> queryAll() {
        return this.articleDao.queryAll();
    }

    @Override
    public List<Article> queryByKeyword(String keyword) {
        keyword = '%' + keyword + '%';
        return articleDao.queryByKeyword(keyword);
    }

    /**
     * 上传帖子
     *
     * @param title 帖子标题
     * @param plate 帖子所属板块
     * @param fcontent 帖子内容
     * @param uid 发帖人id
     * @param unickname 发帖人昵称
     * @param address 帖子配图路径
     * @return 是否成功
     */
    @Override
    public boolean upload(String title, String plate, String fcontent, Integer uid, String unickname, String address) {
        Article article = new Article();
        article.setTitles(title);
        article.setBname(plate);
        article.setFcontent(fcontent);
        article.setUserid(uid);
        article.setUsername(unickname);
        article.setStatus(0);
        article.setPhoto(address);
        return this.articleDao.insert(article) > 0;
    }

    /**
     * 分页查询所有帖子
     *
     * @param page 页码
     * @param size 每页数量
     * @return 对象列表
     */
    @Override
    public List<Article> queryAll(int page, int size) {
        PageHelper.startPage(page,size);
        return articleDao.queryAll();
    }

    /**
     * 查询所有待审核的帖子
     *
     * @param page 页码
     * @param size 每页数量
     * @return 对象列表
     */
    @Override
    public List<Article> queryUnApproval(int page, int size) {
        PageHelper.startPage(page,size);
        return this.articleDao.queryUnApproval();
    }

    /**
     * 修改帖子所属板块为“随便聊聊”
     *
     * @param bname 原板块名
     * @return 成功与否
     */
    @Override
    public boolean updatePlate(String bname) {
        return this.articleDao.updatePlate(bname) > 0;
    }

    /**
     * 修改帖子点击量
     *
     * @param hits 原板块名
     * @return 被影响行数
     */
    @Override
    public boolean click(Integer fid, Integer hits) {
        hits += 1;
        return this.articleDao.updateHits(fid,hits) > 0;
    }

    /**
     * 查询热门帖子（5条）
     *
     * @return 对象列表
     */
    @Override
    public List<Article> queryHotArticles() {
        return this.articleDao.queryHotArticles();
    }
}