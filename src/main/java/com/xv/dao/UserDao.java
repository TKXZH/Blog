package com.xv.dao;

import com.xv.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by xvzh on 2016/12/27.
 */
public interface UserDao {
    /**
     * 创建新用户，成功时返回1
     * @param user
     * @return
     */
    int createUser(User user);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User queryById(long id);

    /**
     * 用户修改昵称
     * @param id
     * @param nickName
     * @return
     */
    int modifyNickName(@Param("id") long id, @Param("nickName") String nickName);

    /**
     * 用户修改密码
     * @param id
     * @param pwd
     * @return
     */
    int modifyPassWord(@Param("id") long id, @Param("pwd") String pwd);

    /**
     * 根据用户名获取用户密码
     * @param userName
     * @return
     */
    String getPwdByUserName(String userName);

    /**
     * 根据用户名获取用户id
     * @param userName
     * @return
     */
    Long getUidByUserName(String userName);

    /**
     * 增加用户的文章数
     * @param id
     */
    void increaseArticleNum(long id);

    void increaseCategoryNum(long id);

    int increaseStarNum(long id);
}
