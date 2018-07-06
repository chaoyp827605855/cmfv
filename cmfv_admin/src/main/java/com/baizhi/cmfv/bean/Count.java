package com.baizhi.cmfv.bean;

import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.io.Serializable;

/**
 * Created by Chao on 2018/7/3.
 */
public class Count implements Serializable {

    private String  couId;
    private String  couName;
    private Integer couNum;
    private Data    couDate;
    private String  cid;
    private String  userId;

    @Override
    public String toString() {
        return "Count{" +
                "couId='" + couId + '\'' +
                ", couName='" + couName + '\'' +
                ", couNum=" + couNum +
                ", couDate=" + couDate +
                ", cid='" + cid + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getCouId() {
        return couId;
    }

    public void setCouId(String couId) {
        this.couId = couId;
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    public Integer getCouNum() {
        return couNum;
    }

    public void setCouNum(Integer couNum) {
        this.couNum = couNum;
    }

    public Data getCouDate() {
        return couDate;
    }

    public void setCouDate(Data couDate) {
        this.couDate = couDate;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
