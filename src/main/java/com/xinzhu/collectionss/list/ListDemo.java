package com.xinzhu.collectionss.list;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Create By GuoFZ on 2021/10/26
 */
public class ListDemo {
    public static void main(String[] args) {
        // 创建list集合
        List<String> list = new ArrayList<>();

        // 先初始化数据
        list.add("李清照");
        list.add("辛弃疾");
        list.add("断离舍");
        list.add("周树人");

        // 添加，而不是替换原有的索引对应的值
        list.add(2,"沈从文");

        List<String> listCopy = new ArrayList<>();
        listCopy.add("苏轼");
        listCopy.add("苏辙");

        list.addAll(3,listCopy);

        boolean contains = list.contains("苏轼");
        System.out.println("contains = " + contains);

        List<String> listCopy2 = new ArrayList<>();
        listCopy2.add("李清照");
        listCopy2.add("苏辙");

        boolean containsAll = list.containsAll(listCopy2);
        System.out.println("containsAll = " + containsAll);

        System.out.println("list.get(5) = " + list.get(5));

        // 这个相当于替换某个索引值得方法
        list.set(5,"老舍");
        System.out.println("list.equals(listCopy2) = " + list.equals(list));

//        list.replaceAll();
//        System.out.println("list.retainAll(listCopy) = " + list.retainAll(listCopy));
        // 包左不包右
        System.out.println("list.subList(3,5) = " + list.subList(3, 5));
        list.remove("周树人");
        list.remove(5);
        System.out.println("list = " + list);
    }
}
