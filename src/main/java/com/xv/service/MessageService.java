package com.xv.service;

import com.xv.entity.Message;

import java.util.List;

/**
 * Created by xvzh on 2017/1/12.
 */
public interface MessageService {
    public void createMessage(Message message);

    public List<Message> getMessage(long uid);
}
