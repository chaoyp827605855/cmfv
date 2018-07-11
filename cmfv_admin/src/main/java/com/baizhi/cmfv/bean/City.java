package com.baizhi.cmfv.bean;

import java.io.Serializable;
import java.util.Random;

/**
 * @ClassName City
 * @Description 类的作用
 * @Author Chao
 * @Date 2018/7/9 16:01
 */
public class City implements Serializable{
    private String name;
    private Integer value;

    public City(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
