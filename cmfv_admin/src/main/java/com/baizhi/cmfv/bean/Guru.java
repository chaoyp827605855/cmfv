package com.baizhi.cmfv.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Chao on 2018/7/3.
 */
public class Guru implements Serializable {

    private String  gId;
    private String  gReligionName;
    private String  gPicture;
    private String  gDescription;

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public String getgReligionName() {
        return gReligionName;
    }

    public void setgReligionName(String gReligionName) {
        this.gReligionName = gReligionName;
    }

    public String getgPicture() {
        return gPicture;
    }

    public void setgPicture(String gPicture) {
        this.gPicture = gPicture;
    }

    public String getgDescription() {
        return gDescription;
    }

    public void setgDescription(String gDescription) {
        this.gDescription = gDescription;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "gId='" + gId + '\'' +
                ", gReligionName='" + gReligionName + '\'' +
                ", gPicture='" + gPicture + '\'' +
                ", gDescription='" + gDescription + '\'' +
                '}';
    }
}
