package com.debateweb.service;

import com.debateweb.entity.Plate;
import java.util.List;

/**
 * 板块表(Plate)表服务接口
 *
 * @author makejava
 * @since 2020-04-04 16:25:50
 */
public interface PlateService {

    /**
     * 通过ID查询单条数据
     *
     * @param bid 主键
     * @return 实例对象
     */
    Plate queryById(Integer bid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Plate> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param plate 实例对象
     * @return 实例对象
     */
    Plate insert(Plate plate);

    /**
     * 修改数据
     *
     * @param plate 实例对象
     * @return 实例对象
     */
    Plate update(Plate plate);

    /**
     * 通过主键删除数据
     *
     * @param bid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer bid);

    /**
     * 查询所有板块
     *
     * @return 对象列表
     */
    List<Plate> queryAll();

    /**
     * 分页查询所有板块
     *
     * @return 对象列表
     */
    List<Plate> queryAll(int page, int size);
}