package com.baizhi.cmfv.service.impl;

import com.baizhi.cmfv.bean.Manager;
import com.baizhi.cmfv.dao.ManagerMapper;
import com.baizhi.cmfv.service.ManagerService;
import com.baizhi.cmfv.util.Md5Token;
import com.baizhi.cmfv.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

/**
 * @ClassName ManagerServiceImpl
 * @Description 管理员的功能
 * @Author Chao
 * @Date 2018/7/4 14:18
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    @Transactional(readOnly = true , propagation = Propagation.SUPPORTS)
    public Manager queryById(String id) {
        return managerMapper.selectById(id);
    }

    /**
    * @Description  根据用户名查询用户
    * @Author       chao
    * @Date         2018/7/4 19:07
    * @Param        参数的作用
    */
    @Override
    @Transactional(readOnly = true , propagation = Propagation.SUPPORTS)
    public Manager queryByName(String name) {
        return managerMapper.selectByName(name);
    }

    /**
    * @Description  登录
    * @Author       chao
    * @Date         2018/7/4 19:08
    * @Param        参数的作用
    */
    @Override
    @Transactional(readOnly = true , propagation = Propagation.SUPPORTS)
    public Manager queryByIdAndPwd(String name, String password , String salt) {
        password = Md5Token.getInstance().getLongLongToken(password + salt);
        return managerMapper.selectManager(name , password);
    }

    /**
    * @Description  添加Manager
    * @Author       chao
    * @Date         2018/7/4 19:08
    * @Param        参数的作用
    */
    @Override
    public void addManager(Manager manager) {
        managerMapper.insertManager(manager);
    }

    /**
    * @Description  修改管理员信息
    * @Author       chao
    * @Date         2018/7/8 10:51
    * @Param        存储要修改的信息
    */
    @Override
    public boolean modify(Manager manager) {
        String salt = RandomUtils.randomSalt(6);
        String password = Md5Token.getInstance().getLongLongToken(manager.getPassword() + salt);
        manager.setPassword(password);
        return managerMapper.update(manager);
    }
}
