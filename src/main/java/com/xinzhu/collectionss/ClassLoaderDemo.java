package com.xinzhu.collectionss;

import java.lang.reflect.Method;

/**
 * Create By GuoFZ on 2021/11/9
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {
        String path = "C:\\Users\\xinzhu\\Desktop\\com\\MyClassLoaderTest.class";
        MyClassLoader myClassLoader = new MyClassLoader(path);

        //类的全路径名
        String pathClass = "com.xinzhu.collectionss.MyClassLoaderTest";
        try {
            Class<?> aClass = myClassLoader.loadClass(pathClass);
            System.out.println("aClass.getClassLoader() = " + aClass.getClassLoader());

            Method main = aClass.getDeclaredMethod("main", String[].class);
            Object instance = aClass.newInstance();
            String[] o = {"obj"};
            main.invoke(instance,(Object) o);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
