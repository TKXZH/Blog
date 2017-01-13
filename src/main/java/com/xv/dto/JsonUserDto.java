package com.xv.dto;

import com.xv.entity.User;

/**
 * Created by xvzh on 2017/1/6.
 */
public class JsonUserDto {
    private boolean status;
    private User user;

    public JsonUserDto(boolean status) {
        this.status = status;
    }

    public JsonUserDto(boolean status, User user) {
        this.status = status;
        this.user = user;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
