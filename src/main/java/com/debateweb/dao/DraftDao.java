package com.debateweb.dao;

import com.debateweb.entity.Draft;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (Draft)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-26 15:29:23
 */
public interface DraftDao {

    /**
     * 通过ID查询单条数据
     *
     * @param did 主键
     * @return 实例对象
     */
    @Select("select * from draft where did = #{did}")
    Draft queryById(Integer did);

    /**
     * 根据用户id查询数据列表
     *
     * @param uid 用户id
     * @return 稿件对象列表
     */
    @Select("select * from draft where uploaderID = #{uid}")
    List<Draft> queryByUid(Integer uid);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param draft 实例对象
     * @return 对象列表
     */
    List<Draft> queryAll(Draft draft);

    /**
     * 新增数据
     *
     * @param draft 实例对象
     * @return 影响行数
     */
    @Insert("insert into draft(draftName, draftSchool, draftType, uploaderID, uploder, address)" +
            "values (#{draftname}, #{draftschool}, #{drafttype}, #{uploaderid}, #{uploder}, #{address})")
    int insert(Draft draft);

    /**
     * 修改数据
     *
     * @param draft 实例对象
     * @return 影响行数
     */
    @Update("update draft set " +
            "draftName = #{draftname}, draftSchool = #{draftschool}, draftType = #{drafttype}" +
            "where dId = #{did}")
    int update(Draft draft);

    /**
     * 通过主键删除数据
     *
     * @param did 主键
     * @return 影响行数
     */
    @Delete("delete from draft where dId = #{did}")
    int deleteById(Integer did);

    /**
     * 通过关键词查询数据
     *
     * @param keyword 关键字
     * @return 对象集合
     */
    @Select("select * from draft where draftName like #{keyword} or draftSchool like #{keyword} or draftType like #{keyword}" +
            "order by (length(draftName)-length(#{keyword}))" )
    List<Draft> queryByKeyword(String keyword);

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Select("select * from draft")
    List<Draft> queryAll();
}