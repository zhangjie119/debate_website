package com.debateweb.service.impl;

import com.debateweb.entity.Event;
import com.debateweb.dao.EventDao;
import com.debateweb.service.EventService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Event)表服务实现类
 *
 * @author makejava
 * @since 2020-04-28 22:48:56
 */
@Service("eventService")
public class EventServiceImpl implements EventService {
    @Resource
    private EventDao eventDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Event queryById(Integer id) {
        return this.eventDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<Event> queryAll() {
        return this.eventDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param event 实例对象
     * @return 实例对象
     */
    @Override
    public Event insert(Event event) {
        this.eventDao.insert(event);
        return event;
    }

    /**
     * 修改数据
     *
     * @param event 实例对象
     * @return 实例对象
     */
    @Override
    public Event update(Event event) {
        this.eventDao.update(event);
        return this.queryById(event.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.eventDao.deleteById(id) > 0;
    }
}