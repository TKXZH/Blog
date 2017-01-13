package com.xv.dao;

import com.xv.entity.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by xvzh on 2016/12/27.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ArticleDaoTest {
    @Autowired
    ArticleDao articleDao;
    @Test
    public void queryById() throws Exception {
        Article article = articleDao.queryById(1L);
        System.out.println(article);
    }

    @Test
    public void createArticle() throws Exception {
        Article article = new Article(1010L,1L,"你好呀，这是第一篇博客文章测试");
        System.out.println(articleDao.createArticle(article));
    }

    @Test
    public void star() throws Exception {
        System.out.println(articleDao.star(7777L));
    }

    @Test
    public void delete() throws Exception {
        System.out.println(articleDao.delete(1L,2222L));
    }

}