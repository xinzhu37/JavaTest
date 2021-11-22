package com.xinzhu.juc;

import java.util.concurrent.Semaphore;

/**
 * Create By GuoFZ on 2021/11/22
 */
public class JUCSemaphore {
    public static void main(String[] args) {
        // 当前线程的最多数量，进场出场案例中场内的线程数的最大容量
        Semaphore semaphore = new Semaphore(2);
        MyThread myThread = new MyThread(semaphore);
        for (int i = 0; i < 5; i++) {
            new Thread(myThread).start();
        }
    }
}
class MyThread implements Runnable{
    Semaphore semaphore;

    public MyThread(Semaphore semaphore){
        this.semaphore = semaphore;
    }
    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "进来了");
            System.out.println(Thread.currentThread().getName() + "出去了");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
