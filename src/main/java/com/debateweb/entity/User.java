package com.debateweb.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-03-21 17:16:49
 */
public class User implements Serializable {
    private static final long serialVersionUID = -31056056831074699L;
    
    private Integer id;
    
    private String username;
    
    private String password;

    private String nickname;
    
    private String sex;
    
    private String phonenum;
    
    private String email;
    
    private Object birthday;
    //简介
    private String notes;
    //住址
    private String address;
    
    private String regdate;

    private boolean isadmin;

    private Integer headpicture;
    //上传电影数量
    private Integer uploadvideonum;
    //上传稿件数量
    private Integer uploaddraftnum;
    //发布帖子数量
    private Integer uploadarticlenum;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getBirthday() {
        return birthday;
    }

    public void setBirthday(Object birthday) {
        this.birthday = birthday;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate.substring(0,regdate.length()-3);
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public boolean isIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    public Integer getHeadpicture() {
        return headpicture;
    }

    public void setHeadpicture(Integer headpicture) {
        this.headpicture = headpicture;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUploadvideonum() {
        return uploadvideonum;
    }

    public void setUploadvideonum(Integer uploadvideonum) {
        this.uploadvideonum = uploadvideonum;
    }

    public Integer getUploaddraftnum() {
        return uploaddraftnum;
    }

    public void setUploaddraftnum(Integer uploaddraftnum) {
        this.uploaddraftnum = uploaddraftnum;
    }

    public Integer getUploadarticlenum() {
        return uploadarticlenum;
    }

    public void setUploadarticlenum(Integer uploadarticlenum) {
        this.uploadarticlenum = uploadarticlenum;
    }

    public User() {
    }

    public User(Integer id, String nickname, String sex, String phonenum, String email, Object birthday, String notes, String address) {
        this.id = id;
        this.nickname = nickname;
        this.sex = sex;
        this.phonenum = phonenum;
        this.email = email;
        this.birthday = birthday;
        this.notes = notes;
        this.address = address;
    }
}