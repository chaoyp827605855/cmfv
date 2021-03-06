package com.baizhi.cmfv.dao;

import com.baizhi.cmfv.bean.Manager;
import org.apache.ibatis.annotations.Param;

public interface ManagerMapper {
    public Manager selectById(@Param("id") String id);
    public Manager selectByName(@Param("name") String name);
    public Manager selectManager(@Param("name") String name , @Param("password") String password);

    public void insertManager(Manager manager);

    public Boolean update(Manager manager);

}
