package com.xinzhu.transients;

import java.io.Serializable;

/**
 * Create By GuoFZ on 2021/10/18
 */
public class UserInfo implements Serializable{
    private final static long serialVersionUID = 2L;
    public static String name;
    public transient String address;
    public final transient int age = 123;
    public final int RNG = 10086;

    public UserInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
