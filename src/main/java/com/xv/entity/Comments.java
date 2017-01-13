package com.xv.entity;

import java.util.Date;

/**
 * Created by xvzh on 2016/12/27.
 */
public class Comments {
    public Comments() {}
    public Comments(long uid, long articleId, String content) {
        this.uid = uid;
        this.articleId = articleId;
        this.content = content;
    }
    public Comments(long uid, long articleId, String content, long replyTo) {
        this.uid = uid;
        this.articleId = articleId;
        this.content = content;
        this.replyTo = replyTo;
    }
    private long id;
    private long uid;
    private long articleId;
    private String content;
    private long replyTo;
    private Date createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(long replyTo) {
        this.replyTo = replyTo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", uid=" + uid +
                ", articleId=" + articleId +
                ", content='" + content + '\'' +
                ", replyTo=" + replyTo +
                ", createTime=" + createTime +
                '}';
    }
}
