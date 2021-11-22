package com.xinzhu.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Create By GuoFZ on 2021/11/22
 */
public class JUCCyclicBarrier {
    public static void main(String[] args) {
        // CyclicBarrier构造方法的第一个参数是指定等待的数量，第二个参数是等待跳闸后执行的实现Runnable的对象
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,new Meeting());
        Person person = new Person(cyclicBarrier);
//        Meeting meeting = new Meeting(cyclicBarrier);
        Thread thread1 = new Thread(person);
        Thread thread2 = new Thread(person);
        Thread thread3 = new Thread(person);
        Thread thread4 = new Thread(person);
        Thread thread5 = new Thread(person);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
//        meeting.start();
    }
}
class Meeting implements Runnable{

        /*CyclicBarrier cyclicBarrier;
        public Meeting(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }*/
    @Override
    public void run() {
        System.out.println("人都到齐了，会议开始~~");
    }
}
class Person implements Runnable{

    CyclicBarrier cyclicBarrier;
    public Person(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(Thread.currentThread().getName() + "到了");
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
