package com.thread;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/16 17:42
 * @Version: 1.0
 */
public class MyThread extends Thread {


    @Override
    public void run() {

        for (int i = 0; i < 10 ; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
