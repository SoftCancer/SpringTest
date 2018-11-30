package com.thread;

import org.junit.Test;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/16 17:45
 * @Version: 1.0
 */
public class ThreadTest {

    /**
     *  测试线程Thread
     **/
    @Test
    public void threadTest01() {
        for (int i = 0; i < 100; i++) {
            System.out.println("---------------" + i + "---------------");
            if (i == 30) {
                MyThread myThread = new MyThread();
                myThread.start();

                MyThread myThread1 = new MyThread();
                myThread1.start();
            }
        }
    }

    /**
     *  实现线程 Runnable 接口
     **/
    @Test
    public void threadTest02() {
        for (int i = 0; i < 100; i++) {
            System.out.println("---------------" + i + "---------------");
            if (i == 30) {
                MyThreadRun  myThreadRun = new MyThreadRun();
                myThreadRun.run();

                Thread t = new Thread(myThreadRun);//要启动一个新的线程就必须new一个Thread对象出来
                //这里使用的是Thread(Runnable target) 这构造方法
                t.start();//启动新开辟的线程，新线程执行的是run()方法，新线程与主线程会一起并行执行

                for(int j=0;j<10;j++){
                    System.out.println("maintheod："+i);
                }
            }
        }
    }



}
