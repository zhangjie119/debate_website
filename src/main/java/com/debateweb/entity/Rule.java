package com.debateweb.entity;

import java.io.Serializable;

/**
 * (Rule)实体类
 *
 * @author makejava
 * @since 2020-05-10 22:37:30
 */
public class Rule implements Serializable {
    private static final long serialVersionUID = -72051135445739881L;
    /**
    * 赛制id
    */
    private Integer id;
    /**
    * 环节名
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