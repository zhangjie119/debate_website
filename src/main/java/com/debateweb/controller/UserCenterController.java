package com.debateweb.controller;

import com.debateweb.entity.Article;
import com.debateweb.entity.Draft;
import com.debateweb.entity.User;
import com.debateweb.entity.Video;
import com.debateweb.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("userCenter")
public class UserCenterController {

    /**
     * 服务对象
     */
    //用户服务
    @Resource
    private UserService userService;

    //视频服务
    @Resource
    private VideoService videoService;

    //辩论稿服务
    @Resource
    private DraftService draftService;

    //论坛帖子服务
    @Resource
    private ArticleService articleService;

    //帖子评论服务
    @Resource
    private CommentService commentService;

    //加载用户信息
    @RequestMapping("main")
    public String userCenter(HttpSession session, Map<String, Object> map) {
        //获取当前登录的用户的id
        User user = (User) session.getAttribute("loginUser");
        Integer uid = user.getId();
        //从数据库获取登录用户的最新信息
        //user = userService.queryById(uid);

        //获取该用户上传的视频列表
        List<Video> videoList = videoService.queryByUid(uid);
        //统计该用户上传的视频数量
        user.setUploadvideonum(videoList.size());
        map.put("videoList", videoList);

        //获取该用户上传的稿件列表
        List<Draft> draftList = draftService.queryByUid(uid);
        //统计该用户上传的稿件数量
        user.setUploaddraftnum(draftList.size());
        map.put("draftList", draftList);

        //获取该用户发表的帖子列表
        List<Article> articleList = articleService.queryByUid(uid);
        //统计该用户发表的帖子数量
        user.setUploadarticlenum(articleList.size());
        map.put("articleList", articleList);

        //更新session中的登陆用户
        //session.setAttribute("loginUser", user);

        return "front/userCenterPages/user-center";
    }

    //跳向修改界面
    @RequestMapping("videoRevise")
    public String videoRevise(Map<String, Object> map, @RequestParam(name = "vid", required = true) Integer vid) {
        Video video = videoService.queryById(vid);
        map.put("video", video);
        return "front/videoPages/video-revise";
    }

    //执行视频修改
    @RequestMapping("videoUpdate")
    public String videoUpdate(@RequestParam int vid,
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
            return "SorF/centerUpdate-success";
        }
        return "SorF/Update-fail";
    }

    //删除视频
    @RequestMapping("videoDelete")
    public String videoDelete(HttpSession session, Map<String, Object> map, @RequestParam(name = "vid", required = true) Integer vid) {
        this.videoService.deleteById(vid);
        map.put("videoList", this.videoService.queryByUid(getUserId(session)));
        return "front/userCenterPages/userCenter-video";
    }

    //修改稿件
    @RequestMapping("draftRevise")
    public String draftRevise(Map<String, Object> map, @RequestParam(name = "did", required = true) Integer did) {
        Draft draft = draftService.queryById(did);
        map.put("draft", draft);
        return "front/draftPages/draft-revise";
    }

    //更新稿件
    @RequestMapping("draftUpdate")
    public String update(@RequestParam Integer did,
                         @RequestParam String draftName,
                         @RequestParam String draftSchool,
                         @RequestParam String draftType) {
        Draft draft = new Draft();
        draft.setDid(did);
        draft.setDraftname(draftName);
        draft.setDraftschool(draftSchool);
        draft.setDrafttype(draftType);
        if (this.draftService.update(draft)) {
            return "SorF/centerUpdate-success";
        }
        return "SorF/Update-fail";
    }

    //删除稿件
    @RequestMapping("draftDelete")
    public String draftDelete(HttpSession session, Map<String, Object> map, @RequestParam(name = "did", required = true) Integer did) {
        this.draftService.deleteById(did);
        map.put("draftList", this.draftService.queryByUid(getUserId(session)));
        return "front/userCenterPages/userCenter-draft";
    }

    //删除稿件
    @RequestMapping("articleDelete")
    public String articleDelete(HttpSession session, Map<String, Object> map, @RequestParam(name = "fid", required = true) Integer fid) {
        //根据id删除帖子
        this.articleService.deleteById(fid);
        //根据帖子id删除回复
        this.commentService.deleteByFid(fid);
        
        //获得新的帖子列表
        map.put("articleList", this.articleService.queryByUid(getUserId(session)));
        return "front/userCenterPages/userCenter-article";
    }

    //修改用户详细信息
    @RequestMapping("informationRevise")
    public String informationRevise() {
        //跳转修改页面，数据从session获取
        return "front/userCenterPages/userCenter-setting";
    }

    //返回个人信息界面，作放弃修改之用
    @RequestMapping("information")
    public String informatione(){
        return "front/userCenterPages/userCenter-information";
    }

    //更新个人信息
    @RequestMapping("informationUpdate")
    public String informationeUpdate(HttpSession session,
                               @RequestParam String nickName,
                               @RequestParam String sex,
                               @RequestParam String phoneNum,
                               @RequestParam String email,
                               @RequestParam String birthday,
                               @RequestParam String notes,
                               @RequestParam String address) {

        User user = new User(getUserId(session), nickName, sex, phoneNum, email, birthday, notes, address);
        user = this.userService.update(user);
        session.setAttribute("loginUser", user);
        return "SorF/centerUpdate-success";
    }

    public Integer getUserId(HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        return user.getId();
    }

}
