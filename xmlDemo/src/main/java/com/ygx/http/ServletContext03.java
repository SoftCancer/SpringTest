package com.ygx.http;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @Description: servletContext ：servlet上下文。
 * @author: YaoGuangXun
 * @date: 2018/11/6 16:08
 * @Version: 1.0
 */
public class ServletContext03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         *  通过ServletContext 获取绝对路径
         **/
        ServletContext context = getServletContext();
        String path = context.getRealPath("file/config.properties");
        System.out.println("path:"+path);

        Properties properties = new Properties();

        InputStream inputStream = new FileInputStream(path);
        properties.load(inputStream);
        String value = properties.getProperty("name");
        System.out.println("value值："+value);

        Enumeration enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()){
            String element = (String) enumeration.nextElement();
            String valu = properties.getProperty(element);

            System.out.println(element+"----"+valu);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
