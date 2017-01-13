package com.xv.service.impl;

import com.xv.Exception.MessageRelatedException;
import com.xv.dao.MessageDao;
import com.xv.entity.Message;
import com.xv.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xvzh on 2017/1/12.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;
    public List<Message> getMessage(long uid) {
        return messageDao.getMessagesByUid(uid);
    }

    public void createMessage(Message message) {
        try {
            messageDao.createMessage(message);
        } catch (Exception e) {
            throw new MessageRelatedException("创建留言失败");
        }
    }
}
