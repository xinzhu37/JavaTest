package com.xinzhu.clazz;

import java.lang.reflect.Constructor;
import java.util.ResourceBundle;

/**
 * Create By GuoFZ on 2021/10/22
 */
public class CreateClassTest {
    public static void main(String[] args) {
        ResourceBundle resource = ResourceBundle.getBundle("clazz");
        String student = resource.getString("student");
        //
        try {
            Class<?> clazz = Class.forName(student);
            System.out.println("clazz = " + clazz);

            Object o1 = clazz.newInstance();

            //2.获取所有公有构造方法
            System.out.println("**********************所有公有构造方法*********************************");
            Constructor[] conArray = clazz.getConstructors();
            for (Constructor<?> constructor : conArray) {
                System.out.println("constructor = " + constructor);
            }

            // 3.获取所有构造方法
            System.out.println("**********************所有构造方法*********************************");
            Constructor[] conArray2 = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : conArray2) {
                System.out.println("constructor2 = " + constructor);
            }

            // 4.获取所有构造方法
            System.out.println("**********************所有无参构造方法*********************************");
            Constructor con = clazz.getConstructor(null);
            System.out.println("constructor3 = " + con);
            Object o = con.newInstance();
            System.out.println("o = " + o);
//            con.setAccessible(true);
//            Object instance = con.newInstance("张三", 12);
//            System.out.println("instance = " + instance);

            System.out.println("******************获取私有构造方法，并调用*******************************");
            con = clazz.getDeclaredConstructor(String.class,int.class);
            System.out.println("declaredConstructor = " + con);
            con.setAccessible(true);
            Object obj = con.newInstance("张三",23);
            System.out.println("obj = " + obj);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
