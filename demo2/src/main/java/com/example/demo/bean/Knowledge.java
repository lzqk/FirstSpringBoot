package com.example.demo.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * knowledge
 * @author 
 */
public class Knowledge implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 科目
     */
    private String subject;

    /**
     * 名称
     */
    private String name;

    /**
     * 内容
     */
    private String desc;

    /**
     * 创建时间
     */
    private Date crttime;

    /**
     * 修改时间
     */
    private Date modftime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCrttime() {
        return crttime;
    }

    public void setCrttime(Date crttime) {
        this.crttime = crttime;
    }

    public Date getModftime() {
        return modftime;
    }

    public void setModftime(Date modftime) {
        this.modftime = modftime;
    }
}