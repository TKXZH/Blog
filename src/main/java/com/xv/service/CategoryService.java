package com.xv.service;

import com.xv.entity.Category;

import java.util.List;

/**
 * Created by xvzh on 2017/1/9.
 */
public interface CategoryService {
    public void createCategory(long uid, String name);
    public List<Category> getCategoriesByUid(long uid);
    public Category getCategoryById(long id);
}
