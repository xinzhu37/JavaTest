package com.xinzhu.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Create By GuoFZ on 2021/10/20
 */
public class CreateStream {
    public static void main(String[] args) {
        // 先创建一个集合
        List<String> list = Arrays.asList("wo", "是", "中国人", "bbb");

        // 创建普通顺序流或创建并行流
        Stream<String> listStream = list.stream();
//        listStream.forEach(System.out::println);
        Stream<String> listParallelStream = list.parallelStream();

        // 用数组直接创建流
        int[] arr = {1,2,3,4};
        IntStream stream = Arrays.stream(arr);

        Stream<Integer> streamOf = Stream.of(1, 2, 3, 4, 5, 6);
        Optional<Integer> first = streamOf.parallel().filter(x -> x > 5).findFirst();
        System.out.println(first.isPresent());
        Stream<Integer> streamIterate = Stream.iterate(0, x -> x + 3).limit(8);
//        streamIterate.forEach(System.out::println);

//        Stream.generate(Math::random).limit(6).forEach(System.out::println);
    }
}
