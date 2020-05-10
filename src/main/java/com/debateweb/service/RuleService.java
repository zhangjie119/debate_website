package com.debateweb.service;

import com.debateweb.entity.Rule;
import java.util.List;

/**
 * (Rule)表服务接口
 *
 * @author makejava
 * @since 2020-05-10 22:37:30
 */
public interface RuleService {

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<Rule> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Rule queryById(Integer id);

    /**
     * 新增数据
     *
     * @param rule 实例对象
     * @return 实例对象
     */
    Rule insert(Rule rule);

    /**
     * 修改数据
     *
     * @param rule 实例对象
     * @return 实例对象
     */
    Rule update(Rule rule);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}