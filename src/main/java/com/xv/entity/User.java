package com.xv.entity;

import com.xv.util.MD5;

import java.util.Date;

/**
 * Created by xvzh on 2016/12/27.
 */
public class User {
    public User(){}
    public User(String name, String nickName, String pwd) {
        this.name = name;
        this.nickName = nickName;
        this.pwd = MD5.toMd5(pwd);
    }

    private long id;
    private String name;
    private String nickName;
    private String pwd;
    private Date createTime;
    private int articleNum;
    private int categoryNum;
    private int starNum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = MD5.toMd5(pwd);
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }

    public int getCategoryNum() {
        return categoryNum;
    }

    public void setCategoryNum(int categoryNum) {
        this.categoryNum = categoryNum;
    }

    public int getStar_num() {
        return starNum;
    }

    public void setStar_num(int starNum) {
        this.starNum = starNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
