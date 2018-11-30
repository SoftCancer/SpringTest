package com.ygx.sessions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/9 14:18
 * @Version: 1.0
 */
public class ClearCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       HttpSession session = req.getSession();
       // 强制销毁所有对话，
//       session.invalidate();
        // 只移除Cart中的数据
       session.removeAttribute("Cart");
       resp.sendRedirect("Cart.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
