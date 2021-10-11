package com.xinzhu.DynamicProxy;

/**
 * Create By GuoFZ on 2021/9/23
 */
public class InnerClass {
    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        b.setName("zhangsan");
    }
}
class A{
    private int id = 1;
    class B{
        private String name;

        public void setName(String name) {
            this.name = name;
        }
    }
}
