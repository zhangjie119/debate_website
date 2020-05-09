package com.debateweb.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 评论表(Comment)实体类
 *
 * @author makejava
 * @since 2020-04-04 16:25:50
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = -75039523916040651L;
    /**
    * 评论id
    */
    private Integer pid;
    /**
    * 评论内容
    */
    private String pcontent;
    /**
    * 评论者id
    */
    private Integer userid;
    /**
     * 评论者姓名
     */
    private String username;
    /**
    * 被评论帖子id
    */
    private Integer fid;
    /**
    * 评论时间
    */
    private String time;


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time.substring(0, time.length()-3);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}