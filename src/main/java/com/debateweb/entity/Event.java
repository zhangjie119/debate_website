package com.debateweb.entity;

import java.io.Serializable;

/**
 * (Event)实体类
 *
 * @author makejava
 * @since 2020-04-28 22:48:56
 */
public class Event implements Serializable {
    private static final long serialVersionUID = -26761916808505036L;
    /**
    * 赛事id
    */
    private Integer id;
    /**
    * 赛事名称
    */
    private String eventname;
    /**
    * 赛事简介
    */
    private String eventinfo;
    /**
    * 赛制
    */
    private String eventformat;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getEventinfo() {
        return eventinfo;
    }

    public void setEventinfo(String eventinfo) {
        this.eventinfo = eventinfo;
    }

    public String getEventformat() {
        return eventformat;
    }

    public void setEventformat(String eventformat) {
        this.eventformat = eventformat;
    }

}