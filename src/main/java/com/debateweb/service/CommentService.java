package com.debateweb.service;

import com.debateweb.entity.Comment;
import java.util.List;

/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2020-04-04 16:25:50
 */
public interface CommentService {

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    Comment queryById(Integer pid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Comment> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    Comment insert(Comment comment);

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    Comment update(Comment comment);

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer pid);

    /**
     * 根据帖子的ID查找回帖
     *
     * @param fid 主贴id
     * @return 回帖列表
     */
    List<Comment> queryByArticle(Integer fid);

    /**
     * 根据帖子的ID分页查找回帖
     *
     * @param fid 主贴id
     * @param page 页码
     * @param size 页面大小
     * @return 回帖列表
     */
    List<Comment> queryByArticle(Integer fid, int page, int size);

    /**
     * 添加回帖
     *
     * @param fid 主贴id
     * @param uid 回帖人id
     * @param nickname 回帖人昵称
     * @param pcontent 回帖内容
     * @return 成功与否
     */
    boolean reply(Integer fid, Integer uid, String nickname, String pcontent);

    /**
     * 查询全部评论
     *
     * @return 对象列表
     */
    List<Comment> queryAll();

    /**
     * 根据帖子的id删除该贴的评论
     */
    void deleteByFid(int fid);
}