package com.xinzhu.clazz;

import java.lang.reflect.Method;
import java.util.ResourceBundle;

/**
 * Create By GuoFZ on 2021/10/25
 */
public class Methods {
    public static void main(String[] args) throws Exception {
        ResourceBundle clazz = ResourceBundle.getBundle("clazz");
        String student = clazz.getString("student");

        Class<?> aClass = Class.forName(student);

        Method[] methods = aClass.getMethods();
        for (java.lang.reflect.Method method : methods) {
            System.out.println("method = " + method);
        }

        Object obj = aClass.newInstance();
        Method show = aClass.getDeclaredMethod("show1",String.class,Integer.class);
        System.out.println("show = " + show);
        show.setAccessible(true);
        Object invoke = show.invoke(obj, "不念", 23);
        System.out.println("invoke = " + invoke);

        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod = " + declaredMethod);
        }

        String[] strings = new String[]{"c","x","v"};
        Method main = aClass.getMethod("main",String[].class);
        Object invoke1 = main.invoke(obj, (Object) strings);
        System.out.println("invoke1 = " + invoke1);
    }
}
