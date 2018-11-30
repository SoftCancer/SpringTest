package com.ygx.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Description: 获取请求头的所有信息
 * @author: YaoGuangXun
 * @date: 2018/11/7 11:31
 * @Version: 1.0
 */
public class HttpServletReq extends HttpServlet {

    /**
     * 获取请求头的所有信息
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-------------获取请求头的信息----------------");

        Enumeration enumeration = req.getHeaderNames();
        while (enumeration.hasMoreElements()){
           String element = (String) enumeration.nextElement();
           String value = req.getHeader(element);
            System.out.println(element +" : "+value);
        }

        System.out.println("------------解决输出到浏览器时中文乱码----------------");
        // 以字符流的形式进行写数据
//        resp.getWriter().write("hello");

        // 解决中文乱码
        // 1.指定输出到客户端的时候，这些文字使用UTF-8编码
//        resp.setCharacterEncoding("UTF-8");
        // 2.直接规定浏览器看这份数据时，使用指定编码
//        resp.setHeader("Content-Type","text/html;charset=UTF-8");
//        resp.getWriter().write("<h2>编码格式</h2>");

        // 以字节流的形式进行写数据（可以读取文件，字符串等） 默认UTF-8编码
//        resp.getOutputStream().write("你好".getBytes());
        resp.setStatus(302);
        resp.setHeader("Location","down.html");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
