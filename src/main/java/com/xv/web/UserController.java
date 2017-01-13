package com.xv.web;

import com.xv.dto.JsonDto;
import com.xv.dto.JsonUserDto;
import com.xv.entity.User;
import com.xv.service.UserService;
import com.xv.util.TokenManager;
import com.xv.web.auth.AuthPassport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by xvzh on 2016/12/30.
 */

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "createuser", method = RequestMethod.GET)
    public String createUser() {
        return "register";
    }
    @RequestMapping(value = "/createuser", method = RequestMethod.POST)
    public String createUser(String name, String nickName, String pwd) {
        User user = new User(name, nickName, pwd);
        userService.createUser(user);
        long uid = userService.getUidByUserName(user.getName());
        return "redirect:" + uid + "/articles/admin";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String userName, String passWord, HttpServletRequest request) {
        if(userService.userLogin(userName, passWord)) {
            Long uid = userService.getUidByUserName(userName);
            User user = userService.getUserById(uid);
            request.getSession().setAttribute("user", user);
            return "redirect:" + uid + "/articles/admin";
        }
        return "login";
    }

    /**
     * 供ajax登录使用，若成功，则返回用户信息
     * @param userName
     * @param passWord
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/loginJ", method = RequestMethod.POST)
    public Object Login(String userName, String passWord, HttpServletRequest request) {
        if(userService.userLogin(userName, passWord)) {
            Long uid = userService.getUidByUserName(userName);
            User user = userService.getUserById(uid);
            request.getSession().setAttribute("user", user);
            return new JsonUserDto(true, user);
        }
        return new JsonUserDto(false);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String userSignUp() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String userSignUp(User user) {
        userService.createUser(user);
        return "redirect:/login";
    }

    /**
     * 供ajax获取当前登录用户信息
     * @param session
     * @return
     */
    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserInfo(HttpSession session) {
        User user = (User)session.getAttribute("user");
        if(user == null) {
            return new JsonUserDto(false);
        }
        return new JsonUserDto(true, user);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public Object logout(HttpSession session) {
        session.invalidate();
        return new JsonDto(true, "登出成功");
    }

}
