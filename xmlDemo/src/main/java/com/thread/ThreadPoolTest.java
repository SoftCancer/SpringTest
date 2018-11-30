package com.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 綫程池练习
 * @author: YaoGuangXun
 * @date: 2018/11/16 15:57
 * @Version: 1.0
 */
public class ThreadPoolTest {
    /**
     * 四种常见的线程池详解
     * 1. ExecutorService是Java提供的用于管理线程池的类。
     * 该类的两个作用：控制线程数量和重用线程
     **/

    /**
     * 1.1 Executors.newCacheThreadPool()：可缓存线程池，
     * 先查看池中有没有以前建立的线程，如果有，就直接使用。
     * 如果没有，就建一个新的线程加入池中，
     * 缓存型池子通常用于执行一些生存期很短的异步型任务
     *
     * Executors.newCacheThreadPool()： 创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，
     * 那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，此线程池又可以智能的添加新线程来处理任务。
     * 此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
     **/

    @Test
    public void ThreadPoolExecutorTest01() {
        // 创建一个可缓存线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {

            final  int index = i;
            try {
                //sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
                Thread.sleep(index*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    //打印正在执行的缓存线程信息
                    System.out.println(Thread.currentThread().getName() + "   正在被执行！");
                    System.out.println(index);
                }
            });
        }

        cachedThreadPool.shutdown();
    }

    /**
     * 1.2  Executors.newFixedThreadPool(int n)：创建一个可重用固定个数的线程池，
     * 以共享的无界队列方式来运行这些线程。
     *
     * Executors.newFixedThreadPool(int n)：创建固定大小的线程池。
     * 每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。
     * 线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
     **/
    @Test
    public void ThreadPoolExecutorTest02() {
        //创建一个可重用固定个数的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(8);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {

                    try {

                        System.out.println(index);
                        //打印正在执行的缓存线程信息
                        System.out.println(Thread.currentThread().getName() + "  正在被执行!");
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
            System.out.println("第" + i + " 次遍历！");
        }

        fixedThreadPool.shutdown();
    }

    /**
     * 1.3  Executors.newScheduledThreadPool(int n)：创建一个定长线程池，
     * 支持定时及周期性任务执行 延迟执行示例代码：
     *
     * Executors.newScheduledThreadPool(int n)：创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
     **/
    @Test
    public void ThreadPoolExecutorTest03() {
        //创建一个定长线程池，支持定时及周期性任务执行——延迟执行
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        //延迟1秒执行
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟1秒执行！");
            }
        }, 1, TimeUnit.SECONDS);

        scheduledThreadPool.shutdown();
    }


    @Test
    public void ThreadPoolExecutorTest04() {
        //创建一个定长线程池，支持定时及周期性任务执行——定期执行
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        //延迟1秒后每3秒执行一次
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("延迟1秒后每3秒执行一次");
            }
        }, 1000, 3000, TimeUnit.MILLISECONDS);

        scheduledThreadPool.shutdown();
    }

    /**
     * 2.4  Executors.newSingleThreadExecutor()：创建一个单线程化的线程池，
     * 它只会用唯一的工作线程来执行任务，
     * 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
     *
     *  Executors.newSingleThreadExecutor()：创建一个单线程的线程池。
     *  这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有任务。
     *  如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。
     *  此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
     **/
    @Test
    public void ThreadPoolExecutorTest05() {
        //创建一个单线程化的线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            final int index = 1;
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {

                    try {
                        //结果依次输出，相当于顺序执行各个任务
                        System.out.println(Thread.currentThread().getName() + "正在被执行,打印的值是:" + index);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            System.out.println("第" + i + " 次遍历！");
        }
        singleThreadExecutor.shutdown();
    }


}
