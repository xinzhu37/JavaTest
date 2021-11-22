package com.xinzhu.juc;

import java.util.concurrent.CountDownLatch;

/**
 * Create By GuoFZ on 2021/11/22
 */
public class JUCCountDownLatch {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);
        AThread aThread = new AThread(countDownLatch,countDownLatch2);
        BThread bThread = new BThread(countDownLatch,countDownLatch2);
        aThread.start();
        bThread.start();
    }
}
class AThread extends Thread{
    CountDownLatch countDownLatch;
    CountDownLatch countDownLatch2;

    public AThread(CountDownLatch countDownLatch,CountDownLatch countDownLatch2) {
        this.countDownLatch = countDownLatch;
        this.countDownLatch2 = countDownLatch2;
    }

    @Override
    public void run() {
        try {
            countDownLatch2.countDown();
            System.out.println("a");
            countDownLatch.await();
            System.out.println("c");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class BThread extends Thread{
    CountDownLatch countDownLatch;
    CountDownLatch countDownLatch2;

    public BThread(CountDownLatch countDownLatch,CountDownLatch countDownLatch2) {
        this.countDownLatch = countDownLatch;
        this.countDownLatch2 = countDownLatch2;
    }

    @Override
    public void run() {
        try {
            countDownLatch2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("b");
        countDownLatch.countDown();
    }
}