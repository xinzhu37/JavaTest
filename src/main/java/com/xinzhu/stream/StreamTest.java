package com.xinzhu.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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


    }
}
