package com.xv.service.impl;

import com.xv.Exception.ArticleRelatedException;
import com.xv.dao.ArticleDao;
import com.xv.dao.UserDao;
import com.xv.entity.Article;
import com.xv.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xvzh on 2016/12/28.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleDao articleDao;

    @Autowired
    UserDao userDao;

    @Transactional
    public void createArticle(Article article) {
        try {
            userDao.increaseArticleNum(article.getUid());
            articleDao.createArticle(article);
        } catch (Exception e) {
            throw new ArticleRelatedException("文章表数据插入出错");
        }
    }

    @Transactional
    public void star(long id) {
        long uid = articleDao.queryById(id).getUid();
        int res1 = articleDao.star(id);
        int res2 = userDao.increaseStarNum(uid);
        if(res1 == 0 || res2 == 0) {
            throw new ArticleRelatedException("错误");
        }
    }

    public void delete(long id, long uid) {
        int res = articleDao.delete(id, uid);
        if(res == 0) {
            throw new ArticleRelatedException("无此文章或非作者删除");
        }
    }

    public List<Article> getAllArticles(long uid) {
        return articleDao.queryAllByUid(uid);

    }

    public void modifyArticle(Article article) {
        int res;
        try {
            res = articleDao.modifyArticle(article);
        } catch (Exception e) {
            throw new ArticleRelatedException("文章内容不能为空");
        }
        if(res == 0) {
            throw new ArticleRelatedException("无此文章或非作者修改");
        }


    }

    public Article getArticleById(long id) {
        Article article = articleDao.queryById(id);
        if(article == null) {
            throw new ArticleRelatedException("此文章不存在");
        }
        return article;
    }

    public List<Article> getArticlesByCategoryId(long categoryId) {
        return articleDao.queryByCategoryId(categoryId);
    }
}
