package com.xv.dao;

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
public class CategoryDaoTest {

    @Autowired
    CategoryDao categoryDao;
    @Test
    public void addCategory() throws Exception {
        String name = "随笔";
        long uid = 10L;
        System.out.println(categoryDao.addCategory(uid, name));
    }
}