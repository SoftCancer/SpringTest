package com.thread;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/16 17:52
 * @Version: 1.0
 */
public class MyThreadRun implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner1：" + i);
        }
    }
}
