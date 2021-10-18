package com.xinzhu.io;

import java.io.Serializable;

/**
 * Create By GuoFZ on 2021/10/18
 */
public class Employee implements Serializable {
    public static final long serialVersionUID = 1L;
    public String name;
    public String address;
    public transient int age;

    public Employee() {
    }
    public void addressCheck() {
        System.out.println("地址  check : " + name + " -- " + address + " -- " + age);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //    public static void main(String[] args) {
//        // ����һ��ʵ�������
//        Employee employee = new Employee();
//        employee.name = "zhangSan";
//        employee.address = "�Ϻ����ֶ�����";
//        employee.age = 23;
//
//        employee.addressCheck();
//    }
}
