package com.xv.entity;

/**
 * Created by xvzh on 2016/12/27.
 */
public class SuperUser {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "id=" + id +
                '}';
    }
}
