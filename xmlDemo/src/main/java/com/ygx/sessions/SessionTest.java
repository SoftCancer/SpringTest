package com.ygx.sessions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/9 9:38
 * @Version: 1.0
 */
public class SessionTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
       // 1.获取商品id
        Integer id = Integer.valueOf(req.getParameter("id"));
        String[] names = {"iPhone 7Pluse", "iPhone SE", "华为", "锤子", "1+", "三星"};
        String name = names[id];
        // 2 . 获取购物车中的商品集合
        Map<String, Integer> map = (Map<String, Integer>) req.getSession().getAttribute("Cart");

        System.out.println("map:"+map);
        // 3.判斷购物车是否存在,不存在创建购物车，Session 中没有存放任何东西
        if (null == map) {
            map = new LinkedHashMap<>();
            req.getSession().setAttribute("Cart", map);

        }

        // 3判断购物车中有没有商品
        if (map.containsKey(name)) {
            // 有商品在原值上 +1
            map.put(name, map.get(name) + 1);
        } else {
            map.put(name, 1);
        }

        // 4.数据界面跳转
        resp.getWriter().write("<a href='Goods.jsp'><h3>继续购物</h3></a><br>");
        resp.getWriter().write("<a href='Cart.jsp'><h3>去购物车结算</h3></a>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
