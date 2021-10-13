package com.xinzhu.Polymorphic;

class Father5{
    public void StaticMethod(){
        System.out.println("粑粑：我是父类粑粑静态方法");
    }
}
class Son5 extends Father5{
    public void StaticMethod(){
        System.out.println("熊孩子：我是子类熊孩砸静态方法");
    }
}
public class demooo {
    public static void main(String[] args) {
        Father5 fat=new Father5();
        Father5 son=new Son5(); //特别注意这里是向上转型  也就是多态！

        fat.StaticMethod();//同时调用StaticMethod方法！
        son.StaticMethod();
    }
}

