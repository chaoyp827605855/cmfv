package com.baizhi.cmfv.bean;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Chao on 2018/7/3.
 */
public class Slideshow{

    private String id;
    private String path;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date date;
    private String description;
    private String status;

    @Override
    public String toString() {
        return "Slideshow{" +
                "id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
