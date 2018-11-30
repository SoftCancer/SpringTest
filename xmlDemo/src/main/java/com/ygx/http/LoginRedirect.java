package com.ygx.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/8 10:41
 * @Version: 1.0
 */
public class LoginRedirect extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println("用户名：:"+username);

        if ("admin".equals(username) && "123".equals(password)) {
            // 请求转发
            req.setAttribute("success","成功！");
            resp.sendRedirect("success.html");
        }else {
            // 重定向
            req.getRequestDispatcher("/views/error.html").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
