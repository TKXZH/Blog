package com.xv.dto;

import com.xv.entity.Article;
import com.xv.entity.Category;
import com.xv.entity.User;

import java.util.List;

/**
 * Created by xvzh on 2017/1/9.
 */
public class ArticleAuthorCategoriesDto {
    private Article article;
    private User user;
    private Category category;
    List<Category> authorCategories;

    public ArticleAuthorCategoriesDto(Article article, User user, Category category, List<Category> authorCategories) {
        this.article = article;
        this.user = user;
        this.category = category;
        this.authorCategories = authorCategories;
    }
    public List<Category> getAuthorCategories() {
        return authorCategories;
    }

    public void setAuthorCategories(List<Category> authorCategories) {
        this.authorCategories = authorCategories;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
