package com.debateweb.service.impl;

import com.debateweb.entity.User;
import com.debateweb.dao.UserDao;
import com.debateweb.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2020-03-21 17:16:49
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User queryByUsername(String username) {
        return userDao.queryByUsername(username);
    }

    /**
     * 查询user表中所有用户
     *
     * @param page 页码数
     * @param size 每页数据条数
     * @param isAdmin 是否为管理员
     * @return 对象列表
     */
    @Override
    public List<User> findAll(int page, int size, boolean isAdmin) {
        PageHelper.startPage(page, size);
        return userDao.findAll(isAdmin);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }

    @Override
    public boolean loginCheck(String username, String password) {
        User user = userDao.queryByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean register(String username, String nickname, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setNickname(nickname);
        user.setPassword(password);
        user.setEmail(email);
        user.setSex("未知");
        return this.userDao.insert(user) > 0;
    }

    @Override
    public boolean checkUsername(String username) {
        return this.userDao.checkUsername(username) > 0;
    }
}
