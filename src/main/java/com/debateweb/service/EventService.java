package com.debateweb.service;

import com.debateweb.entity.Event;
import java.util.List;

/**
 * (Event)表服务接口
 *
 * @author makejava
 * @since 2020-04-28 22:48:56
 */
public interface EventService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Event queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    List<Event> queryAll();

    /**
     * 新增数据
     *
     * @param event 实例对象
     * @return 实例对象
     */
    Event insert(Event event);

    /**
     * 修改数据
     *
     * @param event 实例对象
     * @return 实例对象
     */
    Event update(Event event);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}