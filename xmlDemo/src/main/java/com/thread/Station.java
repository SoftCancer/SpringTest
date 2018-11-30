package com.thread;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/22 10:27
 * @Version: 1.0
 */
public class Station extends Thread {

    // 通过构造方法给线程名字赋值
    public Station(String name) {
//        super(name);
        this.setName(name);
    }

    // 为了保持票数的一致，票数要静态
    static int tick = 0;

    // 创建一个静态钥匙
    static Object ob = "aa";//值是任意的

    @Override
    public void run() {
        super.run();
        while (tick <= 500) {
            synchronized (ob) {// 这个很重要，必须使用一个锁，
                // 进去的人会把钥匙拿在手上，出来后才把钥匙拿让出来
                if (tick <= 500) {
                    System.out.println(getName() + ": G2018列次列车，已售出第 " + tick + " 张车票!");
                    tick++;
                } else {
                    System.out.println("Sorry,本次列车的车票已经卖完了！");
                }
            }
            try {
                sleep(1000);//休息一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     *java多线程同步锁的使用
     * 示例：三个售票窗口同时出售10张票
     **/
    public static void main(String[] args) {
        System.out.println("---模拟售票点卖票----");
        //实例化站台对象，并为每一个站台取名字
        Station station1 = new Station("移动端售票窗口");
        Station station2 = new Station("PC端售票窗口");
        Station station3 = new Station("车站，授权售票点");

        // 让每一个站台对象各自开始工作
        station1.start();
        station2.start();
        station3.start();
    }

}
