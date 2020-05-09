package com.debateweb.dao;

import com.debateweb.entity.Event;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    int insert(Event event);

    /**
     * 修改数据
     *
     * @param event 实例对象
     * @return 影响行数
     */
    int update(Event event);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}