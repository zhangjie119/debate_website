package com.debateweb.service.impl;

import com.debateweb.entity.Plate;
import com.debateweb.dao.PlateDao;
import com.debateweb.service.PlateService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 板块表(Plate)表服务实现类
 *
 * @author makejava
 * @since 2020-04-04 16:25:50
 */
@Service("plateService")
public class PlateServiceImpl implements PlateService {
    @Resource
    private PlateDao plateDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bid 主键
     * @return 实例对象
     */
    @Override
    public Plate queryById(Integer bid) {
        return this.plateDao.queryById(bid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Plate> queryAllByLimit(int offset, int limit) {
        return this.plateDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param plate 实例对象
     * @return 实例对象
     */
    @Override
    public Plate insert(Plate plate) {
        this.plateDao.insert(plate);
        return plate;
    }

    /**
     * 修改数据
     *
     * @param plate 实例对象
     * @return 实例对象
     */
    @Override
    public Plate update(Plate plate) {
        this.plateDao.update(plate);
        return this.queryById(plate.getBid());
    }

    /**
     * 通过主键删除数据
     *
     * @param bid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bid) {
        return this.plateDao.deleteById(bid) > 0;
    }

    /**
     * 查询所有板块
     *
     * @return 对象列表
     */
    @Override
    public List<Plate> queryAll() {
        return this.plateDao.queryAll();
    }

    /**
     * 分页查询所有板块
     *
     * @return 对象列表
     */
    @Override
    public List<Plate> queryAll(int page, int size) {
        PageHelper.startPage(page,size);
        return this.plateDao.queryAll();
    }
}