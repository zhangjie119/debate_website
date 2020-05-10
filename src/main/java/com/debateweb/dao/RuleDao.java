package com.debateweb.dao;

import com.debateweb.entity.Rule;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (Rule)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-10 22:37:30
 */
public interface RuleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select * from rule where id = #{id}")
    Rule queryById(Integer id);

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Select("select * from rule")
    List<Rule> queryAll();

    /**
     * 新增数据
     *
     * @param rule 实例对象
     * @return 影响行数
     */
    @Insert("insert into rule (linkName, linkRule) values (#{linkname}, #{linkrule})")
    int insert(Rule rule);

    /**
     * 修改数据
     *
     * @param rule 实例对象
     * @return 影响行数
     */
    @Update("update  rule set linkName = #{linkname}, linkRule = #{linkrule} where id = {id}")
    int update(Rule rule);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("delete from rule where id = #{id}")
    int deleteById(Integer id);

}