package com.baizhi.cmfv.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Chao on 2018/7/3.
 */
public class Manager implements Serializable {

    private String id;
    private String name;
    private String salt;
    private String status;
    private String password;

    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salt='" + salt + '\'' +
                ", status='" + status + '\'' +
                ", password='" + password + '\'' +
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
