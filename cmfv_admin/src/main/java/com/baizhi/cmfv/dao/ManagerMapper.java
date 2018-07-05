package com.baizhi.cmfv.dao;

import com.baizhi.cmfv.bean.Manager;
import org.apache.ibatis.annotations.Param;

public interface ManagerMapper {
    public Manager selectByName(@Param("mName") String mName);
    public Manager selectManager(@Param("mName") String mName , @Param("mPassword") String mPassword);

    public void insertManager(Manager manager);


}
