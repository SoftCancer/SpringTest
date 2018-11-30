package com.ygx.cookies;

import com.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 获取用户上次登录时间
 */
public class CookieTest01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 已在过滤其中进行设置
//        resp.setContentType("text/html;charset=utf-8");

        if (username.equals("admin") && password.equals("123")) {

            // 1.获取浏览器的Cookie
            Cookie[] cookies = req.getCookies();
            // 2.获取指定用户的Cookie
            Cookie cookie = CookieUtils.getCookie(cookies, "last");

            // 3.判断Cookie 是否为空
            if (cookie == null) {
                Cookie cook = new Cookie("last", System.currentTimeMillis() + "");
                cook.setMaxAge(60 * 60 * 24);
                resp.addCookie(cook);
                resp.getWriter().write(username + "用户第1次登录成功");
            } else {
                // 获取以前Cookie中的数据
                Long newCookieDate = Long.valueOf(cookie.getValue());
                resp.getWriter().write(username + "用户登录成功,上次登录时间：" + new Date(newCookieDate));

                // 重置新的时间
                cookie.setValue(System.currentTimeMillis()+"");
                resp.addCookie(cookie);
            }

        } else {
            resp.getWriter().write("登录失败！");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
