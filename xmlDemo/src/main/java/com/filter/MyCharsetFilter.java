package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/22 14:01
 * @Version: 1.0
 */
public class MyCharsetFilter implements Filter {

    private FilterConfig config ;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 获取配置文件中初始化值
        config =filterConfig;
        System.out.println("MyCharsetFilter正在初始化....");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 设置请求的字节编码
        request.setCharacterEncoding(config.getInitParameter("charset"));

        // 设置响应时的字节编码
        response.setCharacterEncoding(config.getInitParameter("charset"));
        response.setContentType(config.getInitParameter("contentType"));
        System.out.println("编码 charset："+config.getInitParameter("charset"));
        System.out.println("内容类型contentType："+config.getInitParameter("contentType"));
        // 放过过滤器
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("MyCharsetFilter销毁....");
    }
}
