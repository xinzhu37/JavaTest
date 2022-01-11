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
        personList.add(new Person("CaoYiMen",5000,26,"male","英格兰"));
        personList.add(new Person("LiXinYu",5000,24,"female","法国"));
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

        // 分组，将薪资是否高于8000的分为两部分，按照性别和地区分为两部分
        Map<Boolean, List<Person>> partitioningSalary = personList.stream().collect(Collectors.partitioningBy(person -> person.getSalary() > 8000));
        Map<String, List<Person>> groupingSex = personList.stream().collect(Collectors.groupingBy(person -> person.getSex()));
        Map<String, Map<String, List<Person>>> groupingSexArea = personList.stream().collect(Collectors.groupingBy(Person::getSex,Collectors.groupingBy(Person::getArea)));
        System.out.println("partitioningSalary = " + partitioningSalary);
        System.out.println("groupingSex = " + groupingSex);
        System.out.println("groupingSexArea = " + groupingSexArea);

        // joining接合
        String joinName = personList.stream().map(Person::getName).collect(Collectors.joining("-"));
        System.out.println("joinName = " + joinName);

        // 归集里的规约，相对于Stream里面的规约增加了自定义的
        Integer collect2 = personList.stream().collect(Collectors.reducing(0,Person::getSalary,(x, y) -> x + y - 500));
        System.out.println("collect2 = " + collect2);

        Optional<Integer> reduce = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println("reduce = " + reduce);

        // 排序，先按照薪资排序，在按照年龄排序
        Stream<Person> sortedSalary = personList.stream().sorted(Comparator.comparing(Person::getSalary));
//        sortedSalary.forEach(System.out::println);
        System.out.println("sortedSalary = " + sortedSalary);
        Stream<Person> sortedAge = personList.stream().sorted(Comparator.comparing(Person::getAge).reversed());
//        sortedAge.forEach(System.out::println);
        System.out.println("sortedAge = " + sortedAge);
        Stream<Person> sortedSalaryAge = personList.stream().sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge));
//        sortedSalaryAge.forEach(System.out::println);
        System.out.println("sortedSalaryAge = " + sortedSalaryAge);
        Stream<Person> sortedSalaryAge2 = personList.stream().sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge).reversed());
        sortedSalaryAge2.forEach(System.out::println);
        System.out.println("sortedSalaryAge3 = " + sortedSalaryAge2);
        Stream<Person> sortedSalaryAge3 = personList.stream().sorted((p1,p2) -> {
            if (p1.getSalary() == p2.getSalary()){
                return p2.getAge() - p1.getAge();
            }
            return p1.getSalary() - p2.getSalary();
        });
        sortedSalaryAge3.forEach(System.out::println);
        System.out.println("sortedSalaryAge3 = " + sortedSalaryAge3);

        System.out.println("11111111111111");

    }
}
