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
 * 1、获取全局配置参数
 * 2、获取web工程中的资源
 * 3、存取数据,service间共享数据
 * @author: YaoGuangXun
 * @date: 2018/11/6 16:08
 * @Version: 1.0
 */
public class ServletContext04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         *  通过ServletContext 获取绝对路径，读取配置文件内容；
         **/
        System.out.println("第二种方式：");
        getPropertiseValue01();

        System.out.println("第三种方式：");
        getPropertiseValue02();

        System.out.println("第四种方式：");
        getPropertiseValue03();

    }

    public void getPropertiseValue01() {
        ServletContext context = getServletContext();
        String path = context.getRealPath("file/config.properties");
        System.out.println("path:" + path);

        Properties properties = new Properties();

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = properties.getProperty("name");
        System.out.println("value值：" + value);

        Enumeration enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String element = (String) enumeration.nextElement();
            String valu = properties.getProperty(element);
            System.out.println(element + "----" + valu);
        }
    }

    public void getPropertiseValue02() {
        ServletContext context = getServletContext();
        InputStream inputStream = context.getResourceAsStream("file/config.properties");

        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = properties.getProperty("name");
        System.out.println("value值：" + value);

    }

    public void getPropertiseValue03() {
//        InputStream inputStream = context.getResourceAsStream("file/config.properties");
        // 获取classes路径:D:\WorkSpace\IDEA\SpringMVC_test\xmlDemo\target\xmlDemo\WEB-INF\classes
        ClassLoader classLoader = this.getClass().getClassLoader();
        System.out.println("classLoader::"+classLoader);

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("../../file/config.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Enumeration enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String element = (String) enumeration.nextElement();
            String valu = properties.getProperty(element);
            System.out.println(element + "----" + valu);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
