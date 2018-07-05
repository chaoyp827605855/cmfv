package com.baizhi.cmfv.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Chao on 2018/7/3.
 */
public class Slideshow implements Serializable {

    private String sId;
    private String sPath;
    private Date sDate;
    private String sDescription;
    private String sStatus;

    public String getsId() {
        return sId;
    }
    public void setsId(String sId) {
        this.sId = sId;
    }
    public String getsPath() {
        return sPath;
    }
    public void setsPath(String sPath) {
        this.sPath = sPath;
    }
    public Date getsDate() {
        return sDate;
    }
    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }
    public String getsDescription() {
        return sDescription;
    }
    public void setsDescription(String sDescription) {
        this.sDescription = sDescription;
    }
    public String getsStatus() {
        return sStatus;
    }
    public void setsStatus(String sStatus) {
        this.sStatus = sStatus;
    }

    @Override
    public String toString() {
        return "Slideshow{" +
                "sId='" + sId + '\'' +
                ", sPath='" + sPath + '\'' +
                ", sDate='" + sDate + '\'' +
                ", sDescription='" + sDescription + '\'' +
                ", sStatus='" + sStatus + '\'' +
                '}';
    }
}
