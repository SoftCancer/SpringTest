package com.ygx.http;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: servletContext ：servlet上下文。
 * @author: YaoGuangXun
 * @date: 2018/11/6 16:08
 * @Version: 1.0
 */
public class ServletContext02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        String param = context.getInitParameter("param");
        System.out.println("通过ServletContext02获取全局参数：："+param);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
