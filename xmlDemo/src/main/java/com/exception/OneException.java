/**
 * Created by Administrator on 2017/6/9.
 * Copyright 2017-2018 汉威.智慧环保事业部 Limited.
 * All rights reserved.
 */
package com.exception;

public class OneException extends RuntimeException {
    public OneException() {
        super();
    }

    public OneException(String message) {
        super(message);
    }

    public OneException(String message, Throwable cause) {
        super(message, cause);
    }

    public OneException(Throwable cause) {
        super(cause);
    }

    protected OneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
