package com.debateweb.service;

import com.debateweb.entity.Format;
import java.util.List;

/**
 * (Format)表服务接口
 *
 * @author makejava
 * @since 2020-04-28 22:50:03
 */
public interface FormatService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Format queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Format> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param format 实例对象
     * @return 实例对象
     */
    Format insert(Format format);

    /**
     * 修改数据
     *
     * @param format 实例对象
     * @return 实例对象
     */
    Format update(Format format);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}