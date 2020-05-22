package com.debateweb.dao;

import com.debateweb.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 发帖表(Article)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-04 16:25:50
 */
public interface ArticleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param fid 主键
     * @return 实例对象
     */
    @Select("select * from article where fid = #{fid}")
    Article queryById(Integer fid);

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    @Select("select * from article where userid = #{uid}")
    List<Article> queryByUid(Integer uid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Article> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 影响行数
     */
    @Insert("insert into article(titles, fcontent, photo, bname, userid, username, status)" +
            "values (#{titles}, #{fcontent}, #{photo}, #{bname}, #{userid}, #{username}, #{status})")
    int insert(Article article);

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 影响行数
     */
    @Update("update article set " +
            "status = #{status} " +
            "where fid = #{fid}")
    int update(Article article);

    /**
     * 通过主键删除数据
     *
     * @param fid 主键
     * @return 影响行数
     */
    @Delete("delete from article where fid = #{fid}")
    int deleteById(Integer fid);

    /**
     * 查询所有文章，并按id倒序排列
     *
     * @return
     */
    @Select("select * from article")
    List<Article> queryAll();

    /**
     * 根据关键字模糊查找帖子
     *
     * @param keyword 带查找关键字
     * @return
     */
    @Select("select * from article where titles like #{keyword} or fcontent like #{keyword} or username like #{keyword}" +
            "order by (length(titles)-length(#{keyword}))" )
    List<Article> queryByKeyword(String keyword);

    /**
     * 查询所有待审核帖子
     *
     * @return 对象列表
     */
    @Select("select * from article where status = 0")
    List<Article> queryUnApproval();

    /**
     * 修改帖子所属板块为“随便聊聊”
     *
     * @param bname 原板块名
     * @return 被影响行数
     */
    @Update("update article set bname = '随便聊聊' where bname = #{bname}")
    int updatePlate(String bname);

    /**
     * 修改帖子点击量
     *
     * @param hits 原板块名
     * @return 被影响行数
     */
    @Update("update article set hits = #{hits} where fid = #{fid}")
    int updateHits(@Param("fid") int fid, @Param("hits") int hits);

    @Select("select * from article order by hits desc limit 5")
    List<Article> queryHotArticles();
}