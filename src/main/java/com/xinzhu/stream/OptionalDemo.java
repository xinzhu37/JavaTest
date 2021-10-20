package com.xinzhu.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Create By GuoFZ on 2021/10/20
 */
public class OptionalDemo {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("SongJia",20000,22,"female","新加坡"));
        personList.add(new Person("CaoYiMen",5000,23,"male","英格兰"));
        personList.add(new Person("LiXinYu",6000,24,"female","法国"));
        personList.add(new Person("ShenBeiNa",8000,25,"male","China"));

        Stream<String> collect = personList.stream().filter(person -> person.getSalary() > 7000).map(Person::getName);
        Set<String> collect1 = collect.collect(Collectors.toSet());
//        collect1.forEach(System.out::println);

        // 字符串中最长的对象
        Optional<Person> max = personList.stream().max(Comparator.comparing(person -> person.getName().length()));
        System.out.println(max.map(person -> person.toString()).get());

        // 薪水最高的对象
        System.out.println(personList.stream().max(Comparator.comparingInt(Person::getSalary)).get().toString());
        System.out.println(personList.stream().map(Person::getSalary).max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }).get());
        System.out.println(personList.stream().max(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                Integer salary1 = o1.getSalary();
                Integer salary2 = o2.getSalary();
                return salary1.compareTo(salary2);
            }
        }).get());

        // 映射，每个人的名字转换为大写
//        personList.stream().map(Person::getName).map(String::toUpperCase).forEach(System.out::println);
        personList.stream().map(person -> {
            person.setName(person.getName().toUpperCase());
            return person;
        }).forEach(System.out::println);
        // 每个人的薪资涨1000
        personList.stream().map(person -> {
            person.setSalary(person.getSalary() + 1000);
            return person;
        }).forEach(System.out::println);

        // 规约，对所有员工求和、最大值、平均值
        Optional<Integer> sum1 = personList.stream().map(Person::getSalary).reduce((x, y) -> x + y);
        System.out.println(sum1.get());
        Optional<Integer> sum2 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println(sum2.get());
        Integer sum3 = personList.stream().map(Person::getSalary).reduce(0, (a, b) -> Integer.sum(a, b));
        System.out.println(sum3);

        Optional<Person> max1 = personList.stream().reduce((x, y) -> {
            Person i = x.getSalary() > y.getSalary() ? x : y;
            return i;
        });
        System.out.println(max1.get().toString());
        // 下面两个方法行不通
//        Person max2 = personList.stream().reduce(1, (a, b) -> {
//            int max3 = Integer.max(a.getSalary(), b.getSalary());
//            return max3;
//        });
//        System.out.println(max2);
//        Optional<Integer> max3 = personList.stream().reduce(Integer::max);
//        System.out.println(max3.get());

//        Optional<Integer> reduce = personList.stream().map(Person::getSalary).reduce();
//        System.out.println(reduce.get());
    }
}
