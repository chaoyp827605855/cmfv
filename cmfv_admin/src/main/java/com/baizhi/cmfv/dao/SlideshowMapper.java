package com.baizhi.cmfv.dao;

import com.baizhi.cmfv.bean.Slideshow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlideshowMapper {

    public List<Slideshow> selectPage(@Param("begin") int begin , @Param("end") int end);

    public int count();

    public void insert(Slideshow sildeshow);

    public void update(Slideshow slideshow);

    public void delete(String id);

}
