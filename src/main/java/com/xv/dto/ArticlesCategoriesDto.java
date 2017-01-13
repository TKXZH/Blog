package com.xv.dto;

import com.xv.entity.Article;
import com.xv.entity.Category;
import com.xv.entity.User;

import java.util.List;

/**
 * Created by xvzh on 2017/1/10.
 */
public class ArticlesCategoriesDto {
    private User user;
    private List<Category>categories;

    public ArticlesCategoriesDto(User user, List<Category> categories) {
        this.user = user;
        this.categories = categories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
