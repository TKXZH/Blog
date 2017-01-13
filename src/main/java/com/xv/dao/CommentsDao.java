package com.xv.dao;

import com.xv.entity.Comments;

import java.util.List;

/**
 * Created by xvzh on 2016/12/27.
 */
public interface CommentsDao {
    int createComment(Comments comments);
    int replyComment(Comments comments);
    List<Comments> showCommentsByArticleId(long articleId);
}
