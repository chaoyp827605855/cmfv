package com.baizhi.cmfv.dao;

import com.baizhi.cmfv.bean.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuruMapper {

    public void insertOne(Guru guru);

    public void deleteById(String id);

    public void update(Guru guru);

    public List<Guru> selectByPage(@Param("begin") int begin , @Param("end") int end , @Param("key") String key , @Param("value") String value);

    public int count(@Param("key") String key , @Param("value") String value);

    int insert(Guru guru);

    Guru selectByPrimaryKey(String id);

    int updateByPrimaryKey(Guru guru);
}
