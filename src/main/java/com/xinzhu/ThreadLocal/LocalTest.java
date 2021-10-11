package com.xinzhu.ThreadLocal;

/**
 * Create By GuoFZ on 2021/10/11
 */
public class LocalTest {

    // 创建一个ThreadLocal对象
    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public String count;

    public String getCount() {
        return threadLocal.get();
    }

    public void setCount(String count) {
        threadLocal.set(count);
    }

    public static void main(String[] args) {

        LocalTest localTest = new LocalTest();
        for (Integer i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    // 调用对象的setter方法，往里面存值
                    localTest.setCount(Thread.currentThread().getName() + "的数据");
                    System.out.println("----------" + Thread.currentThread().getName() + "-----------");
                    System.out.println(Thread.currentThread().getName() + "--->" + localTest.getCount());
                }
            });
            thread.setName("线程" + i);
            thread.start();
        }
    }
}
