package com.baizhi.cmfv.service.impl;

import com.baizhi.cmfv.bean.Log;
import com.baizhi.cmfv.dao.LogMapper;
import com.baizhi.cmfv.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName LogServiceImpl
 * @Description 类的作用
 * @Author Chao
 * @Date 2018/7/9 20:29
 */
@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    @Transactional(readOnly = true , propagation = Propagation.SUPPORTS)
    public void addLog(Log log) {
        logMapper.insert(log);
    }
}
