package com.ygx.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/6 9:39
 * @Version: 1.0
 */
public class HelloServlet02 extends HttpServlet {

    /**
     *  重写父类的service方法。
     **/
//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        System.out.println("HelloServlet02:"+req);
//    }

    /**
     * 注释掉上边的service方法，doGet和doPost可以通过 父类HttpServlet 的service方法进行加载doGet和doPost方法。
     **/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("通过父类的service加载该方法..."+req.getMethod()+"-----"+req.getProtocol());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        System.out.println("通过父类的service加载该方法..."+req.getMethod());
    }
}
