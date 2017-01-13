package com.xv.service.impl;

import com.xv.Exception.CommentsRelatedException;
import com.xv.dao.CommentsDao;
import com.xv.entity.Article;
import com.xv.entity.Comments;
import com.xv.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xvzh on 2017/1/3.
 */
@Service
public class CommentsServiceImpl implements CommentsService{

    @Autowired
    private CommentsDao commentsDao;

    public void replyComment(Comments comments) {
        int res = commentsDao.replyComment(comments);
        if(res == 0) {
            throw new CommentsRelatedException("回复评论数据插入异常");
        }
    }

    public void createComment(Comments comments) {
        int res = commentsDao.createComment(comments);
        if(res == 0) {
            throw new CommentsRelatedException("评论数据插入异常");
        }
    }

    public List<Comments> showComments(long articleId) {
        return commentsDao.showCommentsByArticleId(articleId);
    }
}
