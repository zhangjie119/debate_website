package com.debateweb.dao;

import com.debateweb.entity.Event;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (Event)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-28 22:48:56
 */
public interface EventDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select * from event where id = #{id}")
    Event queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    @Select("select * from event")
    List<Event> queryAll();


    /**
     * 新增数据
     *
     * @param event 实例对象
     * @return 影响行数
     */
    @Insert("insert into event (eventName, eventInfo, eventFormat) values (#{eventname}, #{eventinfo}, #{eventformat})")
    int insert(Event event);

    /**
     * 修改数据
     *
     * @param event 实例对象
     * @return 影响行数
     */
    @Update("update event set " +
            "eventName = #{eventname}, " +
            "eventInfo = #{eventinfo}, " +
            "eventFormat = #{eventformat} " +
            "where id = #{id}")
    int update(Event event);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("delete from event where id = #{id}")
    int deleteById(Integer id);

}