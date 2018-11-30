/**
 * Created by Administrator on 2017/6/9.
 * Copyright 2017-2018 汉威.智慧环保事业部 Limited.
 * All rights reserved.
 */
package com.util;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 对象处理工具类
 * @author 杜群星
 */
public class ObjectUtils {
    /**
     * 判断对象是否为null或"null"字符串
     * 是：true,否:false
     * @param o
     * @return
     */
    public static boolean isNull(Object o){
        if(null == o || "null".equals(o)){
            return true;
        }
        return false;
    }

    /**
     * 判断map是否为null 或 空集合<br>
     * 是：true,否：false
     * @param map
     * @return
     */
    public static boolean isNullMap(Map map){
        if(null == map || map.isEmpty()){
            return true;
        }
        return false;
    }

    public static boolean isNullList(List list){
        if(null == list || list.isEmpty()){
            return true;
        }
        return false;
    }

    public static String toString(Object object) throws Exception {
        if (isNull(object)) {
            return "";
        }
        if (object instanceof String) {
            return (String) object;
        }
        if (object instanceof Number) {
            return object.toString();
        }
        if (object instanceof Boolean) {
            return object.toString();
        }
        if (object instanceof Date) {
            return object.toString();
        }
        throw new Exception("不支持转换的类型：" + object.getClass().getCanonicalName());
    }

}
