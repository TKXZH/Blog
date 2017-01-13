package com.xv.entity;

import java.util.Date;

/**
 * Created by xvzh on 2017/1/11.
 */
public class Message {
    private long id;
    private long from;
    private long to;
    private Date createTime;
    private String content;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public long getTo() {
        return to;
    }

    public void setTo(long to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                '}';
    }
}
