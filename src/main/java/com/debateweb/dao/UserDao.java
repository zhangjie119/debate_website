package com.debateweb.dao;

import com.debateweb.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-21 17:16:49
 */
public interface UserDao {

    /**
     * 查询所有用户
     *
     * @return 对象列表
     */
    @Select("select * from user where isAdmin = #{isAdmin}")
    List<User> findAll(boolean isAdmin);

    /**
     * 根据用户名查询单条数据
     *
     * @param username
     * @return 实例对象
     */
    @Select("select * from user where username = #{username}")
    User queryByUsername(String username);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select * from user where ID = #{id}")
    User queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param user 实例对象
     * @return 对象列表
     */
    List<User> queryAll(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    @Insert("insert into user (nickname, username, password, sex, email) values " +
            "(#{nickname}, #{username}, #{password}, #{sex}, #{email})")
    int insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    @Update("update user set " +
            "nickname = #{nickname}, " +
            "sex = #{sex}, " +
            "phoneNum = #{phonenum}, " +
            "email = #{email}, " +
            "birthday = #{birthday}, " +
            "notes = #{notes}, " +
            "address = #{address} " +
            "where ID = #{id}")
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("delete from user where ID = #{id}")
    int deleteById(Integer id);

    @Select("select count(*) from user where username = #{username}")
    int checkUsername(String username);


}