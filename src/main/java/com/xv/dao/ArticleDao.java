package com.xv.dao;

import com.xv.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xvzh on 2016/12/27.
 */
public interface ArticleDao {
    int createArticle(Article article);
    int star(long id);
    int delete(@Param("id") long id, @Param("uid") long uid);
    int modifyArticle(Article article);
    List<Article> queryAllByUid(long uid);
    Article queryById(long id);
    List<Article> queryByCategoryId(long categoryId);
}
