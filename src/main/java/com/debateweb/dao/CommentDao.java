package com.debateweb.dao;

import com.debateweb.entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 评论表(Comment)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-04 16:25:50
 */
public interface CommentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    Comment queryById(Integer pid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Comment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 查询所有回复
     *
     * @return 对象列表
     */
    @Select("select * from comment")
    List<Comment> queryAll();

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 影响行数
     */
    @Insert("insert into comment(pcontent, userid, username, fid) values (#{pcontent}, #{userid}, #{username}, #{fid})")
    int insert(Comment comment);

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 影响行数
     */
    int update(Comment comment);

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 影响行数
     */
    int deleteById(Integer pid);

    /**
     * 根据帖子ID查找回帖
     *
     * @param fid
     * @return
     */
    @Select("select * from comment where fid = #{fid}")
    List<Comment> queryByArticle(Integer fid);

    @Delete("delete from comment where fid = #{fid}")
    void deleteByFid(Integer fid);

}