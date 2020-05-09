package com.debateweb.entity;

import java.io.Serializable;

/**
 * (Format)实体类
 *
 * @author makejava
 * @since 2020-04-28 22:50:03
 */
public class Format implements Serializable {
    private static final long serialVersionUID = -83502253946266631L;
    /**
    * 赛制id
    */
    private Integer id;
    /**
    * 赛制环节名
    */
    private String linkname;
    /**
    * 环节规则
    */
    private String linkrule;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkname() {
        return linkname;
    }

    public void setLinkname(String linkname) {
        this.linkname = linkname;
    }

    public String getLinkrule() {
        return linkrule;
    }

    public void setLinkrule(String linkrule) {
        this.linkrule = linkrule;
    }

}