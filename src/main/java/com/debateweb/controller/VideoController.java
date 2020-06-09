package com.debateweb.controller;

import com.debateweb.entity.User;
import com.debateweb.entity.Video;
import com.debateweb.service.VideoService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

/**
 * (Video)表控制层
 *
 * @author makejava
 * @since 2020-03-30 23:51:00
 */
@Controller
@RequestMapping("/video")
public class VideoController {
    /**
     * 服务对象
     */
    @Resource
    private VideoService videoService;

    /**
     * 按照关键字查找视频
     *
     * @param keyword 关键字
     * @return mv
     */
    @PostMapping("/search")
    public ModelAndView queryByKeyword(@RequestParam String keyword) {
        ModelAndView mv = new ModelAndView();
        List<Video> videos = videoService.queryByKeyword(keyword);
        mv.addObject("videoList", videos);
        mv.setViewName("front/videoPages/video-list");
        return mv;
    }

    /**
     * 上传视频
     *
     * @param video         视频文件
     * @param debateSubject 辩题
     * @param raceName      赛事名
     * @param pros          正方
     * @param cons          反方
     * @param starDebater   明星辩手
     * @return 成功或失败页面
     */
    @PostMapping("/upload")
    public String draftUpload(HttpServletRequest request, MultipartFile video, @RequestParam String debateSubject, @RequestParam String raceName, @RequestParam String pros, @RequestParam String cons, @RequestParam String starDebater) throws Exception {
        System.out.println("正在进行springMVC文件上传");
        //使用fileupload组件完成文件上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/videos/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建该文件夹
            file.mkdirs();
        }
        //说明上传文件项
        //获取上传文件的名称
        String filename = video.getOriginalFilename();
        //把文件名称设置唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        //完成文件上传
        video.transferTo(new File(path, filename));
        //获取当前登录用户的信息
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        String uploader = user.getNickname();
        Integer uploaderId = user.getId();
        String address = "../../../videos/" + filename;
        if (videoService.upload(debateSubject, raceName, pros, cons, starDebater, uploaderId, uploader, address)) {
            return "SorF/success";
        }
        return "SorF/fail";
    }

    /**
     * 分页查询所有视频
     *
     * @param page 页码数
     * @param size 每页大小
     * @return 视频列表页面
     */
    @RequestMapping("findAll")
    public String findAll(Map<String, Object> map, @RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "5") int size) {
        //调用videoInfo方法分页得到视频数据
        map.put("pageInfo", this.videoInfo(page, size));
        return "back/videoPages/video-list";
    }

    /**
     * 跳转到播放页面
     *
     * @param vid 视频id
     * @return 播放视频页面
     */
    @RequestMapping("play")
    public String play(Map<String, Object> map, @RequestParam(name = "vid", required = true) Integer vid) {
        //根据id查询视频
        Video video = videoService.queryById(vid);
        //添加播放次数
        this.videoService.addPlaytimes(video);
        map.put("video", video);
        return "front/videoPages/video-play";
    }

    /**
     * 根据id查询视频进行修改
     *
     * @param vid 视频id
     * @return 修改页面
     */
    @RequestMapping("revise")
    public String revise(Map<String, Object> map, @RequestParam(name = "vid", required = true, defaultValue = "1") int vid) {
        Video video = videoService.queryById(vid);
        map.put("video", video);

        return "back/videoPages/video-revise";
    }

    /**
     * 删除相关数据
     *
     * @param vid 视频id
     * @return 视频列表
     */
    @RequestMapping("delete")
    public String deleteById(Map<String, Object> map, @RequestParam(name = "vid", required = true, defaultValue = "1") int vid) {
        //根据id删除视频数据
        this.videoService.deleteById(vid);

        //加载数据重新跳转到视频列表页面
        map.put("pageInfo", this.videoInfo(1, 5));
        
        return "back/videoPages/video-list";
    }

    /**
     * 更新视频数据
     *
     * @param vid           视频id
     * @param debateSubject 辩题
     * @param raceName      赛事名
     * @param pros          正方
     * @param cons          反方
     * @param starDebater   明星辩手
     * @return 成功或失败页面
     */
    @RequestMapping("update")
    public String update(@RequestParam int vid,
                         @RequestParam String debateSubject,
                         @RequestParam String raceName,
                         @RequestParam String pros,
                         @RequestParam String cons,
                         @RequestParam String starDebater) {
        Video video = new Video();
        video.setVid(vid);
        video.setDebatesubject(debateSubject);
        video.setRacename(raceName);
        video.setPros(pros);
        video.setCons(cons);
        video.setStardebater(starDebater);
        if (this.videoService.update(video)) {
            return "SorF/videoUpdate-success";
        }
        return "SorF/Update-fail";
    }

    /**
     * 得到视频分页数据
     *
     * @param page 页码
     * @param size 每页大小
     * @return 分页Bean
     */
    public PageInfo videoInfo(int page, int size) {
        //获取视频数据并进行分页处理
        List<Video> videos = videoService.queryAll(page, size);
        //PageInfo 为一个分页Bean
        return new PageInfo(videos);
    }

}