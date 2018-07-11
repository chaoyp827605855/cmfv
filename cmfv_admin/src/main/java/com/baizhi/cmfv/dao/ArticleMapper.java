package com.baizhi.cmfv.dao;

import com.baizhi.cmfv.bean.Article;

import java.util.List;

public interface ArticleMapper {
    public void insert(Article article);


    public List<Article> selectAll();

}
