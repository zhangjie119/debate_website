package com.debateweb.dao;

import com.debateweb.entity.Plate;
import com.github.pagehelper.ISelect;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 板块表(Plate)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-04 16:25:50
 */
public interface PlateDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bid 主键
     * @return 实例对象
     */
    @Select("select * from plate where bid = #{bid}")
    Plate queryById(Integer bid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Plate> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 新增数据
     *
     * @param plate 实例对象
     * @return 影响行数
     */
    int insert(Plate plate);

    /**
     * 修改数据
     *
     * @param plate 实例对象
     * @return 影响行数
     */
    int update(Plate plate);

    /**
     * 通过主键删除数据
     *
     * @param bid 主键
     * @return 影响行数
     */
    @Delete("delete from plate where bid = #{bid}")
    int deleteById(Integer bid);

    /**
     * 查找所有板块
     *
     * @return 对象列表
     */
    @Select("select * from plate")
    List<Plate> queryAll();
}