package com.baizhi.cmfv.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Chao on 2018/7/3.
 */
public class Classify implements Serializable {

    private String  id;
    private String  name;
    private String  different;
    private String  userId;

    @Override
    public String toString() {
        return "Classify{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", different='" + different + '\'' +
                ", userId='" + userId + '\'' +
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

    public String getDifferent() {
        return different;
    }

    public void setDifferent(String different) {
        this.different = different;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
