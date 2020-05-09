package com.debateweb.service.impl;

import com.debateweb.entity.Format;
import com.debateweb.dao.FormatDao;
import com.debateweb.service.FormatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Format)表服务实现类
 *
 * @author makejava
 * @since 2020-04-28 22:50:03
 */
@Service("formatService")
public class FormatServiceImpl implements FormatService {
    @Resource
    private FormatDao formatDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Format queryById(Integer id) {
        return this.formatDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Format> queryAllByLimit(int offset, int limit) {
        return this.formatDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param format 实例对象
     * @return 实例对象
     */
    @Override
    public Format insert(Format format) {
        this.formatDao.insert(format);
        return format;
    }

    /**
     * 修改数据
     *
     * @param format 实例对象
     * @return 实例对象
     */
    @Override
    public Format update(Format format) {
        this.formatDao.update(format);
        return this.queryById(format.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.formatDao.deleteById(id) > 0;
    }
}