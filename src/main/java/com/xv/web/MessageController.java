package com.xv.web;

import com.xv.dto.JsonDto;
import com.xv.dto.MessageUserCategoriesDto;
import com.xv.dto.MessageUserDto;
import com.xv.entity.Category;
import com.xv.entity.Message;
import com.xv.entity.User;
import com.xv.service.CategoryService;
import com.xv.service.MessageService;
import com.xv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xvzh on 2017/1/12.
 */

@Controller
public class MessageController {

    @Autowired
    MessageService messageService;
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "{uid}/articles/messages")
    public String getMessagesByUser(@PathVariable("uid") long uid, Model model) {
        List<Message> messages = messageService.getMessage(uid);
        List<MessageUserDto> muDtos = new ArrayList<MessageUserDto>();
        for(Message message : messages) {
            User user = userService.getUserById(message.getFrom());
            MessageUserDto muDto = new MessageUserDto(message, user);
            muDtos.add(muDto);
        }
        List<Category> categories = categoryService.getCategoriesByUid(uid);
        User user = userService.getUserById(uid);
        model.addAttribute("mucDto", new MessageUserCategoriesDto(muDtos, categories, user));
        //为主页下的服务统一加上博主信息
        model.addAttribute("user", user);
        return "article_message";
    }

    @ResponseBody
    @RequestMapping("/messages/new")
    public Object createMessage(Message message, HttpSession session) {
        if(session.getAttribute("user") == null) {
            return new JsonDto(false, "留言失败");
        }
        try {
            messageService.createMessage(message);
        } catch (Exception e) {
            return new JsonDto(false, "留言失败");
        }
        return new JsonDto(true, "留言成功");
    }
}
