package com.xinzhu.collectionss;

import com.xinzhu.stream.Person;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Create By GuoFZ on 2021/10/26
 */
public class CollectionDemo {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers,431,132,3443,44);
        System.out.println("integers = " + integers);
        Collections.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println("integers = " + integers);
        Collections.shuffle(integers,new Random(1));
        System.out.println("integers = " + integers);
        int i = "123242".offsetByCodePoints(0, 3);
        


        List<Person> personList = new ArrayList<>();
        personList.add(new Person("SongJia",20000,22,"female","新加坡"));
        personList.add(new Person("CaoYiMen",5000,26,"male","英格兰"));
        personList.add(new Person("LiXinYu",5000,24,"female","法国"));
        personList.add(new Person("ShenBeiNa",8000,25,"male","China"));

        Map<String, String> collect = personList.stream().collect(Collectors.toMap(Person::getName, Person::getArea));
        System.out.println("collect = " + collect);
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getSalary() - o2.getSalary();
            }
        });
        System.out.println("personList = " + personList);
        personList.sort(Person::compareTo);
        System.out.println("personList = " + personList);

    }
}
