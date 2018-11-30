package com.util;

import java.io.File;
import java.io.IOException;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/5 11:00
 * @Version: 1.0
 */
public class URIUtils {

    /**
     * @Description: 获取项目的根路径；
     * @Author: YaoGuangXun
     * @Date: 2018/11/5 11:00
     * @Param: No such property: code for class: Script1
     * @Return: D:\WorkSpace\IDEA\SpringMVC_test\xmlDemo
     **/
    public static String getHostURI(){

        // 获取项目路径  ：  D:\WorkSpace\IDEA\SpringMVC_test\xmlDemo
        // 参数为空
        File directory = new File("");
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
            System.out.println(courseFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courseFile;

    }
}
