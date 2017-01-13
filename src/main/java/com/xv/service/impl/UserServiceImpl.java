package com.xv.service.impl;

import com.xv.Exception.UserRelatedException;
import com.xv.dao.UserDao;
import com.xv.entity.User;
import com.xv.service.UserService;
import com.xv.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xvzh on 2016/12/28.
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public Long getUidByUserName(String userName) {
        Long uid = userDao.getUidByUserName(userName);
        return uid;
    }

    public boolean userLogin(String userName, String passWord) {
        String pwd = userDao.getPwdByUserName(userName);
        if(pwd == null) {
            return false;
        } else {
            if(pwd.equals(MD5.toMd5(passWord))) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void createUser(User user) {
        try {
            userDao.createUser(user);
        } catch (Exception e) {
            throw new UserRelatedException("用户表操作异常");
        }
    }

    public User getUserById(long id) {
        User user = userDao.queryById(id);
        if(user == null) {
            throw new UserRelatedException("用户不存在");
        }
        return user;
    }

    public void modifyPwd(long id, String password) {
        int res;
        password = MD5.toMd5(password);
        try {
            res = userDao.modifyPassWord(id, password);
        } catch (Exception e) {
            throw new UserRelatedException("密码不能为NULL");
        }
        if(res == 0) {
            throw new UserRelatedException("无此用户");
        }
    }

    public void modifyNickName(long id, String nickName) {
        int res;
        try {
            res = userDao.modifyNickName(id, nickName);
        } catch (Exception e) {
            throw new UserRelatedException("昵称不能为NULL");
        }
        if(res == 0) {
            throw new UserRelatedException("无此用户");
        }
    }
}
