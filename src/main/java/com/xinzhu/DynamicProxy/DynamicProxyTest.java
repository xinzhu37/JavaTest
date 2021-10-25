package com.xinzhu.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Create By GuoFZ on 2021/9/23
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        // 我们要代理的真实对象
        Free realPerson = new Free();

        // 我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new DynamicProxy(realPerson);

        /*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，
         * 我们来看看其三个参数 第一个参数 handler.getClass().getClassLoader()
         * 我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，
         * 表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的InvocationHandler这个对象上
         */
        ClassLoader classLoader = handler.getClass().getClassLoader();
        Person2 person = (Person2) Proxy.newProxyInstance(
                handler.getClass().getClassLoader(),
                realPerson.getClass().getInterfaces(),
                handler
        );

        System.out.println(person.getClass().getName());
        person.doWork2();
        person.doRequire2("MDM主数据");
    }
}
interface Person{
    void doWork();
    void doRequire(String str);
}
interface Person2{
    void doWork2();
    void doRequire2(String str);
}
class LiSi implements Person{
    @Override
    public void doWork() {
        System.out.println("lisi做测试");
    }

    @Override
    public void doRequire(String str) {
        System.out.println("lisi做需求:" + str);
    }
}
class Free implements Person2{
    @Override
    public void doWork2() {
        System.out.println("Free做测试");
    }

    @Override
    public void doRequire2(String str) {
        System.out.println("Free做需求:" + str);
    }
}

class DynamicProxy implements InvocationHandler{
    private Object person;

    public DynamicProxy(Object person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在代理真实对象前我们可以添加一些自己的操作
        System.out.println("before rent house");

        System.out.println("Methods:" + method);

        // 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        method.invoke(person, args);

        // 在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("after rent house");

        return null;
    }
}
