package com.baizhi.cmfv.service.impl;

import com.baizhi.cmfv.bean.Article;
import com.baizhi.cmfv.dao.ArticleMapper;
import com.baizhi.cmfv.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName ArticleServiceImpl
 * @Description 类的作用
 * @Author Chao
 * @Date 2018/7/8 21:20
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * @Description  方法的作用
     * @Author       chao
     * @Date         2018/7/8 19:03
     * @Param        参数的作用
     */
    @Override
    public void addArticle(Article article) {
        articleMapper.insert(article);
    }

    /**
    * @Description  方法的作用
    * @Author       chao
    * @Date         2018/7/9 9:03
    * @Param        参数的作用
    */
    @Transactional(readOnly = true ,propagation = Propagation.SUPPORTS)
    public List<Article> queryAll() {
        return articleMapper.selectAll();
    }
}
