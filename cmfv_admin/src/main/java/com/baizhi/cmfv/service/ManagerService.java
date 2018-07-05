package com.baizhi.cmfv.service;


import com.baizhi.cmfv.bean.Manager;

public interface ManagerService {

    public Manager queryByName(String mName);
    public Manager queryByIdAndPwd(String mName , String mPassword , String salt);
    public void addManager(Manager manager);

}
