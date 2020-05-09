package com.debateweb.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 板块表(Plate)实体类
 *
 * @author makejava
 * @since 2020-04-04 16:25:50
 */
public class Plate implements Serializable {
    private static final long serialVersionUID = 322209095463736812L;
    /**
    * 板块id
    */
    private Integer bid;
    /**
    * 板块名字
    */
    private String bname;
    /**
    * 板块创建时间
    */
    private String btime;


    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBtime() {
        return btime;
    }

    public void setBtime(String btime) {
        this.btime = btime.substring(0,btime.length()-3);
    }

}