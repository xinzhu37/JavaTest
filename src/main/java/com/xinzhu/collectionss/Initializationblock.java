package com.xinzhu.collectionss;

public class Initializationblock {

    int intA;
    int intB;


    public Initializationblock() {
        System.out.println("无参构造器00000000");
    }

    public Initializationblock(int a) {
        System.out.println("一个参数的构造器");
        
    }


    {
        intA = 10;
        intB = 15;

        System.out.println("构造初始化块11111");
    }

    {
        System.out.println("构造初始化块22222");
    }

    {
    	
        System.out.println("构造初始化块33333");
    }

    //静态初始化块
    static {
        System.out.println("静态初始化块01010101");
    }

    static {
        System.out.println("静态初始化块0202020202");
    }
    public void method(){
        System.out.println("方法业务");
    	{
    		System.out.println("普通初始化块");
    	}
    }
}
