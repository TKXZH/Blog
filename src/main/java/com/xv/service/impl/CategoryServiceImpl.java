package com.xv.service.impl;

import com.xv.Exception.CategoryRelatedException;
import com.xv.dao.CategoryDao;
import com.xv.dao.UserDao;
import com.xv.entity.Category;
import com.xv.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.smartcardio.CardTerminal;
import java.util.List;

/**
 * Created by xvzh on 2017/1/9.
 */

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Autowired
    UserDao userDao;

    /**
     * 创建文章分类，声明为一个事务性操作
     * @param uid
     * @param name
     */
    @Transactional
    public void createCategory(long uid, String name) {
        int res;
        try {
            res = categoryDao.addCategory(uid, name);
            userDao.increaseCategoryNum(uid);
        } catch (Exception e) {
            throw new CategoryRelatedException("插入分类失败");
        }
        if(res == 0) {
            throw new CategoryRelatedException("插入分类失败");
        }
    }

    public List<Category> getCategoriesByUid(long uid) {
        return categoryDao.getCategoriesByUid(uid);
    }

    public Category getCategoryById(long id) {
        Category category = categoryDao.getCategoryById(id);
        if(category == null) {
            throw new CategoryRelatedException("该分类不存在");
        }
        return category;
    }
}
