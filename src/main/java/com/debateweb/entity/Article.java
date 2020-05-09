package com.debateweb.entity;

import java.io.Serializable;

/**
 * 发帖表(Article)实体类
 *
 * @author makejava
 * @since 2020-04-04 16:25:50
 */
public class Article implements Serializable {
    private static final long serialVersionUID = 582919110523793955L;
    /**
    * 帖子id
    */
    private Integer fid;
    /**
    * 帖子标题
    */
    private String titles;
    /**
    * 帖子内容
    */
    private String fcontent;
    /**
    * 帖子图片
    */
    private String photo;
    /**
    * 所属板块名字
    */
    private String bname;
    /**
    * 发帖时间
    */
    private String time;
    /**
    * 发帖人id
    */
    private Integer userid;
    /**
    * 发帖人姓名
    */
    private String username;
    /**
    * 帖子审核状态(0为待审核，1为通过审核，2为未通过审核，默认为0)
    */
    private Integer status;


    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getFcontent() {
        return fcontent;
    }

    public void setFcontent(String fcontent) {
        this.fcontent = fcontent;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time.substring(0,time.length()-3);
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Article{" +
                "fid=" + fid +
                ", titles='" + titles + '\'' +
                ", fcontent='" + fcontent + '\'' +
                ", photo='" + photo + '\'' +
                ", bname='" + bname + '\'' +
                ", time='" + time + '\'' +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", status=" + status +
                '}';
    }
}