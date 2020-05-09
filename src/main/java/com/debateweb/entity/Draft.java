package com.debateweb.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Draft)实体类
 *
 * @author makejava
 * @since 2020-03-26 15:29:23
 */
public class Draft implements Serializable {
    private static final long serialVersionUID = -92813309681166802L;
    
    private Integer did;
    
    private String draftname;
    
    private String draftschool;
    
    private String drafttype;

    private Integer uploaderid;
    
    private String uploder;
    
    private String address;
    
    private Integer downtimes;
    
    private String uploadtime;


    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDraftname() {
        return draftname;
    }

    public void setDraftname(String draftname) {
        this.draftname = draftname;
    }

    public String getDraftschool() {
        return draftschool;
    }

    public void setDraftschool(String draftschool) {
        this.draftschool = draftschool;
    }

    public String getDrafttype() {
        return drafttype;
    }

    public void setDrafttype(String drafttype) {
        this.drafttype = drafttype;
    }

    public Integer getUploaderid() {
        return uploaderid;
    }

    public void setUploaderid(Integer uploaderid) {
        this.uploaderid = uploaderid;
    }

    public String getUploder() {
        return uploder;
    }

    public void setUploder(String uploder) {
        this.uploder = uploder;
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
        this.uploadtime = uploadtime.substring(0,uploadtime.length()-3);;
    }

}