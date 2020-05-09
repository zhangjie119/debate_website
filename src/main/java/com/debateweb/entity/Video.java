package com.debateweb.entity;

import java.io.Serializable;

/**
 * (Video)实体类
 *
 * @author makejava
 * @since 2020-03-30 23:51:00
 */
public class Video implements Serializable {
    private static final long serialVersionUID = 967653585904547275L;
    
    private Integer vid;
    
    private String debatesubject;
    
    private String racename;
    
    private String pros;
    
    private String cons;
    
    private String stardebater;
    
    private Integer uploaderid;
    
    private String uploader;
    
    private String address;
    
    private Integer downtimes;
    
    private String uploadtime;


    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getDebatesubject() {
        return debatesubject;
    }

    public void setDebatesubject(String debatesubject) {
        this.debatesubject = debatesubject;
    }

    public String getRacename() {
        return racename;
    }

    public void setRacename(String racename) {
        this.racename = racename;
    }

    public String getPros() {
        return pros;
    }

    public void setPros(String pros) {
        this.pros = pros;
    }

    public String getCons() {
        return cons;
    }

    public void setCons(String cons) {
        this.cons = cons;
    }

    public String getStardebater() {
        return stardebater;
    }

    public void setStardebater(String stardebater) {
        this.stardebater = stardebater;
    }

    public Integer getUploaderid() {
        return uploaderid;
    }

    public void setUploaderid(Integer uploaderid) {
        this.uploaderid = uploaderid;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDowntimes() {
        return downtimes;
    }

    public void setDowntimes(Integer downtimes) {
        this.downtimes = downtimes;
    }

    public String getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(String uploadtime) {
        this.uploadtime = uploadtime.substring(0,uploadtime.length()-3);
    }

}