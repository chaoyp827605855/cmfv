package com.baizhi.cmfv.service;


import com.baizhi.cmfv.bean.Manager;

public interface ManagerService {
    public Manager queryById(String id);
    public Manager queryByName(String name);
    public Manager queryByIdAndPwd(String name , String password , String salt);
    public void addManager(Manager manager);

    public boolean modify(Manager manager);

}
