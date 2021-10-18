package com.xinzhu.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import java.util.Set;

/**
 * Create By GuoFZ on 2021/10/18
 */
public class ProDemo {
    public static void main(String[] args) throws IOException {
        // 创建一个属性对象
        Properties properties = new Properties();
        // 添加键值对元素
        properties.setProperty("filename", "a.txt");
        properties.setProperty("length", "209385038");
        properties.setProperty("location", "D:\\a.txt");

        System.out.println("properties = " + properties);

        // 通过key查询值
        System.out.println(properties.getProperty("filename"));
        System.out.println(properties.getProperty("length"));
        System.out.println(properties.getProperty("location"));

        Properties properties1 = new Properties();

        System.out.println("---------------------------------");
        FileInputStream fileInputStream =null;
        try {
            fileInputStream = new FileInputStream("pro.txt");
            properties1.load(fileInputStream);
            Set<String> strings = properties.stringPropertyNames();

            for (String key : strings) {
                System.out.println(key + "--" + properties.getProperty(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
        }

    }
}
