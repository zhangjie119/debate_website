package com.debateweb.dao;

import com.debateweb.entity.Format;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Format)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-28 22:50:03
 */
public interface FormatDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Format queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Format> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param format 实例对象
     * @return 对象列表
     */
    List<Format> queryAll(Format format);

    /**
     * 新增数据
     *
     * @param format 实例对象
     * @return 影响行数
     */
    int insert(Format format);

    /**
     * 修改数据
     *
     * @param format 实例对象
     * @return 影响行数
     */
    int update(Format format);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}