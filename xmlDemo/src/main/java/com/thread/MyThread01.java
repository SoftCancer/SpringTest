package com.thread;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/22 11:24
 * @Version: 1.0
 */
public class MyThread01 extends Thread {

    public MyThread01(String name){
        this.setName(name);
    }

    private int count =5;

    @Override
    public void run() {
        super.run();
        while (count > 0){
            count--;
            System.out.println("由 " + MyThread.currentThread().getName() + " 计算，count=" + count);
        }
    }

    public static void main(String[] args) {
        MyThread01 a = new MyThread01("A");
        MyThread01 b = new MyThread01("B");
        MyThread01 c = new MyThread01("C");
        a.start();
        b.start();
        c.start();
    }

}
