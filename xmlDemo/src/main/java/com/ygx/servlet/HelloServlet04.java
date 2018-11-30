package com.ygx.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Description: 演示提前加载init方法
 * @author: YaoGuangXun
 * @date: 2018/11/6 10:51
 * @Version: 1.0
 */
public class HelloServlet04 implements Servlet {

    /**
     *   在web.xml中配置如下：
     *   设置init加载的权重-->
     *   <load-on-startup>2</load-on-startup>
     **/
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("1. 初始化servlet。。。。");
    }

    @Override
    public ServletConfig01 getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
