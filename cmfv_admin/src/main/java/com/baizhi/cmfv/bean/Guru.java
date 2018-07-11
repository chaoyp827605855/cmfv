package com.baizhi.cmfv.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Chao on 2018/7/3.
 */
public class Guru implements Serializable {

    // easypoi  @Excel 指定excel表格中列和属性的映射关系
    @Excel(name="上师编号")
    private String  id;
    @Excel(name="上师法名")
    private String  religionName;   //法名
    @Excel(name="上师头像")
    private String  picture;
    @Excel(name="上师描述")
    private String  description;    //描述

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", religionName='" + religionName + '\'' +
                ", picture='" + picture + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReligionName() {
        return religionName;
    }

    public void setReligionName(String religionName) {
        this.religionName = religionName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
