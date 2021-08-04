package com.streamproject.demo.testpk;

import com.streamproject.demo.model.Builder;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest2
{

    public static void main(String[] args) {

        ArrayList<Builder> setBuilders2 = new ArrayList<>();
        setBuilders2.add(new Builder("허진호1", "공항동", 500));
        setBuilders2.add(new Builder("허진호1", "마곡동", 250));
        setBuilders2.add(new Builder("허진호1", "등촌동", 100));

        String testStr1 = "허진호1";
        String testStr2 = "허진호2";
        List<Builder> collect = setBuilders2.stream().filter(x -> x.getName().equals(testStr1)).collect(Collectors.toList());

        collect.forEach(i -> System.out.println(i.getAddr()));


        boolean b = setBuilders2.stream().noneMatch(x -> x.getName().equals(testStr1));

        System.out.println(b);

        List<Builder> collect2 = setBuilders2.stream().filter(x -> !x.getName().equals(testStr1)).collect(Collectors.toList());

        collect2.forEach(i -> System.out.println(i.getAddr()));


        Stream<String> stream1 = Stream.of("넷", "둘", "셋", "하나", "1111", "333333");

        Optional<String> result1 = stream1.reduce((s1, s2) -> s1 + "++" + s2);
        result1.ifPresent(System.out::println);


        Stream<Integer> streamInt1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Optional<Integer> reduce = streamInt1.reduce(Integer::sum);

        reduce.ifPresent(System.out::println);



        Stream<Integer> streamInt2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer reduce2 = streamInt2.reduce(10, Integer::sum);

        System.out.println(reduce2);


        // 병렬처리 Reducation
        Stream<Integer> numbers4 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer sum5 = IntStream.range(1, 5000000).parallel().reduce(10, Integer::sum);
        Integer sum6 = IntStream.range(1, 5000000).sum();
//        Integer sum4 = numbers4.parallel().reduce(10, Integer::sum);
//        System.out.println("sum4: " + sum4);
        Optional<Integer> ttt = numbers4.max(Comparator.naturalOrder());
        System.out.println(ttt.get());




        Stream<String> str5 = Stream.of("Java8", "Python3", "GoLang");


        String collect1 = str5.map(String::toUpperCase).collect(Collectors.joining(", "));

        System.out.println(collect1);


        List<String> str6 = Arrays.asList("Java8", "Python3", "GoLang");

        Optional<String> first = str6.stream().findFirst();

        first.ifPresent(System.out::println);


    }





}
