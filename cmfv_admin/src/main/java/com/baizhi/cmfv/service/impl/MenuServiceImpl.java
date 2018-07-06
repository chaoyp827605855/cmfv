package com.baizhi.cmfv.service.impl;

import com.baizhi.cmfv.bean.Menu;
import com.baizhi.cmfv.dao.MenuMapper;
import com.baizhi.cmfv.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName MenuServiceImpl
 * @Description 类的作用
 * @Author Chao
 * @Date 2018/7/5 11:06
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    @Transactional(readOnly = true , propagation = Propagation.SUPPORTS)
    public List<Menu> queryAll() {
        return menuMapper.select();
    }

}
