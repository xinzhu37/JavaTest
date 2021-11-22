package com.xinzhu.juc;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By GuoFZ on 2021/11/22
 */
public class SellBun {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        BaoZiPu baoZiPu = new BaoZiPu(list);
        ChiHuo chiHuo = new ChiHuo(list);
        new Thread(baoZiPu).start();
        new Thread(chiHuo).start();
    }
}
class BaoZiPu implements Runnable{
    List list;

    public BaoZiPu(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        Integer integer = 0;
        try {
            while (true){
                synchronized (list){
                    if (list.size() > 0){
                        list.wait();
                    }
                    list.add("包子");
                    integer++;
                    System.out.println(Thread.currentThread().getName() + "做" + list.get(0) + integer);
                    list.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ChiHuo implements Runnable{
    List list;

    public ChiHuo(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        Integer integer = 0;
        try {
            while (true){
                synchronized (list){
                    if (list.size() <= 0){
                        list.wait();
                    }
                    Object remove = list.remove(0);
                    integer++;
                    System.out.println(Thread.currentThread().getName() + "吃" + remove + integer);
                    list.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}