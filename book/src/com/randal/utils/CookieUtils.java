package com.randal.utils;

import javax.servlet.http.Cookie;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.utils
 * @data 2020/6/29 16:27
 */
public class CookieUtils {
    /**
     * 查找指定名称的Cookie
     *
     * @param name    名称
     * @param cookies
     * @return
     */
    public static Cookie findCookie(String name, Cookie[] cookies) {
        if (name == null || cookies == null || cookies.length == 0) {
            return null;
        }
        for (Cookie c : cookies) {
            if (name.equals(c.getName())) {
                return c;
            }
        }


        return null;
    }
}