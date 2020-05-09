package com.debateweb.service.impl;

import com.debateweb.entity.Comment;
import com.debateweb.dao.CommentDao;
import com.debateweb.service.CommentService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论表(Comment)表服务实现类
 *
 * @author makejava
 * @since 2020-04-04 16:25:50
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentDao commentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    @Override
    public Comment queryById(Integer pid) {
        return this.commentDao.queryById(pid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Comment> queryAllByLimit(int offset, int limit) {
        return this.commentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment insert(Comment comment) {
        this.commentDao.insert(comment);
        return comment;
    }

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment update(Comment comment) {
        this.commentDao.update(comment);
        return this.queryById(comment.getPid());
    }

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer pid) {
        return this.commentDao.deleteById(pid) > 0;
    }

    /**
     * 根据帖子的ID查找回帖
     *
     * @param fid
     * @return 回帖列表
     */
    @Override
    public List<Comment> queryByArticle(Integer fid) {
        return this.commentDao.queryByArticle(fid);
    }

    /**
     * 根据帖子的ID分页查找回帖
     *
     * @param fid 主贴id
     * @param page 页码
     * @param size 页面大小
     * @return 回帖列表
     */
    @Override
    public List<Comment> queryByArticle(Integer fid, int page, int size) {
        PageHelper.startPage(page, size);
        return this.commentDao.queryByArticle(fid);
    }

    @Override
    public boolean reply(Integer fid, Integer uid, String nickname, String pcontent) {
        Comment comment = new Comment();
        comment.setFid(fid);
        comment.setUserid(uid);
        comment.setUsername(nickname);
        comment.setPcontent(pcontent);
        return this.commentDao.insert(comment) > 0;
    }

    @Override
    public List<Comment> queryAll() {
        return this.commentDao.queryAll();
    }

    @Override
    public void deleteByFid(int fid) {
        this.commentDao.deleteByFid(fid);
    }
}