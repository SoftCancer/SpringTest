package com.ygx.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/7 9:37
 * @Version: 1.0
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 对请求内容进行中文解码 、同时也可以通过在tomcat的service中配置
        username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(username);
        System.out.println(password);

        // 解决浏览器乱码问题
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter printWriter = resp.getWriter();



        if ("admin".equals(username) && "123".equals(password)) {

            Object obj = getServletContext().getAttribute("count");

            int total = 0;
            if (obj != null)
                total = (int) obj;

            System.out.println("已经是第 " + (total + 1) + " 次登录");
            getServletContext().setAttribute("count", total + 1);

            resp.setStatus(302);
            resp.setHeader("Location", "success.html");
        } else {
            System.out.println("登录失败！");
            printWriter.write("登录失败！");
        }
        printWriter.close();
        printWriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
