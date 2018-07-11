package com.baizhi.cmfv.service;

import com.baizhi.cmfv.bean.Article;

import java.util.List;

public interface ArticleService {
    public void addArticle(Article article);

    public List<Article> queryAll();
}
