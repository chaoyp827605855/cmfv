package com.baizhi.cmfv.controller;

import com.baizhi.cmfv.bean.Slideshow;
import com.baizhi.cmfv.service.SlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName SlideshowController
 * @Description 轮播图的功能实现
 * @Author Chao
 * @Date 2018/7/5 17:36
 */
@Controller
public class SlideshowController {

    @Autowired
    private SlideshowService slideshowService;


    @RequestMapping("/uploadSlideshow")
    @ResponseBody
    public void uploadSlideshow(String description , String status ,  MultipartFile slideshowFile , HttpSession session) throws IOException {
        if(!slideshowFile.isEmpty()) {
            //获得文件夹名称
            String realPath = session.getServletContext().getRealPath("\\");

            System.out.println("------------------" + realPath);
            String newPath = realPath.substring(0, realPath.lastIndexOf("\\"));
            String uploadPath = newPath.substring(0, newPath.lastIndexOf("\\")) + "\\upload";
            System.out.println("------------------" + uploadPath);

            String sId = UUID.randomUUID().toString().replace("-", "");
            //获取文件的名字
            String oldName = slideshowFile.getOriginalFilename();
            //获取文件的后缀名
            String suffix = oldName.substring(oldName.lastIndexOf("."));
            // 转存文件到指定的路径
            String path = uploadPath + "/" + sId + suffix;
            slideshowFile.transferTo(new File(path));

            Slideshow slideshow = new Slideshow();
            slideshow.setId(sId);
            slideshow.setPath("upload" + "/" + sId + suffix);
            slideshow.setDate(new Date());
            slideshow.setDescription(description);
            slideshow.setStatus(status);

            slideshowService.add(slideshow);
        }

    }

    @RequestMapping("/showSlideshowAll")
    @ResponseBody
    public Map<String , Object> showSlideshowAll(int page , int rows){
        return slideshowService.queryPage(page, rows);
    }

    @RequestMapping("/modify")
    @ResponseBody
    public void modify(Slideshow slideshow , MultipartFile slideshowFile , HttpSession session) throws IOException {
        if(!slideshowFile.isEmpty()) {
            //获得文件夹名称
            String realPath = session.getServletContext().getRealPath("\\");

            System.out.println("------------------"+realPath);
            String newPath = realPath.substring(0,realPath.lastIndexOf("\\"));
            String uploadPath = newPath.substring(0,newPath.lastIndexOf("\\"))+"\\upload";
            System.out.println("------------------"+uploadPath);

            String sId = UUID.randomUUID().toString().replace("-","");
            //获取文件的名字
            String oldName = slideshowFile.getOriginalFilename();
            //获取文件的后缀名
            String suffix = oldName.substring(oldName.lastIndexOf("."));
            // 转存文件到指定的路径
            String path = uploadPath+"/"+sId + suffix;
            slideshowFile.transferTo(new File(path));

            slideshow.setPath("upload"+"/"+sId + suffix);
        }
        slideshow.setDate(new Date());
        slideshowService.modify(slideshow);
    }

}
