package com.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/8 10:05
 * @Version: 1.0
 */
public class EncodeUtils {

    /**
     *  用于火狐浏览器下载解码
     * @Description:
     * @Author: YaoGuangXun
     * @Date: 2018/11/14 9:48
     * @Param: No such property: code for class: Script1
     * @Return
     **/
    public static String base64EncodeFileName(String fileName){
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String base64FileName = null;
        try {
            base64FileName = "=?UTF-8?B"+new String(base64Encoder.encode(fileName.getBytes("UTF-8"))) +"?=";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return base64FileName;

    }



}
