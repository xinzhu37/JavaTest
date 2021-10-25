package com.xinzhu.Generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Create By GuoFZ on 2021/10/25
 */
public class GenericDemo {
    public static void main(String[] args) {
        Collection array = new ArrayList();
        array.add("不念");
        array.add("勿忘");
        array.add(416);

        // 遍历array数组
        Iterator iterator = array.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println("next = " + next);
        }

        //MyGenericClass
        MyGenericClass<String> myGenericClass = new MyGenericClass<>();
        myGenericClass.setHn("奥巴马");
        System.out.println("myGenericClass.getHn() = " + myGenericClass.getHn());

        MyGenericClass<Integer> myGeneric = new MyGenericClass<>();
        myGeneric.setHn(114);
        System.out.println("myGeneric.getHn() = " + myGeneric.getHn());

        //MyGenericMethod
        MyGenericMethod myGenericMethod = new MyGenericMethod();
        myGenericMethod.show1("佘立阳");
        Integer integer = myGenericMethod.show2(123);
        System.out.println("integer = " + integer);

        // MyGenericInterface
        // 因为是接口，不能有实例，需要创建新的类GenericInterfaceDemo
        GenericInterfaceDemo genericInterface = new GenericInterfaceDemo();
        genericInterface.eat("麻辣烫");
        String speak = genericInterface.speak("好吃");
        System.out.println("speak = " + speak);

        // 因为是接口，不能有实例，需要创建新的类GenericInterfaceDemo2
        GenericInterfaceDemo2 genericInterface2 = new GenericInterfaceDemo2();
        genericInterface2.eat("麻辣烫");
        System.out.println("speak2 = " + genericInterface2.speak(886));

        // 通配符？的用法
        Collection list = new ArrayList();
        list.add("测试");
        GenericDemo.getElement(list);
        Collection<String> list1 = new ArrayList<>();
        list1.add("二狗");
        getElement(list1);
        Collection<Integer> list2 = new ArrayList<>();
        list2.add(113);
        getElement(list2);

        // 高级通配符，上限&下限
        Collection<String> collection2 = new ArrayList<>();
        Collection<Integer> collection3 = new ArrayList<>();
        Collection<Number> collection4 = new ArrayList<>();
        Collection<Object> collection5 = new ArrayList<>();

//        getElement2(collection2); //false
        getElement2(collection3);
        getElement2(collection4);
//        getElement2(collection5); //false


//        getElement3(collection2); //false
//        getElement3(collection3); //false
        getElement3(collection4);
        getElement3(collection5);
    }
    private static void getElement(Collection<?> e){
        for (Object o : e) {
            System.out.println("o = " + o);
        }
    }
    // 泛型上限，此时的泛型？，必须是Number或Number类的子类
    private static void getElement2(Collection<? extends Number> e){
        for (Object o : e) {
            System.out.println("o = " + o);
        }
    }
    // 泛型下限，此时的泛型？，必须是Number或Number类的超类
    private static void getElement3(Collection<? super Number> e){
        for (Object o : e) {
            System.out.println("o = " + o);
        }
    }
}
