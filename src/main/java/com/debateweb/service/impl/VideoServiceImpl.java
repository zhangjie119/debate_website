package com.debateweb.service.impl;

import com.debateweb.entity.Video;
import com.debateweb.dao.VideoDao;
import com.debateweb.service.VideoService;
import com.debateweb.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Video)表服务实现类
 *
 * @author makejava
 * @since 2020-03-30 23:51:00
 */
@Service("videoService")
public class VideoServiceImpl implements VideoService {
    @Resource
    private VideoDao videoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param vid 主键
     * @return 实例对象
     */
    @Override
    public Video queryById(Integer vid) {
        return this.videoDao.queryById(vid);
    }

    /**
     * 根据用户的id查找其上传的视频
     *
     * @param uid 用户id
     * @return 视频对象列表
     */
    @Override
    public List<Video> queryByUid(Integer uid) {
        return this.videoDao.queryByUid(uid);
    }

    /**
     * 新增数据
     *
     * @param video 实例对象
     * @return 实例对象
     */
    @Override
    public Video insert(Video video) {
        this.videoDao.insert(video);
        return video;
    }

    /**
     * 修改数据
     *
     * @param video 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean update(Video video) {
        return this.videoDao.update(video) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param vid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer vid) {
        return this.videoDao.deleteById(vid) > 0;
    }

    /**
     * 根据关键字查找数据
     *
     * @param keyword 关键字
     * @return 对象列表
     */
    @Override
    public List<Video> queryByKeyword(String keyword) {
        keyword = '%' + keyword + '%';
        return this.videoDao.queryByKeyword(keyword);
    }

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
    @Override
    public boolean upload(String debateSubject, String raceName, String pros, String cons, String starDebater, Integer uploaderId, String uploader, String address) {
        Video video = new Video();
        video.setDebatesubject(debateSubject);
        video.setRacename(raceName);
        video.setPros(pros);
        video.setCons(cons);
        video.setStardebater(starDebater);
        video.setUploaderid(uploaderId);
        video.setUploader(uploader);
        video.setAddress(address);
        return this.videoDao.insert(video) > 0;

    }

    /**
     * 分页查询所有视频
     *
     * @param page 页码
     * @param size 每页数量
     * @return 对象列表
     */
    @Override
    public List<Video> queryAll(int page, int size) {
        //pageName——页码取值;pageSize——每页显示条数
        PageHelper.startPage(page,size);
        return this.videoDao.queryAll();
    }
}