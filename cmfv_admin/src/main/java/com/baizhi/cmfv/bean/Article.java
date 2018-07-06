package com.baizhi.cmfv.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Chao on 2018/7/3.
 */
public class Article implements Serializable {

    private String  id;
    private String  name;
    private String  introduce;
    private Date    date;
    private String  picture;
    private String  gid;

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", date=" + date +
                ", picture='" + picture + '\'' +
                ", gid='" + gid + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }
}
