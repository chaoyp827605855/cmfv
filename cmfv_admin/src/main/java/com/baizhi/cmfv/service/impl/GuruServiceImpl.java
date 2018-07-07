package com.baizhi.cmfv.service.impl;

import com.baizhi.cmfv.bean.Guru;
import com.baizhi.cmfv.dao.GuruMapper;
import com.baizhi.cmfv.service.GuruService;
import com.baizhi.cmfv.util.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GuruServiceImpl
 * @Description 对上师的增删改查
 * @Author Chao
 * @Date 2018/7/6 15:07
 */
@Service
@Transactional
public class GuruServiceImpl implements GuruService {

    @Autowired
    private GuruMapper guruMapper;

    /**
    * @Description  添加上师
    * @Author       chao
    * @Date         2018/7/6 15:07
    * @Param        参数的作用
    */
    @Override
    public void addOne(Guru guru) {
        guruMapper.insertOne(guru);
    }
    /**
    * @Description  删除上师
    * @Author       chao
    * @Date         2018/7/6 15:08
    * @Param        id(删除上师的依据)
    */
    @Override
    public void removeById(String id) {
        guruMapper.deleteById(id);
    }

    /**
    * @Description  对上师的修改
    * @Author       chao
    * @Date         2018/7/6 15:08
    * @Param        guru 存储修改的对象信息
    */
    @Override
    public void modify(Guru guru) {
        guruMapper.update(guru);
    }
    
    /**
    * @Description  对上师的分页 + 模糊查询
    * @Author       chao
    * @Date         2018/7/6 15:08
    * @Param        page（当前的页码） ，rows（每页显示的数据条数），key(模糊查询的条件) ，value(模糊查询的值)
    * @Exception    抛出的异常
    */
    @Override
    @Transactional(readOnly = true , propagation = Propagation.SUPPORTS)
    public Map<String , Object> queryByPage(int page, int rows, String key, String value) {
        Map<String, Object> map = new HashMap<>();
        List<Guru> gurus = guruMapper.selectByPage((page - 1) * rows, rows, key, value);
        int count = guruMapper.count(key,value);
        map.put("rows",gurus);
        map.put("total",count);
        return map;
    }

    /**
    * @Description  用于excel表格中的数据批量插入
    * @Author       chao
    * @Date         2018/7/7 19:44
    * @Param        参数的作用
    * @Exception    抛出的异常
    */
    @Override
    public String ajaxUploadExcel(HttpServletRequest request, HttpServletResponse response) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        //获取上传的文件
        MultipartFile file = multipartRequest.getFile("upfile");
        //判断文件是否为null
        if (file.isEmpty()) {
            try {
                throw new Exception("文件不存在！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        InputStream in = null;
        try {
            in = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //用于存储excel中封装的对象
        List<List<Object>> listob = null;
        try {
            //获取IO流中的数据，组装成List<List<Object>>对象
            listob = new ExcelUtils().getBankListByExcel(in, file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
        for (int i = 0; i < listob.size(); i++) {
            List<Object> lo = listob.get(i);
            Guru guru = new Guru();
            Guru j = null;

            System.out.println("-----------  " + i + "  ----------------" + String.valueOf(lo.get(0)) + "\t" +
                    String.valueOf(lo.get(1)) + "\t" + String.valueOf(lo.get(2)) + "\t" + String.valueOf(lo.get(3)));

            try {
                //查询当前行对象是否存在
                j = guruMapper.selectByPrimaryKey(String.valueOf(lo.get(0)));
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                System.out.println("没有新增");
            }
            guru.setId((String.valueOf(lo.get(0))));
            guru.setReligionName(String.valueOf(lo.get(1)));
            guru.setPicture(String.valueOf(lo.get(2)));
            guru.setDescription(String.valueOf(lo.get(3)));
            //如果当前行对象存在，则对数据库中的该对象进行跟新覆盖 ，否则，进行插入
            if (j == null) {
                guruMapper.insert(guru);
            } else {
                guruMapper.updateByPrimaryKey(guru);
            }
        }
        return "文件导入成功！";
    }

}

