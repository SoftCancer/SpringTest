/**
 * Created by Administrator on 2018/1/18.
 * Copyright 2018 汉威科技.雪城软件.ONE Limited.
 * All rights reserved.
 */
package com.email;


import com.exception.OneException;

/**
 * 参数异常
 * @author qunxing.du
 */
public class ParameterException extends OneException {

    public ParameterException(String message) {
        super(message);
    }

}
