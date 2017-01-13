package com.xv.web;

import com.xv.dto.JsonDto;
import com.xv.entity.User;
import com.xv.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by xvzh on 2017/1/9.
 */

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @ResponseBody
    @RequestMapping(value = "/category/create", method = RequestMethod.POST)
    public Object createCategory(HttpSession session, String name) {
        User user = (User)session.getAttribute("user");
        if(user == null) {
            return new JsonDto(false, "用户未登录");
        }
        categoryService.createCategory(user.getId(), name);
        return new JsonDto(true, "创建分类成功");
    }

    @RequestMapping(value = "/{uid}/category", method = RequestMethod.GET)
    @ResponseBody
    public Object getCategoriesByUid(@PathVariable("uid") long uid) {
        return categoryService.getCategoriesByUid(uid);
    }
}
