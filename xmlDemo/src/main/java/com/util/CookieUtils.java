package com.util;

import javax.servlet.http.Cookie;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/8 16:05
 * @Version: 1.0
 */
public class CookieUtils {

    public static Cookie getCookie(Cookie[] cookies,String name){
        if(cookies != null){
            for (Cookie cookie : cookies) {
                String requestName =cookie.getName();
                if (requestName.equals(name)){
                    return cookie;
                }
            }
        }
        return null;
    }
}
