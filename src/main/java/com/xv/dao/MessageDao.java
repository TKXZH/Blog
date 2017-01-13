package com.xv.dao;

import com.xv.entity.Message;

import java.util.List;

/**
 * Created by xvzh on 2017/1/11.
 */
public interface MessageDao {
    int createMessage(Message message);
    
    List<Message> getMessagesByUid(long uid);
}
