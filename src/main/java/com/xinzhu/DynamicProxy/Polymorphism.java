package com.xinzhu.DynamicProxy;

/**
 * Create By GuoFZ on 2021/9/23
 * 多态来代替if...else
 */
public class Polymorphism {
    public static void main(String[] args) {
        methodOne(new XIAOMI());
        /**
         * 匿名内部类
         * 不需要写接口的实现类，直接重写接口方法
         */
        methodOne(new Phone() {
            public static final int aaa = 111;
            @Override
            public void brand() {
                System.out.println("苹果手机");
            }
        });
    }
    public static void methodOne(Phone phone){
        phone.brand();
    }
}
interface Phone {
    void brand();
}
class HUAWEI implements Phone {
    @Override
    public void brand() {
        System.out.println("华为手机");
    }
}
class XIAOMI implements Phone {
    @Override
    public void brand() {
        System.out.println("小米手机");
    }
}

