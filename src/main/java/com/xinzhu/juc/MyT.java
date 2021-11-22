package com.xinzhu.juc;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Create By GuoFZ on 2021/11/22
 */
public class MyT {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Calendar instance = Calendar.getInstance();
                Date time = instance.getTime();
                System.out.println(time);
            }
        },3000,1000);
    }
}
