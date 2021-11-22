package com.xinzhu.juc;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Create By GuoFZ on 2021/11/22
 */
public class JUCExchanger {
    public static void main(String[] args) {
        Exchanger<String> stringExchanger = new Exchanger<>();
        PayThread payThread = new PayThread(stringExchanger);
        SellThread sellThread = new SellThread(stringExchanger);
        payThread.start();
        sellThread.start();
    }
}
class PayThread extends Thread{
    Exchanger exchanger;

    public PayThread(Exchanger exchanger){
        this.exchanger = exchanger;
    }
    @Override
    public void run() {
        String str = "钱";
        try {
            Thread.sleep((long) (Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "取钱");
//        try {
//            Object exchange = exchanger.exchange(str);
//            System.out.println(Thread.currentThread().getName() + "美滋滋的拿" + exchange + "回家");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
class SellThread extends Thread{
    Exchanger exchanger;

    public SellThread(Exchanger exchanger){
        this.exchanger = exchanger;
    }
    @Override
    public void run() {
        String str = "货";
        try {
            Thread.sleep((long) (Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "进货");
        try {
            Object exchange = exchanger.exchange(str,3000, TimeUnit.MILLISECONDS);
            System.out.println(Thread.currentThread().getName() + "笑呵呵的拿" + exchange + "回家");
        } catch (InterruptedException | TimeoutException e) {
            e.printStackTrace();
            System.out.println("快跑");
        }
    }
}

