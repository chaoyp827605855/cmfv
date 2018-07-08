package com.baizhi.cmfv.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.cmfv.bean.Guru;
import com.baizhi.cmfv.service.GuruService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
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


    /**
     * @Description  运用easyPOI 实现 excel表格中的数据批量插入
     * @Author       chao
     * @Date         2018/7/8 17:50
     * @Param        参数的作用
     */
    @RequestMapping("/improtExcel")
    @ResponseBody
    public void improtExcel(MultipartFile upfile){
        // 参数一：输入流
        // 参数二：pojo
        // 参数三：导入参数对象
        try {
            ImportParams importParams = new ImportParams();
            List<Guru> gurus = ExcelImportUtil.importExcel(upfile.getInputStream(), Guru.class, importParams);
            //将表格的中数据id 变更为UUID
            for (Guru guru : gurus) {
                guru.setId(UUID.randomUUID().toString().replace("-",""));
            }
            guruService.addGurus(gurus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 注意事项：下载文件的时候不能使用异步请求 ajax
     *
     * dataType:json
     *          xml
     *          不支持stream类型
     *
     * @param resp
     * @throws IOException
     */
    @RequestMapping("/exportExcel")
    public void exportExcel(HttpServletResponse resp) throws IOException {
        List<Guru> gurus = guruService.queryAll();
        // Excel文件
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("c118", "上师信息表"), Guru.class, gurus);
        ServletOutputStream out = resp.getOutputStream();
        // 文件下载 设置响应头
        // 注意：响应头 默认使用的编码格式iso-8859-1

        String fileName = new String("上师信息.xls".getBytes(), "iso-8859-1");

        resp.setContentType("application/vnd.ms-excel"); //响应类型  text/html  application/json
        resp.setHeader("content-disposition","attachment;fileName="+fileName);
        // 导出 文件下载的方式
        workbook.write(out);
        out.close();
    }



    /**
     * @Description  运用POI 实现 excel表格中的数据批量插入
     * @Author       chao
     * @Date         2018/7/8 17:50
     * @Param        参数的作用
     */
    @RequestMapping(value="/ajaxUpload")
    @ResponseBody
    public String ajaxUploadExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {
        return guruService.ajaxUploadExcel(request, response);
    }



}
