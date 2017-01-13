package com.xv.dto;

import com.xv.entity.Article;
import com.xv.entity.Category;
import com.xv.entity.User;

import java.util.List;

/**
 * Created by xvzh on 2017/1/10.
 */
public class AuthorCategoryDto {

    private Category category;
    private User author;
    private List<Category> categories;

    public AuthorCategoryDto(Category category, User author, List<Category> categories) {
        this.category = category;
        this.author = author;
        this.categories = categories;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        author = author;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
