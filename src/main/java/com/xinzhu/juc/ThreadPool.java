package com.xinzhu.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create By GuoFZ on 2021/11/22
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 7; i++) {
            executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "获取"));
        }
        executorService.shutdown();
    }
}
