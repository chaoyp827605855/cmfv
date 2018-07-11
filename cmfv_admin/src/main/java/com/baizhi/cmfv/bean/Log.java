package com.baizhi.cmfv.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Log
 * @Description 类的作用
 * @Author Chao
 * @Date 2018/7/9 20:21
 */
public class Log implements Serializable{

    private String id;
    private String user;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date time;
    private String resource;
    private String operation;
    private String message;
    private String  result;

    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                ", time=" + time +
                ", resource='" + resource + '\'' +
                ", operation='" + operation + '\'' +
                ", message='" + message + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
