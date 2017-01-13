package com.xv.dao;

import com.xv.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xvzh on 2016/12/27.
 */
public interface CategoryDao {
    int addCategory(@Param("uid") long uid, @Param("name") String name);
    List<Category> getCategoriesByUid(long uid);
    Category getCategoryById(long id);
}
