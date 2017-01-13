package com.xv.dto;

import com.xv.entity.Category;
import com.xv.entity.User;

import java.util.List;

/**
 * Created by xvzh on 2017/1/12.
 */
public class MessageUserCategoriesDto {


    private List<MessageUserDto> muDtos;
    private List<Category> categories;
    private User author;

    public MessageUserCategoriesDto(List<MessageUserDto> muDtos, List<Category> categories, User author) {
        this.muDtos = muDtos;
        this.categories = categories;
        this.author = author;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<MessageUserDto> getMuDtos() {
        return muDtos;
    }

    public void setMuDtos(List<MessageUserDto> muDtos) {
        this.muDtos = muDtos;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
