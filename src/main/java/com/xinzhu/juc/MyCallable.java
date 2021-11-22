package com.xinzhu.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Create By GuoFZ on 2021/11/22
 */
public class MyCallable {
    public static void main(String[] args) throws Exception {
        // 创建mySum对象
        MySum mySum = new MySum(10);
        // 使用FutureTask来包装mySum对象
        FutureTask<Integer> futureTask = new FutureTask<>(mySum);
        new Thread(futureTask).start();
        Integer integer = futureTask.get();
        System.out.println("integer = " + integer);
    }
}
class MySum implements Callable<Integer>{
    private final int sum;
    private int number = 0;

    public MySum(int sum) {
        this.sum = sum;
    }

    @Override
    public Integer call(){
        for (int i = 1; i <= sum; i++) {
            number += i;
        }
        return number;
    }
}
