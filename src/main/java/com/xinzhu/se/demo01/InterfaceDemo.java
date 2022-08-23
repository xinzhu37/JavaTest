package com.xinzhu.se.demo01;

class dog {
    public String name;
    public String age;

    public dog() {
    }

    public dog(String name, String age) {
        this.name = name;
        this.age = age;
    }
    public static void run(){
        System.out.println("狗狗狗，跑跑跑");
    }
}
class ben extends dog{

    private String sss;

    public ben() {
        super();
        //this();
    }

    public ben(String sss) {
    }
}
interface A{
    static void eat(){
        System.out.println("我是静态方法");
    }
}
class B implements A{

}
public class InterfaceDemo {
    public static void main(String[] args) {
        B b = new B();
        //B.eat();
        ben ben1 = new ben();
        ben1.run();
        ben.run();
    }

}
