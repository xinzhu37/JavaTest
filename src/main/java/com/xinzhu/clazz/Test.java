package com.xinzhu.clazz;

import java.lang.reflect.Field;
import java.util.Collection;

public class Test{
    public static void main(String[] args) throws Exception{
        A a= new A();
        Field[] fields = A.class.getDeclaredFields();
        for(Field field: fields){
            field.setAccessible(true);
            System.out.println(field.get(a));
        }
    }
}
class A {
    private String name;
    public int age;
}
