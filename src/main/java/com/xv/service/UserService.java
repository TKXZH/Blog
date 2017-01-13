package com.xv.service;

import com.xv.entity.User;

/**
 * Created by xvzh on 2016/12/28.
 */
public interface UserService {
    public void createUser(User user);

    public User getUserById(long id);

    public void modifyPwd(long id, String password);

    public void modifyNickName(long id, String nickName);

    public boolean userLogin(String userName, String passWord);

    public Long getUidByUserName(String userName);
}
