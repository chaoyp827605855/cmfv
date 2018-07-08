package com.baizhi.cmfv.service;

import com.baizhi.cmfv.bean.Guru;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface GuruService {

    public void addOne(Guru guru);

    public void removeById(String id);

    public void modify(Guru guru);

    public Map<String , Object> queryByPage(int page , int rows , String key , String value);

    public void addGurus(List<Guru> gurus);

    public List<Guru> queryAll();




    public String ajaxUploadExcel(HttpServletRequest request, HttpServletResponse response);

}
