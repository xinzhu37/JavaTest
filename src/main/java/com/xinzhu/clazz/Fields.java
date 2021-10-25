package com.xinzhu.clazz;

import java.lang.reflect.Field;
import java.util.ResourceBundle;

/**
 * Create By GuoFZ on 2021/10/22
 */
public class Fields {
    public static void main(String[] args) {
        //1.加载Class对象
        ResourceBundle resource = ResourceBundle.getBundle("clazz");
        String student = resource.getString("student");

        try {
            Class<?> clazz = Class.forName(student);
            //2.获取字段
            System.out.println("************获取所有公有的字段********************");
            Field[] fields = clazz.getFields();
            for (Field field : fields) {
                System.out.println("field = " + field);
            }

            System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                System.out.println("declaredField = " + declaredField);
            }

            System.out.println("*************获取公有字段**并调用***********************************");
            Field name = clazz.getDeclaredField("name");
            Object stu = clazz.newInstance();
            name.set(stu,"宋江");
            System.out.println("name = " + stu);
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
