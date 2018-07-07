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
 * @Description 轮播图的增删改查
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
    * @Description  删除轮播图
    * @Author       chao
    * @Date         2018/7/6 11:21
    * @Param        id(删除条件)
    */
    @Override
    public void removeById(String id) {
        slideshowMapper.delete(id);
    }

    /**
    * @Description  修改轮播图信息
    * @Author       chao
    * @Date         2018/7/6 11:21 
    * @Param        slideshow(存储要修改的信息)
    */
    @Override
    public void modify(Slideshow slideshow) {
        slideshowMapper.update(slideshow);
    }

    /**
     * @Description  对轮播图进行分页查询
     * @Author       chao
     * @Date         2018/7/6 11:21
     * @Param        pageIndex(当前页码) ， pageSize(每页显示的数据条数)
     */
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
