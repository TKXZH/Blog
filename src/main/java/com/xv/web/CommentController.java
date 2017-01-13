package com.xv.web;

import com.xv.entity.Article;
import com.xv.entity.Comments;
import com.xv.entity.User;
import com.xv.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xvzh on 2017/1/3.
 */

@Controller
public class CommentController {

    @Autowired

    private CommentsService commentsService;

    @RequestMapping("/articles/{articleId}/comments")
    @ResponseBody
    public List<Comments> getCommentsByArticleId(@PathVariable("articleId") long articleId) {
        return commentsService.showComments(articleId);
    }
}
