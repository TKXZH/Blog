package com.xv.dto;

import com.xv.entity.Message;
import com.xv.entity.User;

import java.util.List;

/**
 * Created by xvzh on 2017/1/12.
 */
public class MessageUserDto {
    public MessageUserDto(Message message, User user) {
        this.message = message;
        this.user = user;
    }

    private Message message;
    private User user;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
