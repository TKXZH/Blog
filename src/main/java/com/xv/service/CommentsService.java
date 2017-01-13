package com.xv.service;

import com.xv.entity.Comments;

import java.util.List;

/**
 * Created by xvzh on 2017/1/3.
 */
public interface CommentsService {
    public void createComment(Comments comments);

    public void replyComment(Comments comments);

    public List<Comments> showComments(long articleId);
}
