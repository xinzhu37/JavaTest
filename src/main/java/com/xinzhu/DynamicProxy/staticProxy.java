package com.xinzhu.DynamicProxy;

/**
 * Create By GuoFZ on 2021/9/22
 * 1、多态：向上转型
 * 2、代理类，引入代理类的类型对象，用代理对象去调用子类重写的方法，并对方法增强
 */
public class staticProxy {
    public static void main(String[] args) {
        RegisteredService registerService = new registerServiceImpl();
        testStaticProxy testStaticProxy = new testStaticProxy(registerService);
        testStaticProxy.register("张三","000000");
    }
}
//写个接口，用于注册
interface RegisteredService {
    void register(String name,String pwd);
}
//实现注册接口
class registerServiceImpl implements RegisteredService {
    @Override
    public void register(String name,String pwd) {
        System.out.println(String.format("[此处业务主要向数据库中插入数据] name：%s，pwd：%s",name,pwd));
    }
}
//代理类也实现RegisteredService接口
class testStaticProxy implements RegisteredService {
    private RegisteredService registeredService;
    public testStaticProxy(RegisteredService registeredService){
        this.registeredService = registeredService;
    }
    @Override
    public void register(String name, String pwd) {
        System.out.println("编辑注册之前的业务，动态代理用于新增业务");
        registeredService.register(name,pwd);
        System.out.println(String.format("[静态代理] 用户名：%s，密码：%s",name,pwd));
        System.out.println("编辑注册之后的业务，动态代理用于新增业务");
    }
}
