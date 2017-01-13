package com.xv.service;

import com.xv.entity.Article;

import java.util.List;

/**
 * Created by xvzh on 2016/12/28.
 */
public interface ArticleService {
    public void createArticle(Article article);

    public void star(long id);

    public void delete(long id, long uid);

    public void modifyArticle(Article article);

    public List<Article> getAllArticles(long uid);

    public Article getArticleById(long id);

    public List<Article> getArticlesByCategoryId(long categoryId);
}
