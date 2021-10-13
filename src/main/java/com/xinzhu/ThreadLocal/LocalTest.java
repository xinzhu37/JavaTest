package com.xinzhu.ThreadLocal;

import com.xinzhu.Polymorphic.demo;

/**
 * Create By GuoFZ on 2021/10/11
 */
public class LocalTest {

    // 创建一个ThreadLocal对象
    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public String count;

    public String getCount() {
        return count;
//        return threadLocal.get();
    }

    public void setCount(String count) {
        this.count = count;
//        threadLocal.set(count);
    }

    public static void main(String[] args) {

        LocalTest localTest = new LocalTest();
        for (Integer i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    // 使用synchronized锁，以时间换空间的思想来完成并发控制
                    synchronized (demo.class){
                        // 调用对象的setter方法，往里面存值
                        localTest.setCount(Thread.currentThread().getName() + "的数据");
                        System.out.println("----------" + Thread.currentThread().getName() + "-----------");
                        System.out.println(Thread.currentThread().getName() + "--->" + localTest.getCount());
                    }
                }
            });
            thread.setName("线程" + i);
            thread.start();
        }
    }
}
