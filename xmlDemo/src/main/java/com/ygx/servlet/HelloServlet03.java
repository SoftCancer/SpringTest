package com.ygx.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Description: 用于演示servlet的生命周期
 * @author: YaoGuangXun
 * @date: 2018/11/6 10:05
 * @Version: 1.0
 */
public class HelloServlet03 implements Servlet {

    /**
     * 调用init方法的方式：
     * 1.创建servlet实例时，就执行init方法。
     * 一个servlet只会初始化一次，init方法只会执行一次。
     * 默认情况下：初次访问servlet，才会创建实例。
     **/
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("1. 初始化servlet。。。。");
    }

    @Override
    public ServletConfig01 getServletConfig() {
        return null;
    }

    /**
     * 调用service方法的方式：
     * 1.浏览器每次请求都会执行，该service方法。
     **/
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("2. HelloServlet03 每次浏览器请求服务器都执行该Service方法.....");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 调用销毁方法的方式：
     * 1.把项目从tomcat中移除，执行销毁方法。
     * 2.关闭服务器，执行销毁方法。
     **/
    @Override
    public void destroy() {
        System.out.println("3. 销毁servlet.....");
    }
}
