package com.debateweb.entity;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2020-03-21 17:16:38
 */
public class Admin implements Serializable {
    private static final long serialVersionUID = -88832893670581237L;
    
    private Integer adminid;
    
    private String adminname;
    
    private String adminpassword;


    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminpassword() {
        return adminpassword;
    }

    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword;
    }

}