package com.baizhi.cmfv.service.impl;

import com.baizhi.cmfv.bean.Slideshow;
import com.baizhi.cmfv.dao.SlideshowMapper;
import com.baizhi.cmfv.service.SlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SlideshowServiceImpl
 * @Description 类的作用
 * @Author Chao
 * @Date 2018/7/5 17:34
 */
@Service
@Transactional
public class SlideshowServiceImpl implements SlideshowService {

    @Autowired
    private SlideshowMapper slideshowMapper;

    @Override
    public void add(Slideshow slideshow) {
        slideshowMapper.insert(slideshow);
    }
    /**
    * @Description  方法的作用
    * @Author       chao
    * @Date         2018/7/6 11:21
    * @Param        参数的作用
    */
    @Override
    public void removeById(String id) {
        slideshowMapper.delete(id);
    }

    /**
    * @Description  方法的作用
    * @Author       chao
    * @Date         2018/7/6 11:21 
    * @Param        参数的作用
    */
    @Override
    public void modify(Slideshow slideshow) {
        slideshowMapper.update(slideshow);
    }

    @Override
    @Transactional(readOnly = true , propagation = Propagation.SUPPORTS)
    public Map<String , Object> queryPage(int pageIndex, int pageSize){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Slideshow> slideshows = slideshowMapper.selectPage((pageIndex - 1) * pageSize , pageSize);
        int count = slideshowMapper.count();
        map.put("rows", slideshows);
        map.put("total", count);
        return map;
    }
}
