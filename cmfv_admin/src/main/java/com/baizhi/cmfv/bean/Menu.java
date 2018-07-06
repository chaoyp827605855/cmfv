package com.baizhi.cmfv.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Menu
 * @Description 类的作用
 * @Author Chao
 * @Date 2018/7/5 10:21
 */
public class Menu implements Serializable{

    private Integer id;
    private String  menuName;
    private String  menuCode;
    private String  menuIcon;
    private String  menuUrl;
    private Integer menuParentId;
    private List<Menu> lists;

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", menuCode='" + menuCode + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuParentId=" + menuParentId +
                ", lists=" + lists +
                '}';
    }

    public List<Menu> getLists() {
        return lists;
    }

    public void setLists(List<Menu> lists) {
        this.lists = lists;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }
}
