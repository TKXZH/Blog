package com.xv.dao;

import com.xv.entity.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xvzh on 2017/1/12.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class MessageDaoTest {

    @Autowired
    MessageDao messageDao;
    @Test
    public void createMessage() throws Exception {
        Message message = new Message();
        message.setContent("dasdasd");
        message.setFrom(1010L);
        message.setTo(1010L);
        System.out.println(messageDao.createMessage(message));
    }

    @Test
    public void getMessagesByUid() throws Exception {
        List<Message> messages = messageDao.getMessagesByUid(1010L);
        Message message = messages.get(0);
        System.out.println(message);
    }

}