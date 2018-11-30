package com.ygx.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.Element;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Description: ServletConfiger 配置
 * @author: YaoGuangXun
 * @date: 2018/11/6 12:02
 * @Version: 1.0
 */
public class ServletConfig01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取ServletConfig配置实例
        ServletConfig servletConfig = getServletConfig();
        // 获取web.xml配置文件中<servlet-name>的文本内容
        String servletName = servletConfig.getServletName();
        System.out.println(servletName);

        // 获取web.xml配置文件中的初始化参数。
        String adress = servletConfig.getInitParameter("adress");
        System.out.println("初始化参数："+adress);
        System.out.println();

        // 获取所有的参数名
        Enumeration<String> enumeration = servletConfig.getInitParameterNames();
        while (enumeration.hasMoreElements()){
          String key = enumeration.nextElement();
          String value =servletConfig.getInitParameter(key);
            System.out.println(key+":"+value);
        }

        //
        // 获取web.xml配置文件中的初始化参数。
        String number = servletConfig.getInitParameter("number");
        if (null == number){
            System.out.println("number 为空....");
        }else {
            System.out.println(number);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
