package com.debateweb.service;

import com.debateweb.entity.Video;

import java.util.List;

/**
 * (Video)表服务接口
 *
 * @author makejava
 * @since 2020-03-30 23:51:00
 */
public interface VideoService {

    /**
     * 通过ID查询单条数据
     *
     * @param vid 主键
     * @return 实例对象
     */
    Video queryById(Integer vid);

    /**
     * 根据用户的id查找其上传的视频
     *
     * @param uid 用户id
     * @return 视频对象列表
     */
    List<Video> queryByUid(Integer uid);

    /**
     * 新增数据
     *
     * @param video 实例对象
     * @return 实例对象
     */
    Video insert(Video video);

    /**
     * 修改数据
     *
     * @param video 实例对象
     * @return 实例对象
     */
    Boolean update(Video video);

    /**
     * 通过主键删除数据
     *
     * @param vid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer vid);

    /**
     * 根据关键字查找数据
     *
     * @param keyword 关键字
     * @return 对象列表
     */
    List<Video> queryByKeyword(String keyword);

    /**
     * 在数据库添加新视频信息
     *
     * @param debateSubject 辩题
     * @param raceName 赛事名称
     * @param pros 正方
     * @param cons 反方
     * @param starDebater 明星辩手
     * @param uploaderId 上传者id
     * @param uploader 上传者昵称
     * @param address 视频地址
     * @return 是否成功
     */
    boolean upload(String debateSubject, String raceName, String pros, String cons, String starDebater, Integer uploaderId, String uploader, String address);

    /**
     * 分页查询所有视频
     *
     * @param page 页码
     * @param size 每页数量
     * @return 对象列表
     */
    List<Video> queryAll(int page, int size);

    /**
     * 刷新播放数
     *
     * @param video 实例对象
     * @return 是否成功
     */
    boolean addPlaytimes(Video video);
}