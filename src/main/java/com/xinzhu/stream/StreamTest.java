package com.xinzhu.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Create By GuoFZ on 2021/10/20
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);

        // 打印所有符合的元素
//        list.stream().filter(x -> x > 6).forEach(System.out::println);
        System.out.println(list.stream().filter(x -> x > 6).count());

        Optional<Integer> first = list.stream().filter(X -> X > 6).findFirst();

        Optional<Integer> any = list.parallelStream().filter(x -> x > 6).findAny();

        boolean anyMatch = list.stream().anyMatch(x -> x > 11);
        System.out.println("筛选出的第一个值 = " + first.get());
        System.out.println("并行流筛选出的任意值 = " + any.get());
        System.out.println("anyMatch = " + anyMatch);

        // 使用，将两个字符数组拼接成一个新的字符数组
        List<String> stringList = Arrays.asList("a,b,c", "1,2,3,4");
        List<String> collect = stringList.stream().flatMap(s -> {
            String[] split = s.split(",");
            // 利用数组流，将拆开的散户集合起来
            Stream<String> stream = Arrays.stream(split);
            return stream;
        }).collect(Collectors.toList());
        System.out.println(collect);

        // 规约，对首个list集合求和、积、最大值
        Optional<Integer> sum1 = list.stream().reduce((x, y) -> x + y);
        System.out.println(sum1.get());
        Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
        System.out.println(sum2.get());
        Integer sum3 = list.stream().reduce(0, (a, b) -> Integer.sum(a, b));
        System.out.println(sum3);

        Optional<Integer> product1 = list.stream().reduce((x, y) -> x * y);
        System.out.println(product1.get());

        Optional<Integer> max1 = list.stream().reduce((x, y) -> x > y ? x : y);
        System.out.println(max1.get());
        Integer max2 = list.stream().reduce(1, Integer::max);
        System.out.println(max2);
        Optional<Integer> max3 = list.stream().reduce(Integer::max);
        System.out.println(max3.get());

        Optional<Integer> reduce = list.stream().reduce(Integer::min);
        System.out.println(reduce.get());


        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));

        // 归集，流在处理完数据之后还是个流，最后要将流转换为集合，如list、set、map
        List<Integer> collectList = list.stream().filter(x -> x > 6).collect(Collectors.toList());
        Set<Integer> collectSet = list.stream().filter(x -> x > 6).collect(Collectors.toSet());
        Map<String, Person> personMap = personList.stream().filter(person -> person.getSalary() > 8000).collect(Collectors.toMap(Person::getName, person -> person));
        System.out.println("collectList = " + collectList);
        System.out.println("collectSet = " + collectSet);
        System.out.println("personMap.get(\"Tom\") = " + personMap.get("Tom"));

        personList.stream().collect(Collectors.averagingInt(Person::getSalary));
        System.out.println(personList.stream().collect(Collectors.summingInt(Person::getSalary)));
        System.out.println(personList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Person::getSalary))));
        System.out.println(personList.stream().collect(Collectors.summarizingInt(Person::getSalary)));

        // joining接合
        String collect1 = list.stream().collect(Collectors.toSet()).stream().map(Integer::toUnsignedString).collect(Collectors.joining("-"));
        System.out.println("collect1 = " + collect1);

        // 提取、组合
        String[] arr1 = { "a", "b", "c", "d" };
        String[] arr2 = { "d", "e", "f", "g" };
        Integer[] int3 = {1,2,3,5,6,7,9,10,11,13,14,15,17,18,19};
        List<String> collect2 = Stream.concat(Stream.of(arr1), Stream.of(arr2)).distinct().collect(Collectors.toList());
        System.out.println("collect2 = " + collect2);
        List<Integer> collect3 = Arrays.stream(int3).skip(3).limit(8).collect(Collectors.toList());
        System.out.println("collect3 = " + collect3);
        System.out.println("1111111111111");
        System.out.println("2222222222222");

    }
}
