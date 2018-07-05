package com.baizhi.cmfv.service.impl;

import com.baizhi.cmfv.bean.Manager;
import com.baizhi.cmfv.dao.ManagerMapper;
import com.baizhi.cmfv.service.ManagerService;
import com.baizhi.cmfv.util.Md5Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName ManagerServiceImpl
 * @Description 类的作用
 * @Author Chao
 * @Date 2018/7/4 14:18
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    /**
    * @Description  根据用户名查询用户
    * @Author       chao
    * @Date         2018/7/4 19:07
    * @Param        参数的作用
    * @Exception    抛出的异常
    */
    @Override
    @Transactional(readOnly = true , propagation = Propagation.SUPPORTS)
    public Manager queryByName(String mName) {
        return managerMapper.selectByName(mName);
    }

    /**
    * @Description  登录
    * @Author       chao
    * @Date         2018/7/4 19:08
    * @Param        参数的作用
    * @Exception    抛出的异常
    */
    @Override
    @Transactional(readOnly = true , propagation = Propagation.SUPPORTS)
    public Manager queryByIdAndPwd(String mName, String mPassword , String salt) {
        mPassword = Md5Token.getInstance().getLongLongToken(mPassword + salt);
        return managerMapper.selectManager(mName , mPassword);
    }

    /**
    * @Description  添加Manager
    * @Author       chao
    * @Date         2018/7/4 19:08
    * @Param        参数的作用
    * @Exception    抛出的异常
    */
    @Override
    public void addManager(Manager manager) {
        managerMapper.insertManager(manager);
    }
}
