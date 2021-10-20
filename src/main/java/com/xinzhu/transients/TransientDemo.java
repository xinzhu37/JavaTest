package com.xinzhu.transients;

import java.io.*;
import java.util.ArrayList;

/**
 * Create By GuoFZ on 2021/10/18
 */
public class TransientDemo {
    public static void main(String[] args) {
        // 创建用户对象
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setName("zhangSan");
        userInfo1.setAddress("上海市浦东新区");
//        userInfo1.setAge(23);
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setName("liSi");
        userInfo2.setAddress("海南省三亚市");
//        userInfo2.setAge(24);
        UserInfo userInfo3 = new UserInfo();
        userInfo3.setName("Jack");
        userInfo3.setAddress("新疆维吾尔自治区");
//        userInfo3.setAge(25);

        // 对象放到集合里面
        ArrayList<UserInfo> userInfos = new ArrayList<>();
        userInfos.add(userInfo1);
        userInfos.add(userInfo2);
        userInfos.add(userInfo3);

        FileOutputStream fos = null;
        try {
            // 创建对象流
            fos = new FileOutputStream("TransientDemo.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userInfos);
            System.out.println("save serializer success!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 反序列化之前先改变static、final关键字修饰的变量
//        userInfo1. = 23;


        // fan序列化
        FileInputStream fis = null;
        try {
            // 创建对象流
            fis = new FileInputStream("TransientDemo.txt");
            ObjectInputStream oos = new ObjectInputStream(fis);
            ArrayList<UserInfo> users = (ArrayList) oos.readObject();
            for (UserInfo user : users) {
                System.out.println(user.toString());
            }
            System.out.println("read serializer success!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
