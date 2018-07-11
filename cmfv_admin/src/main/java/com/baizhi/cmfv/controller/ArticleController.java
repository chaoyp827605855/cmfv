package com.baizhi.cmfv.controller;

import com.baizhi.cmfv.bean.Article;
import com.baizhi.cmfv.bean.Guru;
import com.baizhi.cmfv.bean.RichTextResult;
import com.baizhi.cmfv.service.ArticleService;
import com.baizhi.cmfv.service.GuruService;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName ArticleController
 * @Description 类的作用
 * @Author Chao
 * @Date 2018/7/8 20:10
 */
@RequestMapping("/article")
@Controller
public class ArticleController {

    @Autowired
    private GuruService guruService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/upload")
    @ResponseBody
    public RichTextResult uploadFiles(@RequestParam("files") MultipartFile[] files , HttpSession session , HttpServletRequest request){    //MultipartFile[] 代表多文件长传

        RichTextResult richTextResult = new RichTextResult();
        List<String> list = new ArrayList<String>();
        String realPath = session.getServletContext().getRealPath("\\");
        System.out.println("-------------------"+realPath);
        String subPath = realPath.substring(0, realPath.lastIndexOf("\\"));
        System.out.println("-------------------"+subPath);
        String endPath = subPath.substring(0, subPath.lastIndexOf("\\")) + "\\upload";
        System.out.println("-------------------"+endPath);

        try {
            if(files != null && files.length != 0) {
                for (MultipartFile file : files) {
                    String fileName = UUID.randomUUID().toString().replace("-", "") + "." + FilenameUtils.getExtension(file.getOriginalFilename());
                    file.transferTo(new File(endPath + "\\" + fileName));
                    list.add(request.getContextPath()+ "/upload/" + fileName);
                }
                richTextResult.setErrno(0);
                richTextResult.setData(list);
            }
        } catch (IOException e) {
            richTextResult.setErrno(1);
        }
        return richTextResult;
    }


    @RequestMapping("/queryAllGuru")
    @ResponseBody
    public List<Guru> queryAllGuru() {
        return guruService.queryAll();
    }

    @RequestMapping("/addArticle")
    @ResponseBody
    public void addArticle(Article article , @Param("guruId") String guruId){
        Guru guru = new Guru();
        article.setId(UUID.randomUUID().toString().replace("-",""));
        article.setDate(new Date());
        guru.setId(guruId);
        article.setGuru(guru);
        articleService.addArticle(article);
    }


    @RequestMapping("/queryAllArticle")
    @ResponseBody
    public List<Article> queryAll() {
        return articleService.queryAll();
    }

}
