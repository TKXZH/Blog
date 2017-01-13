package com.xv.web.auth;

/**
 * Created by xvzh on 2016/12/29.
 */
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xv.util.TokenManager;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            AuthPassport authPassport = ((HandlerMethod) handler).getMethodAnnotation(AuthPassport.class);

            //没有声明需要权限,或者声明不验证权限
            if (authPassport == null || authPassport.value() == false) {
                return true;
            } else {
                if (request.getSession().getAttribute("user") == null) {
                    response.sendRedirect("/login");
                    return false;
                }
            }
        }
        return true;
    }

}
