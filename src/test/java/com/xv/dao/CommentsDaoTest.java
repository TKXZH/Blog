package com.xv.dao;

import com.xv.entity.Comments;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by xvzh on 2016/12/27.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class CommentsDaoTest {

    @Autowired
    CommentsDao commentsDao;
    @Test
    public void createComment() throws Exception {
        Comments comments = new Comments(1010L, 9L, "comments");
        commentsDao.createComment(comments);
    }

    @Test
    public void replyComment() throws Exception {
        Comments comments = new Comments(1001L, 1000L, "回复评论", 1000L);
        commentsDao.replyComment(comments);
    }

}