package com.annotion;

import java.lang.reflect.Method;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/23 14:20
 * @Version: 1.0
 */
public class MyAnnotationParser {

    public static void main(String[] args) {
        try {
            //        获取字节码对象
            Class clazz = UseAnnotation.class;
            System.out.println("clazz: " + clazz);

            Method method = clazz.getMethod("show", String.class);
            System.out.println("method: " + method);

            //        获取方法上面的注解
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            //        获取注解属性值
            System.out.println(annotation.name()+": "+annotation.value());

            method.invoke(new UseAnnotation(),"HH");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
