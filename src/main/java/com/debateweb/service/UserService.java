package com.debateweb.service;

import com.debateweb.entity.User;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2020-03-21 17:16:49
 */
public interface UserService {

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 实例对象
     */
    User queryByUsername(String username);

    /**
     * 查询user表中所有用户
     *
     * @param page 页码数
     * @param size 每页数据条数
     * @param isAdmin 是否为管理员
     * @return 对象列表
     */
    List<User> findAll(int page, int size, boolean isAdmin);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 检查能否登陆成功
     *
     * @param username 用户名
     * @param password  密码
     * @return 是否成功
     */
    boolean loginCheck(String username, String password);

    /**
     * 注册用户
     *
     * @param username
     * @param nickname
     * @param password
     * @param email
     * @return 成功与否
     */
    boolean register(String username, String nickname, String password, String email);

    /**
     * 获取表中全部的username
     *
     * @return username集合
     */
    boolean checkUsername(String username);
}