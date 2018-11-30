package com.ygx.cookies;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/8 14:24
 * @Version: 1.0
 */
public class CookieTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        // 向浏览器设置Cookie
        // 创建Cookie对象
        Cookie cookie = new Cookie("yao", "ming");

        // 设置Cookie的过期日期
        cookie.setMaxAge(60*60*24);
        // 重新设置value
        cookie.setValue("liu");

        // 只有访问域名包含该地址时才会携带Cookie
        cookie.setPath("/cookie01");

        // 只有访问域名包含该域名时才会携带Cookie
        cookie.setDomain(".hf.com");

        resp.addCookie(cookie);
        Cookie cookie1 = new Cookie("age", "23");
        resp.addCookie(cookie1);

        resp.getWriter().write("请求成功....");

        // 获取Cookie
        Cookie[] cookies = req.getCookies();

        if (cookies != null){
            for (Cookie c : cookies) {
                String name = c.getName();
                String value = c.getValue();
                System.out.println(name+":"+value);
            }
        }else {
            System.out.println("暂时没有Cookie！");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
