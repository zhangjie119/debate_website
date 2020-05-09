package com.debateweb.service;

import com.debateweb.entity.Article;
import java.util.List;

/**
 * 发帖表(Article)表服务接口
 *
 * @author makejava
 * @since 2020-04-04 16:25:50
 */
public interface ArticleService {

    /**
     * 通过ID查询单条数据
     *
     * @param fid 主键
     * @return 实例对象
     */
    List<Article> queryById(Integer fid);

    /**
     * 通过用户ID查询多条数据
     *
     * @param uid 用户id
     * @return 实例对象
     */
    List<Article> queryByUid(Integer uid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Article> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    Article insert(Article article);

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    Article update(Article article);

    /**
     * 通过主键删除数据
     *
     * @param fid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer fid);

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<Article> queryAll();

    /**
     * 分页查询所有帖子
     *
     * @param page 页码
     * @param size 每页数量
     * @return 对象列表
     */
    List<Article> queryAll(int page, int size);

    /**
     * 根据关键字模糊查找数据
     *
     * @param keyword
     * @return 是否成功
     */
    List<Article> queryByKeyword(String keyword);

    /**
     * 上传帖子
     *
     * @param title     帖子标题
     * @param plate     帖子所属板块
     * @param fcontent  帖子内容
     * @param uid       发帖人id
     * @param unickname 发帖人昵称
     * @param address   帖子配图路径
     * @return 是否成功
     */
    boolean upload(String title, String plate, String fcontent, Integer uid, String unickname, String address);

    /**
     * 查询所有待审核的帖子
     *
     * @param page 页码
     * @param size 每页数量
     * @return 对象列表
     */
    List<Article> queryUnApproval(int page, int size);

    /**
     * 修改帖子所属板块为“随便聊聊”
     *
     * @param bname 原板块名
     * @return 成功与否
     */
    boolean updatePlate(String bname);

}