package com.ygx.http;

import com.util.EncodeUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @Description: 文件下载演示代码
 * @author: YaoGuangXun
 * @date: 2018/11/7 16:24
 * @Version: 1.0
 */
public class DownloadHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fileName = req.getParameter("fileName");
        System.out.println("文件名称转码前："+fileName);
        // 解决接收请求时，中文乱码问题
//        fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println("文件名称转码后："+fileName);


        String path = getServletContext().getRealPath("/download/" + fileName);
        System.out.println("路径：："+path);
        String clineType = req.getHeader("User-Agent");
        System.out.println("contextType:"+clineType);

        // 解决中文文件下载时，浏览器弹出框无中文文件名或者乱码
        // 判断是否是火狐浏览器，火狐浏览器的编码格式是：Base64
        if(clineType.contains("Firefox")){
            EncodeUtils.base64EncodeFileName(fileName);
        }else {
        // IE 谷歌使用的是：Encoding编码
            fileName = URLEncoder.encode(fileName,"UTF-8");
        }
        System.out.println("浏览器编码："+fileName);

        // 用于设置响应浏览器，让浏览器收到这个请求时，已下载的方式提醒用户
        resp.setHeader("Content-Disposition","attachment;filename="+fileName);

        InputStream is = new FileInputStream(path);
        OutputStream os = resp.getOutputStream();
        int len = 0;
        byte[] bytes = new byte[1024];

        while ((len = is.read(bytes)) !=-1){
                os.write(bytes,0,len);
        }

        os.close();
        os.flush();



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
