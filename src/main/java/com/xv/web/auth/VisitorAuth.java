package com.xv.web.auth;

import java.lang.annotation.*;

/**
 * Created by xvzh on 2017/1/5.
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface VisitorAuth {
    boolean value() default true;
}