package com.baizhi.cmfv.service;

import com.baizhi.cmfv.bean.Slideshow;

import java.util.List;
import java.util.Map;

public interface SlideshowService {

    public Map<String , Object> queryPage(int page , int rows);

    public void add(Slideshow slideshow);

    public void modify(Slideshow slideshow);

    public void removeById(String id);
}
