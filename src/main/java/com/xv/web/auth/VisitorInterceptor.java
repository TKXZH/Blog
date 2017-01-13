package com.xv.web.auth;

import com.xv.util.TokenManager;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xvzh on 2017/1/5.
 */
public class VisitorInterceptor extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            VisitorAuth visitorAuth = ((HandlerMethod) handler).getMethodAnnotation(VisitorAuth.class);

            //没有声明需要权限,或者声明不验证权限
            if(visitorAuth == null || visitorAuth.value() == false) {
                return true;
            }
            Cookie[] cookies = request.getCookies();
            if(cookies == null) {
                return true;
            }
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("token")) {
                    String tokenStr = cookie.getValue();
                    Long uid = TokenManager.checkUserByToken(tokenStr);
                    if(uid == null) {
                        return true;
                    }

                    if(null == request.getSession().getAttribute("token") ) {
                        request.getSession().setAttribute("token", uid);
                    }
                    return true;
                }
            }


        }
        return true;
    }
}
