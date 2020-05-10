package com.debateweb.service.impl;

import com.debateweb.entity.Rule;
import com.debateweb.dao.RuleDao;
import com.debateweb.service.RuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Rule)表服务实现类
 *
 * @author makejava
 * @since 2020-05-10 22:37:30
 */
@Service("ruleService")
public class RuleServiceImpl implements RuleService {
    @Resource
    private RuleDao ruleDao;

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<Rule> queryAll() {
        return this.ruleDao.queryAll();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Rule queryById(Integer id) {
        return this.ruleDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param rule 实例对象
     * @return 实例对象
     */
    @Override
    public Rule insert(Rule rule) {
        this.ruleDao.insert(rule);
        return rule;
    }

    /**
     * 修改数据
     *
     * @param rule 实例对象
     * @return 实例对象
     */
    @Override
    public Rule update(Rule rule) {
        this.ruleDao.update(rule);
        return this.queryById(rule.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.ruleDao.deleteById(id) > 0;
    }
}