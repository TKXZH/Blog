package com.xv.dto;

/**
 * Created by xvzh on 2017/1/5.
 */
public class JsonDto {
    private boolean status;
    public JsonDto(boolean status, String info) {
        this.status = status;
        this.info = info;
    }

    private String info;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
