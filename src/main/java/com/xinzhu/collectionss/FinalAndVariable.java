package com.xinzhu.collectionss;

/**
 * Create By GuoFZ on 2021/10/27
 */
public class FinalAndVariable {
    public int t;
    public final int b; //编译成功
    public final int c = 1; //编译成功

    public FinalAndVariable() {  //构造方法
        b=2;  //在构造方法中将成员变量b进行初始化
    }
}
