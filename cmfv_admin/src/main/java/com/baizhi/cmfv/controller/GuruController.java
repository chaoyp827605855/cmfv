package com.baizhi.cmfv.controller;

import com.baizhi.cmfv.bean.Guru;
import com.baizhi.cmfv.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName GuruController
 * @Description 上师的功能实现
 * @Author Chao
 * @Date 2018/7/6 15:10
 */
@Controller
@RequestMapping("/guru")
public class GuruController {

    @Autowired
    private GuruService guruService;

    @RequestMapping("/addOne")
    @ResponseBody
    public void addOne(String religionName , String description , MultipartFile pictureImg , HttpSession session) throws IOException {
        Guru guru = new Guru();
        //UUID 给予Guru 以及文件 id
        String uuid = UUID.randomUUID().toString().replace("-", "");
        if(!pictureImg.isEmpty()) {
            //获取项目的路径
            String realPath = session.getServletContext().getRealPath("/");
            //realPath =  C:\apache-tomcat-7.0.81\webapps\cmfv_admin\
            //截取项目路径  获得和 项目 同级目录下的 upload 目录
            String substr = realPath.substring(0, realPath.lastIndexOf("\\"));
            //substring =  C:\apache-tomcat-7.0.81\webapps\cmfv_admin
            String endPath = substr.substring(0, substr.lastIndexOf("\\")) + "\\upload";

            //获取头像文件名
            String originalFilename = pictureImg.getOriginalFilename();
            //获取头像文件后缀名
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

            String path = endPath + "\\" + uuid + suffix;
            pictureImg.transferTo(new File(path));

            guru.setPicture("upload/" + uuid + suffix);
        }
        guru.setId(uuid);
        guru.setReligionName(religionName);
        guru.setDescription(description);
        guruService.addOne(guru);
    }

    @RequestMapping("/removeById")
    @ResponseBody
    public void removeById(String id){
        guruService.removeById(id);
    }


    @RequestMapping("/modify")
    @ResponseBody
    public void modify(Guru guru , MultipartFile pictureImg , HttpSession session) throws IOException {
        if(!pictureImg.isEmpty()) {
            //获取项目的路径
            String realPath = session.getServletContext().getRealPath("/");
            //realPath =  C:\apache-tomcat-7.0.81\webapps\cmfv_admin\

            //截取项目路径  获得和 项目 同级目录下的 upload 目录
            String substr = realPath.substring(0, realPath.lastIndexOf("\\"));
            //substring =  C:\apache-tomcat-7.0.81\webapps\cmfv_admin

            String endPath = substr.substring(0, substr.lastIndexOf("\\"))+"\\upload";

            //UUID 给予Guru 以及文件 id
            String uuid = UUID.randomUUID().toString().replace("-", "");

            //获取头像文件名
            String originalFilename = pictureImg.getOriginalFilename();
            //获取头像文件后缀名
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

            String path = endPath + "\\" + uuid + suffix;
            pictureImg.transferTo(new File(path));

            guru.setPicture("upload/"+uuid+suffix);
        }
        guruService.modify(guru);
    }

    @RequestMapping("/showGuruPage")
    @ResponseBody
    public Map<String , Object> showGuruPage(int page , int rows , String key , String value) {
        return guruService.queryByPage(page,rows,key,value);
    }

    @RequestMapping(value="/ajaxUpload")
    @ResponseBody
    public String ajaxUploadExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {
        return guruService.ajaxUploadExcel(request, response);
    }



}
