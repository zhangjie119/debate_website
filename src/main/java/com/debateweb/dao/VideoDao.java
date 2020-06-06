package com.debateweb.dao;

import com.debateweb.entity.Video;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (Video)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-30 23:51:00
 */
public interface VideoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param vid 主键
     * @return 实例对象
     */
    @Select("select * from video where vId = #{vid}")
    Video queryById(Integer vid);

    /**
     * 根据用户的id查找其上传的视频
     *
     * @param uid 用户id
     * @return 视频对象列表
     */
    @Select("select * from video where uploaderID = #{uid}")
    List<Video> queryByUid(Integer uid);

    /**
     * 查询所有video
     *
     *
     * @return 对象列表
     */
    @Select("select * from video")
    List<Video> queryAll();

    /**
     * 新增数据
     *
     * @param video 实例对象
     * @return 影响行数
     */
    @Insert("insert into video(debateSubject, raceName, pros, cons, starDebater, uploaderID, uploader, address)" +
            "values (#{debatesubject}, #{racename}, #{pros}, #{cons}, #{stardebater}, #{uploaderid}, #{uploader}, #{address})")
    int insert(Video video);

    /**
     * 修改数据
     *
     * @param video 实例对象
     * @return 影响行数
     */
    @Update("update video set " +
            "debateSubject = #{debatesubject}, raceName = #{racename}, pros = #{pros}, cons = #{cons}, starDebater = #{stardebater}" +
            "where vId = #{vid}")
    int update(Video video);

    /**
     * 通过主键删除数据
     *
     * @param vid 主键
     * @return 影响行数
     */
    @Delete("delete from video where vId = #{vid}")
    int deleteById(Integer vid);

    /**
     * 根据关键字查找数据
     *
     * @param keyword 关键字
     * @return 对象列表
     */
    @Select("select * from video where debateSubject like #{keyword} or raceName like #{keyword} or pros like #{keyword}" +
            "or cons like #{keyword} or starDebater like #{keyword} order by (length(debateSubject)-length(#{keyword}))" )
    List<Video> queryByKeyword(String keyword);

    /**
     * 刷新播放数
     *
     * @param video 实例对象
     * @return 影响行数
     */
    @Update("update video set " +
            "playTimes = #{playtimes} " +
            "where vId = #{vid}")
    int addPlaytimes(Video video);
}