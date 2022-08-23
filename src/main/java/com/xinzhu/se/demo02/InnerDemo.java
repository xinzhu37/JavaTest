package com.xinzhu.se.demo02;

public class InnerDemo {
    public static void main(String[] args) {
        // 创建外部类对象 
        Person p  = new Person();
        // 创建内部类对象
        Person.Heart heart = p.new Heart();
        // 调用内部类方法
        heart.jump();
        // 调用外部类方法
        p.setLive(false);
        // 调用内部类方法
        heart.jump();

        //数组也是引用类型,存储在堆中
        int[] array = {1,2,3};
        Object[] array2 = {"a","b"};

        Object obj = array;
        Object obj2 = array2;
    }
}