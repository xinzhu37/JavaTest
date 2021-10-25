package com.xinzhu.clazz;

public class Student2 {
    public Student2(){

    }
    //**********字段*************//
    public String name;
    protected int age;
    char sex;
    private String phoneNum;

    public void show(){
        System.out.println("这是普通方法");
    }

    public void show(String name,Integer age){
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }

    private void show1(){
        System.out.println("这是私有的无参方法");
    }

    private void show1(String name,Integer age){
        System.out.println("这是私有的name = " + name);
        System.out.println("这是私有的age = " + age);
    }
    protected void show2(){
        System.out.println("这是私有的无参方法");
    }

    protected String show2(String name,Integer age){
        System.out.println("这是受保护的name = " + (this.name = name));
        System.out.println("这是受保护的age = " + age);
        return "不念";
    }

    void show3(){
        System.out.println("默认方法");
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", sex=" + sex
                + ", phoneNum=" + phoneNum + "]";
    }

    public static void main(String[] args) {
        System.out.println("this is main Method!");
    }

}
