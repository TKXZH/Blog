package com.xv.dao;

import com.xv.entity.User;
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

@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {


    @Autowired
    UserDao userDao;

    @Test
    public void getUidByUserName() throws Exception {
        Long id = userDao.getUidByUserName("");
        System.out.println(id);
    }
    @Test
    public void getPwdByUserName() throws Exception {
        String string = userDao.getPwdByUserName("ddd");
        System.out.println(string);
    }


    @Test
    public void modifyNickName() throws Exception {
        System.out.println(userDao.modifyNickName(1000L,null));
    }

    @Test
    public void modifyPassWord() throws Exception {

    }


    @org.junit.Test
    public void createUser() throws Exception {
        User user = new User("xvzonghui","呵呵","941031");
        System.out.println(userDao.createUser(user));
    }

    @org.junit.Test
    public void queryById() throws Exception {
        User user = userDao.queryById(1078L);
        System.out.println(user);
    }

}