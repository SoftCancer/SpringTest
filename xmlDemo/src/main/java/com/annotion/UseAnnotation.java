package com.annotion;

import org.junit.Test;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/23 14:15
 * @Version: 1.0
 */
public class UseAnnotation {

    @Test
    @MyAnnotation(name = "爱新觉罗·玄烨")
    public void show(String str){
        System.out.println("姓名："+str);
    }

}
