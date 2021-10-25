package com.xinzhu.Generic;

/**
 * Create By GuoFZ on 2021/10/25
 */
public class MyGenericMethod {
    public <HN> void show1(HN hn){
        System.out.println("hn = " + hn);
    }

    public <HN> HN show2(HN hn){
        return hn;
    }
}
